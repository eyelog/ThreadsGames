package ru.eyelog.threadsgames.thirdfragment

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class ThirdViewModel: ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    fun setData(){
        val data = listOf("One", "Two", "Three")

        Handler(Looper.getMainLooper())
                .postDelayed({
                    _sampleLiveData.value = data
                }, 1000)

    }

}
