package com.example.movieapps.network

import android.os.Build
import android.util.Config.DEBUG
import android.util.Log.DEBUG
import com.example.movieapps.BuildConfig
import com.example.movieapps.BuildConfig.DEBUG
import com.example.movieapps.model.DetailMovieModel
import com.example.movieapps.model.ListModel
import com.example.movieapps.model.MovieModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiProvider {
    companion object{
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        private val  okHttpClient = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectionPool(ConnectionPool(3,40, TimeUnit.SECONDS))
                .addInterceptor(HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE})
                .build()

        var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @GET("genre/movie/list")
    fun getList(@Query("api_key") apikey: String): Single<ListModel>

    @GET("discover/movie")
    fun getMovie(@Query("page")page: String, @Query("api_key") apikey: String, @Query("with_genres") genres_id: String): Single<MovieModel>

    @GET("movie/")
    fun getDetailMovie(@Path("movie_id")id_movie: String, @Query("api_key") apikey: String): Single<DetailMovieModel>
}