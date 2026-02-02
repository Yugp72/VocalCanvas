package com.vocalcanvas.android.data.local;

import androidx.room.*;
import com.vocalcanvas.android.model.VocalMessage;
import io.reactivex.Observable;
import io.reactivex.Single;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\tH\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\f\u001a\u00020\rH\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/vocalcanvas/android/data/local/VocalMessageDao;", "", "deleteAllMessages", "Lio/reactivex/Single;", "", "deleteMessage", "message", "Lcom/vocalcanvas/android/model/VocalMessage;", "getAllMessages", "Lio/reactivex/Observable;", "", "getMessageById", "id", "", "insertMessage", "insertMessages", "messages", "updateMessage", "app_debug"})
@androidx.room.Dao
public abstract interface VocalMessageDao {
    
    @androidx.room.Query(value = "SELECT * FROM vocal_messages ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Observable<java.util.List<com.vocalcanvas.android.model.VocalMessage>> getAllMessages();
    
    @androidx.room.Query(value = "SELECT * FROM vocal_messages WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Single<com.vocalcanvas.android.model.VocalMessage> getMessageById(long id);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Single<java.lang.Long> insertMessage(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.model.VocalMessage message);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Single<java.util.List<java.lang.Long>> insertMessages(@org.jetbrains.annotations.NotNull
    java.util.List<com.vocalcanvas.android.model.VocalMessage> messages);
    
    @androidx.room.Update
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Single<java.lang.Integer> updateMessage(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.model.VocalMessage message);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Single<java.lang.Integer> deleteMessage(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.model.VocalMessage message);
    
    @androidx.room.Query(value = "DELETE FROM vocal_messages")
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Single<java.lang.Integer> deleteAllMessages();
}