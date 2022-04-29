package ikhwan.binar.chapterenam.designpattern.mvpsederhana.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpattern.mvpsederhana.model.HasilImt
import ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter.ImtPresenter
import ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter.ImtView
import kotlinx.android.synthetic.main.activity_main_imt.*

class MainImtActivity : AppCompatActivity(), ImtView {

    private lateinit var imtPresenter: ImtPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_imt)

        imtPresenter = ImtPresenter(this)

        btn_hitung.setOnClickListener {
            val bb = et_berat.text.toString().toDouble()
            val tb = et_tinggi.text.toString().toDouble()/100

            imtPresenter.hitungImt(tb, bb)
        }

    }

    override fun hasilImt(hasilImt: HasilImt) {
        tv_hasil.text = hasilImt.imt.toString()
    }
}