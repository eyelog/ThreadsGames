package ru.eyelog.threadsgames.secondfragment

import android.os.Bundle
import android.util.Log
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
import ru.eyelog.threadsgames.secondfragment.di.DaggerSecondComponent
import javax.inject.Inject

class SecondFragment: Fragment() {

    @Inject
    lateinit var viewModel: SecondViewModel

    @Inject
    lateinit var adapter: RVAdapter

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

        rvMainList.apply {
            adapter = this@SecondFragment.adapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = null
        }

        viewModel.sampleLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        })

        btFirst.text = resources.getString(R.string.async_work)
        btFirst.setOnClickListener {
            viewModel.cleanList()
            viewModel.startAsync()
        }

        btSecond.text = resources.getString(R.string.sync_work)
        btSecond.setOnClickListener {
            viewModel.cleanList()
            viewModel.startSync()
        }

        btThird.isVisible = false
        btFourth.isVisible = false
    }
}
