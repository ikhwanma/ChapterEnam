package ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter

import ikhwan.binar.chapterenam.designpattern.mvpsederhana.model.Hasil

class PersegiPanjangPresenter(var persegiPanjangView: PersegiPanjangView) {

    fun hitungLuas(panjang : Int, lebar : Int){
        val luas = panjang * lebar

        val hasil = Hasil()
        hasil.luas = luas

        persegiPanjangView.luasPersegiPanjang(hasil)
    }

}