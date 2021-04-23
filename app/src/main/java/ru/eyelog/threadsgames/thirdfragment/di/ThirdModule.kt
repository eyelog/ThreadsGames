package ru.eyelog.threadsgames.thirdfragment.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.threadsgames.thirdfragment.ThirdViewModel

@Module
class ThirdModule {

    @Provides
    fun provideThirdViewModel(
            fragment: Fragment,
            factory: ThirdViewModelFactory
    ): ThirdViewModel = ViewModelProvider(fragment, factory).get(ThirdViewModel::class.java)
}
