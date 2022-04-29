package ikhwan.binar.chapterenam.designpattern.mvp.network

import ikhwan.binar.chapterlima.networking.network.ApiClient
import ikhwan.binar.chapterlima.networking.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetApiClient {

    val BASE_URL = "https://6254434289f28cf72b5aed04.mockapi.io/"

    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val client = OkHttpClient.Builder().addInterceptor(logging).build()

    val instance: NetApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        retrofit.create(NetApiService::class.java)
    }
}