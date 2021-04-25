package ru.eyelog.threadsgames.firstfragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    val data = mutableListOf<String>()

    // Блокировка потока
    fun startBlockingThread() {

        for (i in 0..3) {
            Thread.sleep(1000)
            data.add(i.toString())
            _sampleLiveData.value = data
        }
    }

    fun startBackgroundThread() {

        val runnable = Runnable {
            for (i in 0..3) {
                Thread.sleep(1000)
                data.add(i.toString())
                Log.i("Logcat", "data: $data")
                // Следующая строчка крашнед приложение
                // _sampleLiveData.value = data
            }
        }
        val thread = Thread(runnable)
        thread.start()
    }

    fun startBackgroundThreadWithHandler() {

        val handler: Handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                data.add(msg.data.getString("Key").toString())
                _sampleLiveData.value = data
            }
        }

        val runnable = Runnable {
            for (i in 0..4) {
                Thread.sleep(1000)
                val msg = handler.obtainMessage()
                val bundle = Bundle()
                bundle.putString("Key", i.toString())
                msg.data = bundle
                handler.sendMessage(msg)
            }
        }
        val thread = Thread(runnable)
        thread.start()
    }

    fun cleanList() {
        data.clear()
        _sampleLiveData.value = data
    }

//    fun setData(){
//        val data = listOf("One", "Two", "Three")
//
//        Handler(Looper.getMainLooper())
//                .postDelayed({
//                    _sampleLiveData.value = data
//                }, 3000)
//
//    }
}