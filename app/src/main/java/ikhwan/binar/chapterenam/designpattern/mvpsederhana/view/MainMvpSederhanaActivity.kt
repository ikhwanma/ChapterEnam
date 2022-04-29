package ikhwan.binar.chapterenam.designpattern.mvpsederhana.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpattern.mvpsederhana.model.Hasil
import ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter.PersegiPanjangPresenter
import ikhwan.binar.chapterenam.designpattern.mvpsederhana.presenter.PersegiPanjangView
import kotlinx.android.synthetic.main.activity_main_mvp_sederhana.*

class MainMvpSederhanaActivity : AppCompatActivity() , PersegiPanjangView{

    private var persegiPanjangPresenter : PersegiPanjangPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvp_sederhana)

        persegiPanjangPresenter = PersegiPanjangPresenter(this)

        btn_hitung.setOnClickListener {
            val panjang = et_panjang.text.toString().toInt()
            val lebar = et_lebar.text.toString().toInt()

            persegiPanjangPresenter?.hitungLuas(panjang, lebar)
        }
    }

    override fun luasPersegiPanjang(hasil: Hasil) {
        tv_hasil.text = "Luas Persegi Panjang : "
        tv_hasil.append(hasil.luas.toString())
    }
}