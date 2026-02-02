package com.vocalcanvas.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vocalcanvas.android.data.repository.VocalCanvasRepository
import javax.inject.Inject

class VocalCanvasViewModelFactory @Inject constructor(
    private val repository: VocalCanvasRepository
) : ViewModelProvider.Factory {
    
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VocalCanvasViewModel::class.java)) {
            return VocalCanvasViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

