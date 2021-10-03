package com.example.movieapps.page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.movieapps.R
import com.example.movieapps.model.DetailMovieModel
import com.example.movieapps.network.ApiProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovie : AppCompatActivity() {

    var providerD : ApiProvider?= null
    val API_KEY = "ddc4c7134971251166e2d09c401e75b8"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        providerD = ApiProvider.retrofit.create(ApiProvider::class.java)
        val intentValue = intent.getStringExtra("id_Movie")
        getDetail(intentValue.toString())
    }

    private fun getDetail(movie_id:String){
        providerD?.getDetailMovie(movie_id,"ddc4c7134971251166e2d09c401e75b8")
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : SingleObserver<DetailMovieModel>{
                    override fun onSuccess(t: DetailMovieModel) {
                        Log.i("getdata", "${t.id}")
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                        e.printStackTrace()
                        Toast.makeText(this@DetailMovie, "some Error", Toast.LENGTH_LONG).show()
                    }

                })
    }
}