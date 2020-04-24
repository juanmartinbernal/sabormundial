package com.sabormundial.ui.burguers.view.impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sabormundial.R
import com.sabormundial.ui.burguers.model.HomeViewModel
import com.sabormundial.ui.burguers.adapter.ListBurguersAdapter
import com.sabormundial.ui.burguers.adapter.RecyclerItemClickListener
import com.sabormundial.ui.burguers.entities.Hamburguesa
import com.sabormundial.ui.utils.Constants

class BurguersListFragmentImpl : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() =
            BurguersListFragmentImpl().apply {
                arguments = Bundle().apply {
                    // putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    private lateinit var homeViewModel: HomeViewModel

    var mListRecyclerView: RecyclerView? = null
    lateinit var mAdapter: ListBurguersAdapter
    var layoutManager: LinearLayoutManager? = null
    private val cargarHamburguesas = listOf(
        Hamburguesa(Constants.COLOMBIANA_ID, "La Colombiana", R.drawable.lacolombiana),
        Hamburguesa(Constants.MEXICANA_ID, "La Mexicana", R.drawable.lamexicana),
        Hamburguesa(Constants.ARGENTINA_ID, "La Argentina", R.drawable.laargentina),
        Hamburguesa(Constants.AMERICANA_ID, "La Americana", R.drawable.laamericana),
        Hamburguesa(Constants.SENCILLA_ID, "La Sencilla", R.drawable.lasencilla)

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
        mAdapter = ListBurguersAdapter()
        mAdapter?.replaceItems(cargarHamburguesas)
        mListRecyclerView?.adapter = mAdapter

        mListRecyclerView?.addOnItemTouchListener(
            RecyclerItemClickListener(context,
                mListRecyclerView!!, object : RecyclerItemClickListener.OnItemClickListener {

                    override fun onItemClick(view: View, position: Int) {
                        val hamburguesa : Hamburguesa
                        hamburguesa = cargarHamburguesas.get(position);
                        val burguerId = hamburguesa.id
                        val title = hamburguesa.title
                        val image = hamburguesa.image
                        //abrir fragment de detalle de la hamburguesa
                        openDialog(burguerId, title, image)
                    }

                    override fun onItemLongClick(view: View?, position: Int) {
                        TODO("do nothing")
                    }
                })
        );
    }

    fun openDialog(burguerId: Int, title: String,  imageId: Int){
        val dialogFragment = BurguersDetailFragmentImpl() //here MyDialog is my custom dialog
        val bundle = Bundle()
        bundle.putInt("burguerId", burguerId)
        bundle.putString("title", title)
        bundle.putInt("image", imageId)
        dialogFragment.arguments = bundle

        val fragmentTransaction = childFragmentManager.beginTransaction()
        val prev = childFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            fragmentTransaction.remove(prev)
        }
        fragmentTransaction.addToBackStack(null)

        dialogFragment.show(fragmentTransaction, "dialog")
    }
}
