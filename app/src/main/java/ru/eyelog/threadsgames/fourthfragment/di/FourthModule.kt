package ru.eyelog.threadsgames.fourthfragment.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.threadsgames.fourthfragment.FourthViewModel

@Module
class FourthModule {

    @Provides
    fun provideFirstViewModel(
            fragment: Fragment,
            factory: FourthViewModelFactory
    ): FourthViewModel = ViewModelProvider(fragment, factory).get(FourthViewModel::class.java)
}