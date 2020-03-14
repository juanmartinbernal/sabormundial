package com.sabormundial.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sabormundial.ui.home.entities.Hamburguesa

class ListHamburguesasAdapter :
    RecyclerView.Adapter<HamburguesaViewHolder>() {

    private var items = listOf<Hamburguesa>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HamburguesaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HamburguesaViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: HamburguesaViewHolder, position: Int) {
        val hamburguesa: Hamburguesa = items[position]
        holder.bind(hamburguesa)
    }

    override fun getItemCount(): Int = items.size

    fun replaceItems(items: List<Hamburguesa>) {
        this.items = items
        notifyDataSetChanged()
    }
}