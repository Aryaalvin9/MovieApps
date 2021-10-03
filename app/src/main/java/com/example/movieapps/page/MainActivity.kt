package com.example.movieapps.page

import android.content.Intent
import android.media.tv.TvContract
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapps.R
import com.example.movieapps.adapter.AdapterMovie
import com.example.movieapps.adapter.ListAdapter
import com.example.movieapps.model.DetailMovieModel
import com.example.movieapps.model.ListModel
import com.example.movieapps.model.MovieModel
import com.example.movieapps.network.ApiProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var provider : ApiProvider?= null
    val API_KEY = "ddc4c7134971251166e2d09c401e75b8"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        provider = ApiProvider.retrofit.create(ApiProvider::class.java)
        getList()
        getmovie("")
        btn_all.setOnClickListener {
            getmovie("")
        }
    }
    private fun getList(){
        provider?.getList("ddc4c7134971251166e2d09c401e75b8")
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : SingleObserver<ListModel>{
                override fun onSuccess(t: ListModel) {
                        val adapter =  ListAdapter(this@MainActivity, t.genres!!){ readerdata ->
                            Log.i("getdata", "${readerdata.id} clicked")
                            getmovie(readerdata.id.toString())
                        }
                        val manager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

                        rvList.adapter = adapter
                        rvList.layoutManager = manager


                }
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    Toast.makeText(this@MainActivity, "some Error", Toast.LENGTH_LONG).show()
                }
            })
    }
   public fun getmovie(genre: String){
        provider?.getMovie("1","ddc4c7134971251166e2d09c401e75b8",genre)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : SingleObserver<MovieModel>{

                override fun onSuccess(t: MovieModel) {
                    val adapter_m = AdapterMovie(this@MainActivity, t.result!!){ readerdata ->
                        Log.i("get data", "${readerdata.id_movie} cliked")
                        val intent = Intent(this@MainActivity, DetailMovie::class.java).apply {
                            putExtra("id_Movie", readerdata.id_movie)
                        }

                        startActivity(intent)
                    }
                    val manager_m = GridLayoutManager(this@MainActivity, 2)

                    rvMovie.adapter = adapter_m
                    rvMovie.layoutManager = manager_m
                }
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    Toast.makeText(this@MainActivity, "some Error", Toast.LENGTH_LONG).show()
                }

            })
    }
}