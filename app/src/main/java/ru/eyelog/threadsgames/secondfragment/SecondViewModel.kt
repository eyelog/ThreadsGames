package ru.eyelog.threadsgames.secondfragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class SecondViewModel: ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    private val data = mutableListOf<String>()

    private val handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            data.add(msg.data.getString("Key").toString())
            _sampleLiveData.value = data
        }
    }

    fun startAsync() {

        Thread{
            val threads = mutableListOf<Thread>()

            for (i in 0..4) {
                val thread = Thread {
                    val msg = handler.obtainMessage()
                    val bundle = Bundle()
                    bundle.putString("Key", asyncEmitter(i))
                    msg.data = bundle
                    handler.sendMessage(msg)
                }
                thread.name = "$i"
                threads.add(thread)
            }

            for (i in 0..4) {
                Thread.sleep(200)
                threads[i].start()
            }
        }.start()
    }

    private fun asyncEmitter(i: Int): String {
        Thread.sleep(Random.nextLong(1000))
        return i.toString()
    }

    fun startSync(){

        Thread{
            val threads = mutableListOf<Thread>()

            for (i in 0..4) {
                val thread = Thread {
                    val msg = handler.obtainMessage()
                    val bundle = Bundle()
                    bundle.putString("Key", synchronizedEmitter(i))
                    msg.data = bundle
                    handler.sendMessage(msg)
                }
                thread.name = "$i"
                threads.add(thread)
            }

            for (i in 0..4) {
                Thread.sleep(200)
                threads[i].start()
            }
        }.start()
    }

    @Synchronized fun synchronizedEmitter(i: Int): String {
        Thread.sleep(Random.nextLong(1000))
        return i.toString()
    }

    fun cleanList() {
        data.clear()
        _sampleLiveData.value = data
    }
}
