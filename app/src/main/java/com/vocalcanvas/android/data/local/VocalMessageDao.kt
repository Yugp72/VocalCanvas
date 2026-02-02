package com.vocalcanvas.android.data.local

import androidx.room.*
import com.vocalcanvas.android.model.VocalMessage
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface VocalMessageDao {
    
    @Query("SELECT * FROM vocal_messages ORDER BY timestamp DESC")
    fun getAllMessages(): Observable<List<VocalMessage>>
    
    @Query("SELECT * FROM vocal_messages WHERE id = :id")
    fun getMessageById(id: Long): Single<VocalMessage>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessage(message: VocalMessage): Single<Long>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessages(messages: List<VocalMessage>): Single<List<Long>>
    
    @Update
    fun updateMessage(message: VocalMessage): Single<Int>
    
    @Delete
    fun deleteMessage(message: VocalMessage): Single<Int>
    
    @Query("DELETE FROM vocal_messages")
    fun deleteAllMessages(): Single<Int>
}

