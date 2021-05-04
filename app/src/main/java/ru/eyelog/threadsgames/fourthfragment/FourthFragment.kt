package ru.eyelog.threadsgames.fourthfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_layout.*
import ru.eyelog.threadsgames.R
import ru.eyelog.threadsgames.adapter.RVAdapter
import ru.eyelog.threadsgames.fourthfragment.di.DaggerFourthComponent
import javax.inject.Inject

class FourthFragment : Fragment() {

    @Inject
    lateinit var viewModel: FourthViewModel

    @Inject
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerFourthComponent
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

        rvMainList.apply {
            adapter = this@FourthFragment.adapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        })

        btFirst.text = resources.getString(R.string.simple_callable)
        btFirst.setOnClickListener {
            viewModel.cleanList()
            viewModel.startBackgroundThreadWithCallable()
        }

        btSecond.isVisible = false
        btSecond.text = resources.getString(R.string.work_in_background)
        btSecond.setOnClickListener {

        }

        btThird.isVisible = false
        btThird.text = resources.getString(R.string.simple_work_with_ui)
        btThird.setOnClickListener {

        }

        btFourth.isVisible = false
    }
}