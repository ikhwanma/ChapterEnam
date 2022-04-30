package ikhwan.binar.chapterenam.designpattern.mvp.presenter

import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponse
import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem
import ikhwan.binar.chapterenam.designpattern.mvp.network.NetApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter(var newsView: NewsView) {

    fun getNews() {
        NetApiClient.instance.getNews()
            .enqueue(object : Callback<List<GetNewsResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetNewsResponseItem>>,
                    response: Response<List<GetNewsResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        newsView.onSuccess(response.message(), response.body()!!)
                    } else {
                        newsView.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetNewsResponseItem>>, t: Throwable) {
                    newsView.onError(t.message.toString())
                }

            })
    }


}