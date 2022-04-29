package ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter

import ikhwan.binar.chapterenam.designpattern.mvpsederhana.model.HasilImt

interface ImtView {
    fun hasilImt(hasilImt: HasilImt)
}