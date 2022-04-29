package ikhwan.binar.chapterenam.designpattern.mvp.presenter

import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponse
import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem

interface NewsView {
    fun onSuccess(message : String, listNews : List<GetNewsResponseItem>)
    fun onError(message: String)
}