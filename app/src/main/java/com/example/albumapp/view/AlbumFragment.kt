package com.example.albumapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.albumapp.R
import com.example.albumapp.util.hideKeyboard
import kotlinx.android.synthetic.main.fragment_album.*

class AlbumFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_submit.setOnClickListener {

            if(name.text.isEmpty()||trackname.text.isEmpty())
            {
                Toast.makeText(activity,"Please fill required data",Toast.LENGTH_LONG).show()
            }else
            {
                hideKeyboard(activity as MainActivity)
                findNavController().navigate(R.id.action_album_to_album_list)
            }
        }
    }
}