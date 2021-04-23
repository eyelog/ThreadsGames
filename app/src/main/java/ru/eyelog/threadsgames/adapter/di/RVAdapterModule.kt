package ru.eyelog.threadsgames.adapter.di

import dagger.Module
import dagger.Provides
import ru.eyelog.threadsgames.adapter.RVAdapter

@Module
class RVAdapterModule {

    @Provides
    fun provideRVAdapter() = RVAdapter()
}
