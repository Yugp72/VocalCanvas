package com.vocalcanvas.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.vocalcanvas.android.R;
import com.vocalcanvas.android.model.MessageType;
import com.vocalcanvas.android.model.VocalMessage;

/**
 * A non-linear, interactive canvas view that allows users to drag and arrange messages
 * in a 2D space. This demonstrates innovative UI/UX beyond traditional linear chat interfaces.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015H\u0002J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\"2\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002J\b\u0010\'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0014\u0010-\u001a\u00020\u001a2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017J\u001a\u0010/\u001a\u00020\u001a2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/vocalcanvas/android/ui/DraggableCanvasView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardHeight", "", "cardPadding", "cardPaint", "Landroid/graphics/Paint;", "cardRect", "Landroid/graphics/Rect;", "cardWidth", "cornerRadius", "dragOffsetX", "dragOffsetY", "draggedMessage", "Lcom/vocalcanvas/android/model/VocalMessage;", "messages", "", "onMessagePositionChanged", "Lkotlin/Function1;", "", "textPaint", "drawGrid", "canvas", "Landroid/graphics/Canvas;", "drawMessageCard", "message", "getMessagePosition", "Lkotlin/Pair;", "handleTouchDown", "x", "y", "handleTouchMove", "handleTouchUp", "onDraw", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setMessages", "newMessages", "setOnMessagePositionChangedListener", "listener", "app_debug"})
public final class DraggableCanvasView extends android.view.View {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.vocalcanvas.android.model.VocalMessage> messages;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.vocalcanvas.android.model.VocalMessage, kotlin.Unit> onMessagePositionChanged;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint cardPaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint textPaint = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Rect cardRect = null;
    @org.jetbrains.annotations.Nullable
    private com.vocalcanvas.android.model.VocalMessage draggedMessage;
    private float dragOffsetX = 0.0F;
    private float dragOffsetY = 0.0F;
    private final float cardWidth = 400.0F;
    private final float cardHeight = 200.0F;
    private final float cardPadding = 20.0F;
    private final float cornerRadius = 16.0F;
    
    @kotlin.jvm.JvmOverloads
    public DraggableCanvasView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public final void setMessages(@org.jetbrains.annotations.NotNull
    java.util.List<com.vocalcanvas.android.model.VocalMessage> newMessages) {
    }
    
    private final kotlin.Pair<java.lang.Float, java.lang.Float> getMessagePosition(com.vocalcanvas.android.model.VocalMessage message) {
        return null;
    }
    
    public final void setOnMessagePositionChangedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.vocalcanvas.android.model.VocalMessage, kotlin.Unit> listener) {
    }
    
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    private final void drawGrid(android.graphics.Canvas canvas) {
    }
    
    private final void drawMessageCard(android.graphics.Canvas canvas, com.vocalcanvas.android.model.VocalMessage message) {
    }
    
    @java.lang.Override
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull
    android.view.MotionEvent event) {
        return false;
    }
    
    private final void handleTouchDown(float x, float y) {
    }
    
    private final void handleTouchMove(float x, float y) {
    }
    
    private final void handleTouchUp() {
    }
    
    @kotlin.jvm.JvmOverloads
    public DraggableCanvasView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public DraggableCanvasView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
}