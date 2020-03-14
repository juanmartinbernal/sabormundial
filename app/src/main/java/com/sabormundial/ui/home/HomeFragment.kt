package com.sabormundial.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sabormundial.R
import com.sabormundial.ui.home.adapter.ListHamburguesasAdapter
import com.sabormundial.ui.home.entities.Hamburguesa

class HomeFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    // putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
    private lateinit var homeViewModel: HomeViewModel

    var mListRecyclerView: RecyclerView? = null
    lateinit var mAdapter: ListHamburguesasAdapter
    var layoutManager : LinearLayoutManager ? = null
    private val cargarHamburguesas = listOf(
        Hamburguesa(1,"La Colombiana", R.drawable.lacolombiana),
        Hamburguesa(2,"La Mexicana", R.drawable.lamexicana),
        Hamburguesa(3,"La Argentina", R.drawable.laargentina),
        Hamburguesa(4,"La Americana", R.drawable.laamericana),
        Hamburguesa(5,"La Sencilla", R.drawable.lasencilla)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        mListRecyclerView = root.findViewById(R.id.list_recycler_view)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = ListHamburguesasAdapter()
        mAdapter?.replaceItems(cargarHamburguesas)
        mListRecyclerView?.adapter =  mAdapter
    }
}
