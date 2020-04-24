package com.sabormundial.ui.burguers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sabormundial.ui.burguers.entities.Hamburguesa

class ListBurguersAdapter :
    RecyclerView.Adapter<BurguerViewHolder>() {

    private var items = listOf<Hamburguesa>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurguerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BurguerViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BurguerViewHolder, position: Int) {
        val hamburguesa: Hamburguesa = items[position]
        holder.bind(hamburguesa)
    }

    override fun getItemCount(): Int = items.size

    fun replaceItems(items: List<Hamburguesa>) {
        this.items = items
        notifyDataSetChanged()
    }
}