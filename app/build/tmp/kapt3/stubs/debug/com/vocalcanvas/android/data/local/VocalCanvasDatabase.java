package com.vocalcanvas.android.data.local;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.vocalcanvas.android.model.VocalMessage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/vocalcanvas/android/data/local/VocalCanvasDatabase;", "Landroidx/room/RoomDatabase;", "()V", "vocalMessageDao", "Lcom/vocalcanvas/android/data/local/VocalMessageDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.vocalcanvas.android.model.VocalMessage.class}, version = 1, exportSchema = false)
public abstract class VocalCanvasDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DATABASE_NAME = "vocal_canvas_db";
    @org.jetbrains.annotations.NotNull
    public static final com.vocalcanvas.android.data.local.VocalCanvasDatabase.Companion Companion = null;
    
    public VocalCanvasDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.vocalcanvas.android.data.local.VocalMessageDao vocalMessageDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/vocalcanvas/android/data/local/VocalCanvasDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}