package ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter

import ikhwan.binar.chapterenam.designpattern.mvpsederhana.model.Hasil

interface PersegiPanjangView {
    fun luasPersegiPanjang(hasil : Hasil)
}