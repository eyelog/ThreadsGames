package ru.eyelog.threadsgames.firstfragment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.threadsgames.firstfragment.FirstViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class FirstViewModelFactory @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(FirstViewModel::class.java)) {
            return FirstViewModelFactory() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
