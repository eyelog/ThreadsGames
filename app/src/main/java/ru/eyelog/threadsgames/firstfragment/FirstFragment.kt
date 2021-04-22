package ru.eyelog.threadsgames.firstfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ru.eyelog.threadsgames.R
import ru.eyelog.threadsgames.firstfragment.di.DaggerFirstComponent
import javax.inject.Inject

class FirstFragment: Fragment() {

    @Inject
    lateinit var viewModel: FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerFirstComponent
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