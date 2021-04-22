package ru.eyelog.threadsgames.firstfragment.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.threadsgames.firstfragment.FirstViewModel

@Module
class FirstModule {

    @Provides
    fun provideFirstViewModel(
        fragment: Fragment,
        factory: FirstViewModelFactory
    ): FirstViewModel = ViewModelProvider(fragment, factory).get(FirstViewModel::class.java)
}
