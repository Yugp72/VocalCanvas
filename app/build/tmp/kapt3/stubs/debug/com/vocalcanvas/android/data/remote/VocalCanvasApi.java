package com.vocalcanvas.android.data.remote;

import com.vocalcanvas.android.model.VocalMessage;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\u00032\b\b\u0003\u0010\n\u001a\u00020\u000bH\'\u00a8\u0006\f"}, d2 = {"Lcom/vocalcanvas/android/data/remote/VocalCanvasApi;", "", "getAiResponse", "Lio/reactivex/Observable;", "Lcom/vocalcanvas/android/model/VocalMessage;", "prompt", "", "getFinancialData", "streamMessages", "", "limit", "", "app_debug"})
public abstract interface VocalCanvasApi {
    
    @retrofit2.http.GET(value = "messages/stream")
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Observable<java.util.List<com.vocalcanvas.android.model.VocalMessage>> streamMessages(@retrofit2.http.Query(value = "limit")
    int limit);
    
    @retrofit2.http.GET(value = "messages/financial")
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Observable<com.vocalcanvas.android.model.VocalMessage> getFinancialData();
    
    @retrofit2.http.GET(value = "messages/ai")
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Observable<com.vocalcanvas.android.model.VocalMessage> getAiResponse(@retrofit2.http.Query(value = "prompt")
    @org.jetbrains.annotations.NotNull
    java.lang.String prompt);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}