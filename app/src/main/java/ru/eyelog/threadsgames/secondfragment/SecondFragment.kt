package ru.eyelog.threadsgames.secondfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.eyelog.threadsgames.R
import ru.eyelog.threadsgames.secondfragment.di.DaggerSecondComponent
import javax.inject.Inject

class SecondFragment: Fragment() {

    @Inject
    lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSecondComponent
                .builder()
                .withFragment(this)
                .build()
                .inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            Log.i("Logcat", "Element $it")
        })
    }
}
