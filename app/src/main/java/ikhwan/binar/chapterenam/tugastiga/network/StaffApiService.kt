package ikhwan.binar.chapterenam.tugastiga.network

import ikhwan.binar.chapterenam.tugastiga.model.GetStaffResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface StaffApiService {
    @GET("/staf")
    fun getStaff() : Call<List<GetStaffResponseItem>>
}