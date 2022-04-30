package ikhwan.binar.chapterenam.designpatternmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ikhwan.binar.chapterenam.designpatternmvvm.model.GetMvvmNewsResponseItem
import ikhwan.binar.chapterenam.designpatternmvvm.network.MvvmApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMvvMViewModel : ViewModel(){

    val liveDataNews = MutableLiveData<List<GetMvvmNewsResponseItem>?>()

    fun getNews(){
        MvvmApiClient.instance.getNews()
            .enqueue(object : Callback<List<GetMvvmNewsResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetMvvmNewsResponseItem>>,
                    response: Response<List<GetMvvmNewsResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<GetMvvmNewsResponseItem>>, t: Throwable) {

                }

            })
    }
}