package ru.eyelog.threadsgames.thirdfragment.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.threadsgames.adapter.di.RVAdapterModule
import ru.eyelog.threadsgames.thirdfragment.ThirdFragment

@Component(
    modules = [
        ThirdModule::class,
        RVAdapterModule::class
    ]
)
interface ThirdComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): ThirdComponent
    }

    fun inject(fragment: ThirdFragment)
}
