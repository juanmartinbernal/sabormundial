package com.sabormundial.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sabormundial.R
import com.sabormundial.ui.home.entities.Hamburguesa
import com.squareup.picasso.Picasso

class HamburguesaViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.viewholder_hhamburguesas, parent, false)) {
    private var mTitleView: TextView? = null
    private var mImage: ImageView? = null


    init {
        mTitleView = itemView.findViewById(R.id.titleHamburguesa)
        mImage = itemView.findViewById(R.id.imgHamburguesa)
    }

    fun bind(hamburguesa: Hamburguesa) {
        mTitleView?.text = hamburguesa.title
        Picasso.get().load(hamburguesa.image).into(mImage)
        //mImage?.setImageResource(hamburguesa.image)
    }

}