package ru.eyelog.threadsgames.secondfragment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.threadsgames.secondfragment.SecondViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class SecondViewModelFactory @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(SecondViewModel::class.java)) {
            return SecondViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
