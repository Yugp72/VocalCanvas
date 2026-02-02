package com.vocalcanvas.android.data.remote

import com.vocalcanvas.android.model.VocalMessage
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface VocalCanvasApi {
    
    @GET("messages/stream")
    fun streamMessages(
        @Query("limit") limit: Int = 10
    ): Observable<List<VocalMessage>>
    
    @GET("messages/financial")
    fun getFinancialData(): Observable<VocalMessage>
    
    @GET("messages/ai")
    fun getAiResponse(
        @Query("prompt") prompt: String
    ): Observable<VocalMessage>
}

