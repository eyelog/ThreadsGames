package ru.eyelog.threadsgames.secondfragment.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.threadsgames.secondfragment.SecondFragment

@Component(modules = [SecondModule::class])
interface SecondComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): SecondComponent
    }

    fun inject(fragment: SecondFragment)
}
