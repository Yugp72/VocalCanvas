package com.vocalcanvas.android.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vocalcanvas.android.model.VocalMessage

@Database(
    entities = [VocalMessage::class],
    version = 1,
    exportSchema = false
)
abstract class VocalCanvasDatabase : RoomDatabase() {
    
    abstract fun vocalMessageDao(): VocalMessageDao
    
    companion object {
        const val DATABASE_NAME = "vocal_canvas_db"
    }
}

