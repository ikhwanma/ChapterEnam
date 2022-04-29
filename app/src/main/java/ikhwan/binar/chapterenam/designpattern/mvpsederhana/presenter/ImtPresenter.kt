package ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter

import ikhwan.binar.chapterenam.designpattern.mvpsederhana.model.HasilImt

class ImtPresenter(var imtView: ImtView) {

    fun hitungImt(tb:Double, bb: Double){
        val imt = bb/(tb*tb)

        val hasil = HasilImt()
        hasil.imt = imt

        imtView.hasilImt(hasil)
    }
}