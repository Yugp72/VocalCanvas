package com.vocalcanvas.android.data.repository;

import com.vocalcanvas.android.data.local.VocalMessageDao;
import com.vocalcanvas.android.data.remote.VocalCanvasApi;
import com.vocalcanvas.android.model.VocalMessage;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f0\nJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f0\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/vocalcanvas/android/data/repository/VocalCanvasRepository;", "", "api", "Lcom/vocalcanvas/android/data/remote/VocalCanvasApi;", "dao", "Lcom/vocalcanvas/android/data/local/VocalMessageDao;", "(Lcom/vocalcanvas/android/data/remote/VocalCanvasApi;Lcom/vocalcanvas/android/data/local/VocalMessageDao;)V", "clearCache", "Lio/reactivex/Completable;", "getAiResponse", "Lio/reactivex/Observable;", "Lcom/vocalcanvas/android/model/VocalMessage;", "prompt", "", "getAllCachedMessages", "", "getFinancialData", "streamAndCacheMessages", "limit", "", "updateMessagePosition", "message", "app_debug"})
public final class VocalCanvasRepository {
    @org.jetbrains.annotations.NotNull
    private final com.vocalcanvas.android.data.remote.VocalCanvasApi api = null;
    @org.jetbrains.annotations.NotNull
    private final com.vocalcanvas.android.data.local.VocalMessageDao dao = null;
    
    @javax.inject.Inject
    public VocalCanvasRepository(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.data.remote.VocalCanvasApi api, @org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.data.local.VocalMessageDao dao) {
        super();
    }
    
    /**
     * Streams messages from API and caches them locally
     */
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Observable<java.util.List<com.vocalcanvas.android.model.VocalMessage>> streamAndCacheMessages(int limit) {
        return null;
    }
    
    /**
     * Get all cached messages from Room
     */
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Observable<java.util.List<com.vocalcanvas.android.model.VocalMessage>> getAllCachedMessages() {
        return null;
    }
    
    /**
     * Update message position (for draggable UI)
     */
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Completable updateMessagePosition(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.model.VocalMessage message) {
        return null;
    }
    
    /**
     * Get financial data
     */
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Observable<com.vocalcanvas.android.model.VocalMessage> getFinancialData() {
        return null;
    }
    
    /**
     * Get AI response
     */
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Observable<com.vocalcanvas.android.model.VocalMessage> getAiResponse(@org.jetbrains.annotations.NotNull
    java.lang.String prompt) {
        return null;
    }
    
    /**
     * Clear all cached messages
     */
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Completable clearCache() {
        return null;
    }
}