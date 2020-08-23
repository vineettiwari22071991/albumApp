package com.example.albumapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albumapp.R
import com.example.albumapp.adapter.AlbumlistAdapter
import com.example.albumapp.viewmodel.FragmentListViewmodel
import kotlinx.android.synthetic.main.fragment_album_list.*
import java.io.ByteArrayOutputStream
import java.io.InputStream
import com.example.albumapp.model.Result

class AlbumListFragment : Fragment(), AlbumlistAdapter.IAlbumList {


    lateinit var viewModel: FragmentListViewmodel

    private val listadapter = AlbumlistAdapter(arrayListOf(), this)
    private lateinit var inputStream: InputStream
    private val byteArrayOutputStream: ByteArrayOutputStream = ByteArrayOutputStream()
    private var mParentActivity = MainActivity()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        viewModel = ViewModelProviders.of(this).get(FragmentListViewmodel::class.java)

        val spinneradapter =
            context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_item,
                    listOf(
                        "FilterBy",
                        "Collection Name",
                        "Track Name",
                        "Artist Name",
                        "Collection Price"
                    )
                )
            }
        spinneradapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinneradapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {

                val item = spinneradapter?.getItem(position)

                if (position != 0) {
                    if (item != null) {
                        viewModel.filterListbySelectoption(item)
                    }

                }
            }
        }



        viewModel.getRawdata(readrawData())
        viewModel.selectedArray.clear()


        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listadapter
        }




        viewModel.sortResult.observe(this, Observer {

            listadapter.updateList(it)

        })


        select_screen.setOnClickListener {

            if (viewModel.selectedArray.size > 0) {
                val bundle = bundleOf("args" to viewModel.selectedArray)
                findNavController().navigate(R.id.action_album_to_selected, bundle)
            } else {
                Toast.makeText(activity, "No item Selected", Toast.LENGTH_SHORT).show()
            }


        }


    }


    fun readrawData(): String {
        inputStream = resources.openRawResource(R.raw.album)
        var ctr = inputStream.read()
        while (ctr != -1) {
            byteArrayOutputStream.write(ctr)
            ctr = inputStream.read()
        }
        inputStream.close()

        return byteArrayOutputStream.toString()
    }


    override fun onCheckitem(itemResult: Result) {
        viewModel.addandremoveData(true, itemResult)
    }

    override fun onUnCheckitem(itemResult: Result) {
        viewModel.addandremoveData(false, itemResult)
    }

}
