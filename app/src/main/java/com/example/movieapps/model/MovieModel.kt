package com.example.movieapps.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieModel {
    @SerializedName("page")
    @Expose
    var page: String? = null
    @SerializedName("results")
    @Expose
    var result: ArrayList<Result>? = null

    inner class Result {
        @SerializedName("adult")
        @Expose
        var aldut: String? = null

        @SerializedName("id")
        @Expose
        var id_movie: String? = null

        @SerializedName("original_language")
        @Expose
        var bahasa: String? = null

        @SerializedName("original_title")
        @Expose
        var title: String? = null

        @SerializedName("overview")
        @Expose
        var desc: String? = null

        @SerializedName("popularity")
        @Expose
        var view: String? = null

        @SerializedName("backdrop_path")
        @Expose
        var poster: String? = null

        @SerializedName("release_date")
        @Expose
        var release: String? = null

        @SerializedName("vote_average")
        @Expose
        var vote: String? = null
    }
}