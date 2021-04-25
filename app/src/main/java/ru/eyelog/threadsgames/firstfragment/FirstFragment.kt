package ru.eyelog.threadsgames.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_layout.*
import ru.eyelog.threadsgames.R
import ru.eyelog.threadsgames.adapter.RVAdapter
import ru.eyelog.threadsgames.firstfragment.di.DaggerFirstComponent
import javax.inject.Inject

class FirstFragment: Fragment() {

    @Inject
    lateinit var viewModel: FirstViewModel

    @Inject
    lateinit var adapter: RVAdapter

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

        rvMainList.apply {
            adapter = this@FirstFragment.adapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        })

        btFirst.text = resources.getString(R.string.simple_list)
        btFirst.setOnClickListener {
            viewModel.cleanList()
            viewModel.startBlockingThread()
        }

        btSecond.text = resources.getString(R.string.work_in_background)
        btSecond.setOnClickListener {
            Toast.makeText(
                requireContext(),
                resources.getString(R.string.work_in_background_toast),
                Toast.LENGTH_SHORT
            ).show()
            viewModel.cleanList()
            viewModel.startBackgroundThread()
        }

        btThird.text = resources.getString(R.string.simple_work_with_ui)
        btThird.setOnClickListener {
            viewModel.cleanList()
            viewModel.startBackgroundThreadWithHandler()
        }

        btFourth.isVisible = false
    }
}
