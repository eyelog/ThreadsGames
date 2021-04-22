package ru.eyelog.threadsgames.firstfragment.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.threadsgames.firstfragment.FirstFragment

@Component(modules = [FirstModule::class])
interface FirstComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): FirstComponent
    }

    fun inject(fragment: FirstFragment)
}
