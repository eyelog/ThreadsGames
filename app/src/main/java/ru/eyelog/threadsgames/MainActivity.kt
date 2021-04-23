package ru.eyelog.threadsgames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.eyelog.threadsgames.firstfragment.FirstFragment
import ru.eyelog.threadsgames.secondfragment.SecondFragment
import ru.eyelog.threadsgames.thirdfragment.ThirdFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_first -> {
                    routeController(0)
                    true
                }
                R.id.item_second -> {
                    routeController(1)
                    true
                }
                R.id.item_third -> {
                    routeController(2)
                    true
                }
                else -> false
            }
        }

        routeController(0)
    }

    private fun routeController(position: Int) {
        val fragments = listOf(
                FirstFragment(),
                SecondFragment(),
                ThirdFragment()
        )

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainFragmentSpace, fragments[position])
                .commit()
    }
}
