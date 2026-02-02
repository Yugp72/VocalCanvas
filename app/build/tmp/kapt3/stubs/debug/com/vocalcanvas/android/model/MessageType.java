package com.vocalcanvas.android.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/vocalcanvas/android/model/MessageType;", "", "(Ljava/lang/String;I)V", "FINANCIAL_DATA", "AI_RESPONSE", "USER_INPUT", "SYSTEM_NOTIFICATION", "app_debug"})
public enum MessageType {
    /*public static final*/ FINANCIAL_DATA /* = new FINANCIAL_DATA() */,
    /*public static final*/ AI_RESPONSE /* = new AI_RESPONSE() */,
    /*public static final*/ USER_INPUT /* = new USER_INPUT() */,
    /*public static final*/ SYSTEM_NOTIFICATION /* = new SYSTEM_NOTIFICATION() */;
    
    MessageType() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vocalcanvas.android.model.MessageType> getEntries() {
        return null;
    }
}