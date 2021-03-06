package ikhwan.binar.chapterenam.latihanmvvm.network

import ikhwan.binar.latihanlistcountryretrofit.model.GetCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface CountryApiService {
    @GET("all")
    fun getCountry(): Call<ArrayList<GetCountryResponseItem>>
}