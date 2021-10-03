package com.example.movieapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapps.R
import com.example.movieapps.model.ListModel
import com.example.movieapps.page.MainActivity
import kotlinx.android.synthetic.main.card_list_movie.*
import kotlinx.android.synthetic.main.card_list_movie.view.*

class ListAdapter(var context: Context, var  list: ArrayList<ListModel.Genres>, val listener: (ListModel.Genres) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.card_list_movie,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name


        holder.card.setOnClickListener {
           listener(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.name_list
        val card = view.card_list
    }
}