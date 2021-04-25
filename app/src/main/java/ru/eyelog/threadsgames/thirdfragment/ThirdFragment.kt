package ru.eyelog.threadsgames.thirdfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_layout.*
import ru.eyelog.threadsgames.R
import ru.eyelog.threadsgames.thirdfragment.di.DaggerThirdComponent
import javax.inject.Inject

class ThirdFragment: Fragment() {

    @Inject
    lateinit var viewModel: ThirdViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerThirdComponent
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

        btFirst.text = resources.getString(R.string.third_item)
    }
}
