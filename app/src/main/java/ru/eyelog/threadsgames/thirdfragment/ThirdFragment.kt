package ru.eyelog.threadsgames.thirdfragment

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
import ru.eyelog.threadsgames.thirdfragment.di.DaggerThirdComponent
import javax.inject.Inject

class ThirdFragment: Fragment() {

    @Inject
    lateinit var viewModel: ThirdViewModel

    @Inject
    lateinit var adapter: RVAdapter

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

        rvMainList.apply {
            adapter = this@ThirdFragment.adapter
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
            viewModel.startUnVolatile()
        }

        btSecond.text = resources.getString(R.string.sync_work)
        btSecond.setOnClickListener {
            viewModel.cleanList()
            viewModel.startVolatile()
        }

        btThird.isVisible = false
        btFourth.isVisible = false
    }
}
