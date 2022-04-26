package ikhwan.binar.chapterenam.thread.hitungumur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_main_hitung.*

class MainHitungActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hitung)


        Thread(Runnable {
            btn_hitung.setOnClickListener {
                val nama = input_nama.text.toString()
                val tahun = input_tahun.text.toString().toInt()
                val umur = 2022 - tahun

                tv_nama.post(Runnable {
                    tv_nama.text = nama
                })
                tv_umur.postDelayed(Runnable {
                    tv_umur.text = umur.toString()
                }, 2000)
            }
        }).start()

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_hitung -> {

            }
        }
    }
}