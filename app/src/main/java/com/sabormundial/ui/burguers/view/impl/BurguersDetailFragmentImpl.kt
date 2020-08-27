package com.sabormundial.ui.burguers.view.impl

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.sabormundial.MainActivity
import com.sabormundial.R
import com.sabormundial.ui.burguers.view.BurguersDetailFragment
import com.sabormundial.ui.utils.Constants

class BurguersDetailFragmentImpl : DialogFragment(), BurguersDetailFragment {

    lateinit var image: ImageView
    lateinit var burguerText: TextView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        /**/
        val dialog = super.onCreateDialog(savedInstanceState)
        if (arguments != null) {
            val title = requireArguments().getString("title")
            dialog.setTitle(title)
        }
        return dialog

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, android.R.style.Theme_Material_Light_DarkActionBar)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_detail_burguers, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.imgBurguer)
        burguerText = view.findViewById(R.id.txtInfoBurguers)
        if (arguments != null) {
            val burguerId = requireArguments().getInt("burguerId")
            val imageId = requireArguments().getInt("image")
            image.setImageResource(imageId)
            setDataBurguer(burguerId);
        }
    }

    fun setDataBurguer(burguerId : Int){
        if (burguerId == Constants.COLOMBIANA_ID) {
            burguerText.text = getString(R.string.text_colombiana);
        }else if(burguerId == Constants.MEXICANA_ID){
            burguerText.text = getString(R.string.text_mexicana);
        }else if(burguerId == Constants.ARGENTINA_ID){
            burguerText.text = getString(R.string.text_argentina);
        }else if(burguerId == Constants.AMERICANA_ID){
            burguerText.text = getString(R.string.text_americana);
        }else{
            burguerText.text = getString(R.string.text_sencilla);
        }
    }
}