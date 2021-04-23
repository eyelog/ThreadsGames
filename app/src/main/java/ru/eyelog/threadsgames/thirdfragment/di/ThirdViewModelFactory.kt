package ru.eyelog.threadsgames.thirdfragment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.threadsgames.firstfragment.FirstViewModel
import ru.eyelog.threadsgames.thirdfragment.ThirdViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ThirdViewModelFactory @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(ThirdViewModel::class.java)) {
            return ThirdViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
