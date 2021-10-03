package com.example.movieapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapps.R
import com.example.movieapps.model.MovieModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_movie.view.*

class AdapterMovie(var context: Context, var list: ArrayList<MovieModel.Result>, val listener: (MovieModel.Result) -> Unit) : RecyclerView.Adapter<AdapterMovie.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.card_movie,parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500${list[position].poster}").into(holder.img)
        holder.title.text = list[position].title
        holder.desc.text = list[position].desc
        holder.see_M.text = list[position].view
        holder.jum_reting.text = list[position].vote
        var vote_r : String? = list[position].vote
        holder.retings.rating = vote_r.toString().toFloat()
        holder.movie_card.setOnClickListener {
            listener(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title = view.title_card
        val desc = view.desc_card
        val img = view.img_movie_card
        val see_M = view.view_card
        val retings = view.retings_card
        val jum_reting = view.vote_card
        val movie_card = view.card_view_movie
    }
}