package ru.eyelog.threadsgames.fourthfragment

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

class FourthViewModel : ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    private val data = mutableListOf<String>()


    fun startBackgroundThreadWithCallable(){
        val callable = Callable {
            return@Callable "tap"
        }

        val future = FutureTask(callable)

        val thread = Thread(future)
        Log.i("Logcat ", "Thread name ${thread.name}")
        thread.start()
        data.add(future.get())

        _sampleLiveData.value = data
    }

    fun cleanList() {
        data.clear()
        _sampleLiveData.value = data
    }

}
