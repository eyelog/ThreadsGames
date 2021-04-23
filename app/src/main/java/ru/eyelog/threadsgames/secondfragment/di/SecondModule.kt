package ru.eyelog.threadsgames.secondfragment.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.threadsgames.firstfragment.di.FirstViewModelFactory
import ru.eyelog.threadsgames.secondfragment.SecondViewModel

@Module
class SecondModule {

    @Provides
    fun provideSecondViewModel(
            fragment: Fragment,
            factory: SecondViewModelFactory
    ): SecondViewModel = ViewModelProvider(fragment, factory).get(SecondViewModel::class.java)
}
