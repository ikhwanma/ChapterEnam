package ikhwan.binar.chapterenam.designpattern.mvp.presenter

import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem
import ikhwan.binar.chapterenam.designpattern.mvp.network.NetApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailNewsPresenter(var detailNewsView: DetailNewsView) {
    fun getDetailNews(id : String){
        NetApiClient.instance.getDetailNews(id)
            .enqueue(object : Callback<GetNewsResponseItem>{
                override fun onResponse(
                    call: Call<GetNewsResponseItem>,
                    response: Response<GetNewsResponseItem>
                ) {
                    if (response.isSuccessful){
                        detailNewsView.onSuccess(response.message(), response.body()!!)
                    }else{
                        detailNewsView.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<GetNewsResponseItem>, t: Throwable) {
                    detailNewsView.onError(t.message.toString())
                }

            })
    }
}