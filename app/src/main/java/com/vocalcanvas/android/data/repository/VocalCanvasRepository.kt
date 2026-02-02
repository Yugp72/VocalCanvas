package com.vocalcanvas.android.data.repository

import com.vocalcanvas.android.data.local.VocalMessageDao
import com.vocalcanvas.android.data.remote.VocalCanvasApi
import com.vocalcanvas.android.model.VocalMessage
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VocalCanvasRepository @Inject constructor(
    private val api: VocalCanvasApi,
    private val dao: VocalMessageDao
) {
    
    /**
     * Streams messages from API and caches them locally
     */
    fun streamAndCacheMessages(limit: Int = 10): Observable<List<VocalMessage>> {
        return api.streamMessages(limit)
            .flatMap { messages ->
                // Cache messages in Room
                dao.insertMessages(messages)
                    .toObservable()
                    .map { messages }
            }
            .onErrorResumeNext(Observable.defer {
                // Fallback to local cache if network fails
                dao.getAllMessages()
                    .firstOrError()
                    .toObservable()
                    .onErrorReturn { emptyList() }
            })
    }
    
    /**
     * Get all cached messages from Room
     */
    fun getAllCachedMessages(): Observable<List<VocalMessage>> {
        return dao.getAllMessages()
    }
    
    /**
     * Update message position (for draggable UI)
     */
    fun updateMessagePosition(message: VocalMessage): Completable {
        return dao.updateMessage(message)
            .ignoreElement()
    }
    
    /**
     * Get financial data
     */
    fun getFinancialData(): Observable<VocalMessage> {
        return api.getFinancialData()
            .flatMap { message ->
                dao.insertMessage(message)
                    .toObservable()
                    .map { message }
            }
    }
    
    /**
     * Get AI response
     */
    fun getAiResponse(prompt: String): Observable<VocalMessage> {
        return api.getAiResponse(prompt)
            .flatMap { message ->
                dao.insertMessage(message)
                    .toObservable()
                    .map { message }
            }
    }
    
    /**
     * Clear all cached messages
     */
    fun clearCache(): Completable {
        return dao.deleteAllMessages()
            .ignoreElement()
    }
}

