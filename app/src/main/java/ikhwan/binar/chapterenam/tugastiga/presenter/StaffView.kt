package ikhwan.binar.chapterenam.tugastiga.presenter

import ikhwan.binar.chapterenam.tugastiga.model.GetStaffResponseItem

interface StaffView {
    fun onSuccess(message : String, listNews : List<GetStaffResponseItem>)
    fun onError(message: String)
}