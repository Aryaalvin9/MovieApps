package com.example.movieapps.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListModel {

    @SerializedName("genres")
    @Expose
    var genres: ArrayList<Genres>? = null



    inner class Genres{
        @SerializedName("id")
        @Expose
        var id: String? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
    }
}