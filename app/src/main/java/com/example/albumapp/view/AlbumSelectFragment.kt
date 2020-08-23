package com.example.albumapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albumapp.R
import com.example.albumapp.adapter.SelectedAdapter
import com.example.albumapp.model.Result
import kotlinx.android.synthetic.main.fragment_album_list.*
import kotlinx.android.synthetic.main.fragment_selectalbum.*

class AlbumSelectFragment : Fragment() {


    private var mParentActivity = MainActivity()
    private val listadapter = SelectedAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selectalbum, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_list_select.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listadapter
        }

        val items=arguments?.get("args")

        listadapter.updateList(items as ArrayList<Result>)


    }
}