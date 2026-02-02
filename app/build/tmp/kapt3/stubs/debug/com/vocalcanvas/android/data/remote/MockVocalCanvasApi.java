package com.vocalcanvas.android.data.remote;

import com.vocalcanvas.android.model.MessageType;
import com.vocalcanvas.android.model.VocalMessage;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

/**
 * Mock implementation of VocalCanvasApi for demonstration purposes.
 * In a real app, this would be replaced by actual Retrofit API calls.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/vocalcanvas/android/data/remote/MockVocalCanvasApi;", "Lcom/vocalcanvas/android/data/remote/VocalCanvasApi;", "()V", "aiResponseTemplates", "", "", "financialDataTemplates", "createWelcomeMessage", "Lcom/vocalcanvas/android/model/VocalMessage;", "getAiResponse", "Lio/reactivex/Observable;", "prompt", "getFinancialData", "streamMessages", "limit", "", "app_debug"})
public final class MockVocalCanvasApi implements com.vocalcanvas.android.data.remote.VocalCanvasApi {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> financialDataTemplates = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> aiResponseTemplates = null;
    
    public MockVocalCanvasApi() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public io.reactivex.Observable<java.util.List<com.vocalcanvas.android.model.VocalMessage>> streamMessages(int limit) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public io.reactivex.Observable<com.vocalcanvas.android.model.VocalMessage> getFinancialData() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public io.reactivex.Observable<com.vocalcanvas.android.model.VocalMessage> getAiResponse(@org.jetbrains.annotations.NotNull
    java.lang.String prompt) {
        return null;
    }
    
    private final com.vocalcanvas.android.model.VocalMessage createWelcomeMessage() {
        return null;
    }
}