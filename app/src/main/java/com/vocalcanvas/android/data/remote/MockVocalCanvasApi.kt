package com.vocalcanvas.android.data.remote

import com.vocalcanvas.android.model.MessageType
import com.vocalcanvas.android.model.VocalMessage
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Mock implementation of VocalCanvasApi for demonstration purposes.
 * In a real app, this would be replaced by actual Retrofit API calls.
 */
class MockVocalCanvasApi : VocalCanvasApi {
    
    private val financialDataTemplates = listOf(
        "AAPL: $175.23 (+2.3%)",
        "TSLA: $245.67 (-1.2%)",
        "MSFT: $378.45 (+0.8%)",
        "GOOGL: $142.89 (+1.5%)",
        "AMZN: $148.32 (-0.5%)"
    )
    
    private val aiResponseTemplates = listOf(
        "Based on current market trends, I recommend a diversified portfolio approach.",
        "The technical indicators suggest a bullish pattern forming.",
        "Consider rebalancing your portfolio to maintain your target allocation.",
        "Market volatility is expected to increase in the coming weeks.",
        "Your risk tolerance aligns well with growth-oriented investments."
    )
    
    override fun streamMessages(limit: Int): Observable<List<VocalMessage>> {
        val welcomeMessage = mutableListOf(createWelcomeMessage())
        return Observable.interval(2, TimeUnit.SECONDS)
            .take(limit.toLong())
            .map { index ->
                val messages = mutableListOf<VocalMessage>()
                
                // Generate financial data
                if (index % 2 == 0L) {
                    messages.add(
                        VocalMessage(
                            content = financialDataTemplates[(index % financialDataTemplates.size).toInt()],
                            type = MessageType.FINANCIAL_DATA,
                            timestamp = System.currentTimeMillis() + index * 1000,
                            isAiResponse = false
                        )
                    )
                }
                
                // Generate AI response
                if (index % 3 == 0L) {
                    messages.add(
                        VocalMessage(
                            content = aiResponseTemplates[(index % aiResponseTemplates.size).toInt()],
                            type = MessageType.AI_RESPONSE,
                            timestamp = System.currentTimeMillis() + index * 1000 + 500,
                            isAiResponse = true
                        )
                    )
                }
                
                messages.toList()
            }
            .startWith(welcomeMessage.toList())
    }
    
    override fun getFinancialData(): Observable<VocalMessage> {
        val randomData = financialDataTemplates.random()
        return Observable.just(
            VocalMessage(
                content = randomData,
                type = MessageType.FINANCIAL_DATA,
                timestamp = System.currentTimeMillis(),
                isAiResponse = false
            )
        ).delay(500, TimeUnit.MILLISECONDS)
    }
    
    override fun getAiResponse(prompt: String): Observable<VocalMessage> {
        val response = "AI Response to: $prompt\n\n${aiResponseTemplates.random()}"
        return Observable.just(
            VocalMessage(
                content = response,
                type = MessageType.AI_RESPONSE,
                timestamp = System.currentTimeMillis(),
                isAiResponse = true
            )
        ).delay(1, TimeUnit.SECONDS)
    }
    
    private fun createWelcomeMessage(): VocalMessage {
        return VocalMessage(
            content = "Welcome to VocalCanvas! Drag messages around the canvas to explore.",
            type = MessageType.SYSTEM_NOTIFICATION,
            timestamp = System.currentTimeMillis(),
            isAiResponse = false
        )
    }
}

