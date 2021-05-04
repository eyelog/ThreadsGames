package ru.eyelog.threadsgames.fourthfragment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.threadsgames.fourthfragment.FourthViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class FourthViewModelFactory  @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(FourthViewModel::class.java)) {
            return FourthViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
