package ikhwan.binar.chapterenam.designpattern.mvp.presenter

import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem

interface DetailNewsView {
    fun onSuccess(message : String, detailNews : GetNewsResponseItem)
    fun onError(message: String)
}