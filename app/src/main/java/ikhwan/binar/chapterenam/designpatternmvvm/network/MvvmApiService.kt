package ikhwan.binar.chapterenam.designpatternmvvm.network

import ikhwan.binar.chapterenam.designpatternmvvm.model.GetMvvmNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface MvvmApiService {
    @GET("/news")
    fun getNews(): Call<List<GetMvvmNewsResponseItem>>
}