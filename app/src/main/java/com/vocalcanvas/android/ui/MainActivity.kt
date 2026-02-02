package com.vocalcanvas.android.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vocalcanvas.android.R
import com.vocalcanvas.android.VocalCanvasApplication
import com.vocalcanvas.android.viewmodel.VocalCanvasViewModel
import com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory

class MainActivity : AppCompatActivity() {
    
    private lateinit var viewModel: VocalCanvasViewModel
    private lateinit var canvasView: DraggableCanvasView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Inject dependencies and get ViewModelFactory
        val appComponent = (application as VocalCanvasApplication).appComponent
        appComponent.inject(this)
        
        val factory = appComponent.viewModelFactory()
        viewModel = ViewModelProvider(this, factory)[VocalCanvasViewModel::class.java]
        
        setContentView(R.layout.activity_main)
        
        canvasView = findViewById(R.id.canvasView)
        val fabRefresh = findViewById<FloatingActionButton>(R.id.fabRefresh)
        
        setupObservers()
        setupCanvasListeners()
        
        fabRefresh.setOnClickListener {
            viewModel.loadMessages()
        }
    }
    
    private fun setupObservers() {
        viewModel.messages.observe(this, Observer { messages ->
            canvasView.setMessages(messages)
        })
        
        viewModel.loading.observe(this, Observer { isLoading ->
            // Handle loading state if needed
        })
        
        viewModel.error.observe(this, Observer { errorMessage ->
            errorMessage?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }
    
    private fun setupCanvasListeners() {
        canvasView.setOnMessagePositionChangedListener { message ->
            viewModel.updateMessagePosition(message)
        }
    }
}

