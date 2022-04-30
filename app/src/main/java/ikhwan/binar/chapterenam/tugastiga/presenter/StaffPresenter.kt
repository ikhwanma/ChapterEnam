package ikhwan.binar.chapterenam.tugastiga.presenter

import ikhwan.binar.chapterenam.tugastiga.model.GetStaffResponseItem
import ikhwan.binar.chapterenam.tugastiga.network.StaffApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StaffPresenter(var staffView: StaffView) {
    fun getStaff(){
        StaffApiClient.instance.getStaff()
            .enqueue(object : Callback<List<GetStaffResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetStaffResponseItem>>,
                    response: Response<List<GetStaffResponseItem>>
                ) {
                    if (response.isSuccessful){
                        staffView.onSuccess(response.message(), response.body()!!)
                    }else{
                        staffView.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetStaffResponseItem>>, t: Throwable) {
                    staffView.onError(t.message.toString())
                }
            })
    }
}