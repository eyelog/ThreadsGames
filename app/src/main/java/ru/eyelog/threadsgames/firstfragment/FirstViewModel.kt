package ru.eyelog.threadsgames.firstfragment

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<String> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<String>()


}