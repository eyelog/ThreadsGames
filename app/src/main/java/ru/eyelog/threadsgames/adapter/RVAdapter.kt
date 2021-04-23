package ru.eyelog.threadsgames.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.eyelog.threadsgames.R

class RVAdapter : RecyclerView.Adapter<RVAdapter.RVHolder>() {

    private var data: List<String> = emptyList()

    fun setData(data: List<String>){
        this.data = data
    }

    inner class RVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTextTitle: TextView? = null

        init {
            tvTextTitle = itemView.findViewById(R.id.tvText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)
        return RVHolder(itemView)
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
        holder.tvTextTitle?.text = data[position]
    }

    override fun getItemCount() = data.size
}
