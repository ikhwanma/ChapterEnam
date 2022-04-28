package ikhwan.binar.chapterlima.networking.network

import ikhwan.binar.chapterlima.networking.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("/film")
    fun getFilm(): Call<List<GetFilmResponseItem>>

}