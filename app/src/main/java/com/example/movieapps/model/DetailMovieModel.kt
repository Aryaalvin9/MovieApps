package com.example.movieapps.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DetailMovieModel {

    @SerializedName("adult")
    @Expose
    var aldut: Boolean? = null
    @SerializedName("genres")
    @Expose
    var genres: ArrayList<DetailMovieModel.GenresD>? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
//    @SerializedName("original_title")
//    @Expose
//    var title_d: String? = null
//    @SerializedName("overview")
//    @Expose
//    var desc: String? = null
//    @SerializedName("poster_path")
//    @Expose
//    var image: String? = null
//    @SerializedName("genres")
//    @Expose
//    var company: ArrayList<DetailMovieModel.ProductionCompanies>? = null
//    @SerializedName("release_date")
//    @Expose
//    var realease: String? = null
//    @SerializedName("revenue")
//    @Expose
//    var revenue: String? = null
//    @SerializedName("runtime")
//    @Expose
//    var runtime: String? = null
//    @SerializedName("status")
//    @Expose
//    var status: String? = null
//    @SerializedName("vote_average")
//    @Expose
//    var vote: String? = null

        inner class GenresD{
            @SerializedName("id")
            @Expose
            var id: String? = null
            @SerializedName("name")
            @Expose
            var name: String? = null
        }
        inner class ProductionCompanies{
            @SerializedName("id")
            @Expose
            var id: String? = null
            @SerializedName("name")
            @Expose
            var name: String? = null
        }
}