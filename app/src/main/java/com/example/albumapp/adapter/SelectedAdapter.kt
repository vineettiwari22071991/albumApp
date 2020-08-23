package com.example.albumapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albumapp.R
import com.example.albumapp.model.Result
import com.example.albumapp.util.convertLocalTime
import com.example.albumapp.util.getProgressDrawable
import com.example.albumapp.util.loadimage
import kotlinx.android.synthetic.main.item_list.view.*


class SelectedAdapter(var resultlist: ArrayList<Result>) :
    RecyclerView.Adapter<SelectedAdapter.MyViewHolder>() {


    //Get a list data an refresh the recyclerView
    fun updateList(newdatalist: ArrayList<Result>) {
        resultlist.clear()
        resultlist.addAll(newdatalist)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )


    override fun getItemCount() = resultlist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.loadView(resultlist[position])
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val list_parent = view.list_parent
        private val image = view.image
        private val name = view.tv_name
        private val tv_track = view.tv_track
        private val tv_collectionname = view.tv_collectionname
        private val tv_collectionprice = view.tv_collectionprice
        private val progressDrawable = getProgressDrawable(view.context)
        private val day = view.day
        private val select = view.select


        fun loadView(item: Result) {

            name.text = item.artistName
            image.loadimage(item.artworkUrl100, progressDrawable)
            tv_track.text = item.trackName
            tv_collectionname.text = item.collectionName
            tv_collectionprice.text = "" + item.collectionPrice
            select.visibility = GONE

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                day.text = convertLocalTime(item.releaseDate)
            } else {
                day.text = ""
            }


        }

    }

}