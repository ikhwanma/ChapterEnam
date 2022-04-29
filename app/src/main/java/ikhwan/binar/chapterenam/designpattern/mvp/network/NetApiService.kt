package ikhwan.binar.chapterenam.designpattern.mvp.network

import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem
import ikhwan.binar.chapterlima.networking.model.GetFilmResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface NetApiService {
    @GET("/news")
    fun getNews(): Call<List<GetNewsResponseItem>>
}