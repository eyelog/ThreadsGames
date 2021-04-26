package ru.eyelog.threadsgames.thirdfragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class ThirdViewModel: ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    private val data = mutableListOf<String>()
    var uv: Int = 0
    @Volatile var v: Int = 0

    fun startUnVolatile(){

        uv = 0
        for (i in 0..100) {
            Thread { uv = getData(uv) }.start()
        }

        data.add(uv.toString())
        _sampleLiveData.value = data
    }

    fun startVolatile(){

        v = 0
        for (i in 0..100) {
            Thread { v = getData(v) }.start()
        }

        data.add(v.toString())
        _sampleLiveData.value = data
    }

    private fun getData(i: Int): Int {
        Thread.sleep(5)
        return i + 1
    }

    fun cleanList() {
        data.clear()
        _sampleLiveData.value = data
    }
}
