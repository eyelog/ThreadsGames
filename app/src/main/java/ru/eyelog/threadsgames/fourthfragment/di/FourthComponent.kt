package ru.eyelog.threadsgames.fourthfragment.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.threadsgames.adapter.di.RVAdapterModule
import ru.eyelog.threadsgames.fourthfragment.FourthFragment

@Component(modules = [
    FourthModule::class,
    RVAdapterModule::class
])
interface FourthComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): FourthComponent
    }

    fun inject(fragment: FourthFragment)
}
