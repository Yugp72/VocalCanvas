package com.vocalcanvas.android.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.vocalcanvas.android.R
import com.vocalcanvas.android.model.MessageType
import com.vocalcanvas.android.model.VocalMessage
import kotlin.math.sqrt

/**
 * A non-linear, interactive canvas view that allows users to drag and arrange messages
 * in a 2D space. This demonstrates innovative UI/UX beyond traditional linear chat interfaces.
 */
class DraggableCanvasView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    
    private var messages: List<VocalMessage> = emptyList()
    private var onMessagePositionChanged: ((VocalMessage) -> Unit)? = null
    
    private val cardPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }
    
    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 48f
        color = ContextCompat.getColor(context, R.color.text_primary)
    }
    
    private val cardRect = Rect()
    private var draggedMessage: VocalMessage? = null
    private var dragOffsetX = 0f
    private var dragOffsetY = 0f
    
    private val cardWidth = 400f
    private val cardHeight = 200f
    private val cardPadding = 20f
    private val cornerRadius = 16f
    
    fun setMessages(newMessages: List<VocalMessage>) {
        messages = newMessages
        invalidate()
    }
    
    private fun getMessagePosition(message: VocalMessage): Pair<Float, Float> {
        val index = messages.indexOf(message)
        val cols = 3
        val col = index % cols
        val row = index / cols
        
        val x = if (message.xPosition > 0) {
            message.xPosition
        } else {
            (width / (cols + 1)) * (col + 1).toFloat()
        }
        
        val y = if (message.yPosition > 0) {
            message.yPosition
        } else {
            (height / 4) + (row * 250f)
        }
        
        return Pair(x, y)
    }
    
    fun setOnMessagePositionChangedListener(listener: (VocalMessage) -> Unit) {
        onMessagePositionChanged = listener
    }
    
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        // Draw background grid pattern for visual interest
        drawGrid(canvas)
        
        // Draw each message as a draggable card
        messages.forEach { message ->
            drawMessageCard(canvas, message)
        }
    }
    
    private fun drawGrid(canvas: Canvas) {
        val gridPaint = Paint().apply {
            color = ContextCompat.getColor(context, R.color.text_secondary)
            alpha = 30
            strokeWidth = 2f
        }
        
        val gridSpacing = 100f
        var x = 0f
        while (x < width) {
            canvas.drawLine(x, 0f, x, height.toFloat(), gridPaint)
            x += gridSpacing
        }
        
        var y = 0f
        while (y < height) {
            canvas.drawLine(0f, y, width.toFloat(), y, gridPaint)
            y += gridSpacing
        }
    }
    
    private fun drawMessageCard(canvas: Canvas, message: VocalMessage) {
        // Get message position (either saved or calculated from grid)
        val (baseX, baseY) = getMessagePosition(message)
        
        // Adjust for drag offset if this is the dragged message
        val drawX = if (message == draggedMessage) {
            baseX + dragOffsetX
        } else {
            baseX
        }
        
        val drawY = if (message == draggedMessage) {
            baseY + dragOffsetY
        } else {
            baseY
        }
        
        // Set card color based on message type
        cardPaint.color = when (message.type) {
            MessageType.FINANCIAL_DATA -> ContextCompat.getColor(context, R.color.primary)
            MessageType.AI_RESPONSE -> ContextCompat.getColor(context, R.color.accent)
            MessageType.USER_INPUT -> ContextCompat.getColor(context, R.color.teal_700)
            MessageType.SYSTEM_NOTIFICATION -> ContextCompat.getColor(context, R.color.purple_500)
        }
        
        // Draw rounded rectangle card
        cardRect.set(
            (drawX - cardWidth / 2).toInt(),
            (drawY - cardHeight / 2).toInt(),
            (drawX + cardWidth / 2).toInt(),
            (drawY + cardHeight / 2).toInt()
        )
        
        canvas.drawRoundRect(
            cardRect.left.toFloat(),
            cardRect.top.toFloat(),
            cardRect.right.toFloat(),
            cardRect.bottom.toFloat(),
            cornerRadius,
            cornerRadius,
            cardPaint
        )
        
        // Draw text (with word wrapping)
        textPaint.color = ContextCompat.getColor(context, R.color.white)
        val textBounds = Rect()
        val text = message.content
        textPaint.getTextBounds(text, 0, text.length, textBounds)
        
        // Simple text drawing (in production, use StaticLayout for proper wrapping)
        val lines = text.chunked(30) // Simple line breaking
        lines.forEachIndexed { index, line ->
            val textY = drawY + (index - lines.size / 2) * 60f
            canvas.drawText(
                line,
                drawX - textPaint.measureText(line) / 2,
                textY,
                textPaint
            )
        }
    }
    
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                handleTouchDown(event.x, event.y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                handleTouchMove(event.x, event.y)
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                handleTouchUp()
                return true
            }
        }
        return super.onTouchEvent(event)
    }
    
    private fun handleTouchDown(x: Float, y: Float) {
        // Find which message card was touched
        messages.forEach { message ->
            val (msgX, msgY) = getMessagePosition(message)
            
            val distance = sqrt(
                (x - msgX) * (x - msgX) + (y - msgY) * (y - msgY)
            )
            
            if (distance < cardWidth / 2) {
                draggedMessage = message
                dragOffsetX = x - msgX
                dragOffsetY = y - msgY
                invalidate()
                return
            }
        }
    }
    
    private fun handleTouchMove(x: Float, y: Float) {
        draggedMessage?.let { message ->
            invalidate()
        }
    }
    
    private fun handleTouchUp() {
        draggedMessage?.let { message ->
            val (newX, newY) = getMessagePosition(message)
            
            val finalX = newX + dragOffsetX
            val finalY = newY + dragOffsetY
            
            // Update message position
            val updatedMessage = message.copy(
                xPosition = finalX.coerceIn(cardWidth / 2, width - cardWidth / 2),
                yPosition = finalY.coerceIn(cardHeight / 2, height - cardHeight / 2)
            )
            
            onMessagePositionChanged?.invoke(updatedMessage)
            
            draggedMessage = null
            dragOffsetX = 0f
            dragOffsetY = 0f
            invalidate()
        }
    }
}

