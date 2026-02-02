package com.vocalcanvas.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vocalcanvas.android.data.repository.VocalCanvasRepository
import com.vocalcanvas.android.model.VocalMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class VocalCanvasViewModel @Inject constructor(
    private val repository: VocalCanvasRepository
) : ViewModel() {
    
    private val disposables = CompositeDisposable()
    
    private val _messages = MutableLiveData<List<VocalMessage>>()
    val messages: LiveData<List<VocalMessage>> = _messages
    
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    init {
        loadMessages()
    }
    
    fun loadMessages() {
        _loading.value = true
        _error.value = null
        
        val disposable = repository.streamAndCacheMessages(limit = 20)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { messageList ->
                    _messages.value = messageList
                    _loading.value = false
                },
                { throwable ->
                    _error.value = throwable.message ?: "Unknown error"
                    _loading.value = false
                    // Fallback to cached messages
                    loadCachedMessages()
                }
            )
        
        disposables.add(disposable)
    }
    
    fun loadCachedMessages() {
        val disposable = repository.getAllCachedMessages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { messageList ->
                    _messages.value = messageList
                },
                { throwable ->
                    _error.value = throwable.message ?: "Error loading cached messages"
                }
            )
        
        disposables.add(disposable)
    }
    
    fun updateMessagePosition(message: VocalMessage) {
        val disposable = repository.updateMessagePosition(message)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { },
                { throwable ->
                    _error.value = throwable.message ?: "Error updating message position"
                }
            )
        
        disposables.add(disposable)
    }
    
    fun requestFinancialData() {
        val disposable = repository.getFinancialData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { message ->
                    val currentMessages = _messages.value?.toMutableList() ?: mutableListOf()
                    currentMessages.add(0, message)
                    _messages.value = currentMessages
                },
                { throwable ->
                    _error.value = throwable.message ?: "Error fetching financial data"
                }
            )
        
        disposables.add(disposable)
    }
    
    fun requestAiResponse(prompt: String) {
        val disposable = repository.getAiResponse(prompt)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { message ->
                    val currentMessages = _messages.value?.toMutableList() ?: mutableListOf()
                    currentMessages.add(0, message)
                    _messages.value = currentMessages
                },
                { throwable ->
                    _error.value = throwable.message ?: "Error fetching AI response"
                }
            )
        
        disposables.add(disposable)
    }
    
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}

