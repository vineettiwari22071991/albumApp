package com.example.albumapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.albumapp.model.ModelAblum
import com.example.albumapp.model.Result
import com.google.gson.Gson
import java.nio.channels.Selector


class FragmentListViewmodel : ViewModel() {


    lateinit var albumData: ModelAblum

    val sortResult = MutableLiveData<ArrayList<Result>>()

    var sortArray = arrayListOf<Result>()


    var selectedArray = arrayListOf<Result>()


    fun getRawdata(albumdata: String) {
        try {
            albumData = Gson().fromJson(albumdata, ModelAblum::class.java)

            if (sortArray.size > 0) {
                sortArray.clear()
            }

            albumData.results.distinctBy { it.trackName }


            albumData.results.sortByDescending { it.releaseDate }
            albumData.results.forEach {

                sortArray.add(it)
            }

            sortResult.value = sortArray
        } catch (e: Exception) {
        }

    }


    fun filterListbySelectoption(filteroption: String) {

        if (sortArray.size > 0) {
            sortArray.clear()
        }
        when (filteroption) {
            "Collection Name" -> albumData.results.sortBy { it.collectionName }

            "Track Name" -> albumData.results.sortBy { it.trackName }

            "Artist Name" -> albumData.results.sortBy { it.artistName }

            "Collection Price" -> albumData.results.sortBy { it.collectionPrice }


        }


        albumData.results.forEach {

            sortArray.add(it)
        }

        sortResult.value = sortArray


    }


    fun addandremoveData(isSelected: Boolean, item: Result) {
        if (isSelected) {
            selectedArray.add(item)
        } else {
            selectedArray.remove(item)
        }

    }


}