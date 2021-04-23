package ru.eyelog.threadsgames.firstfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        btFirst.setOnClickListener {
            viewModel.setData()
        }
    }
}
