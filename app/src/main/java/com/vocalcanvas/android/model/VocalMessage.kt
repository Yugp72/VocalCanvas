package com.vocalcanvas.android.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "vocal_messages")
data class VocalMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @SerializedName("content")
    val content: String,
    
    @SerializedName("type")
    val type: MessageType,
    
    @SerializedName("timestamp")
    val timestamp: Long = System.currentTimeMillis(),
    
    @SerializedName("x_position")
    var xPosition: Float = 0f,
    
    @SerializedName("y_position")
    var yPosition: Float = 0f,
    
    @SerializedName("is_ai_response")
    val isAiResponse: Boolean = false
)

enum class MessageType {
    FINANCIAL_DATA,
    AI_RESPONSE,
    USER_INPUT,
    SYSTEM_NOTIFICATION
}

