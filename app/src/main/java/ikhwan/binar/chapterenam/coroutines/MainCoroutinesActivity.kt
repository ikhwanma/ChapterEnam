package ikhwan.binar.chapterenam.coroutines

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_main_async_task.*
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.android.synthetic.main.activity_main_coroutines.btn_hitung
import kotlinx.android.synthetic.main.activity_main_coroutines.et_berat
import kotlinx.android.synthetic.main.activity_main_coroutines.et_tinggi
import kotlinx.android.synthetic.main.activity_main_coroutines.tv_hasil
import kotlinx.coroutines.*

class MainCoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)

        btn_hitung.setOnClickListener {
            GlobalScope.launch {
                delay(2000)
                CoroutineScope(Dispatchers.Main).launch {
                    val bb = et_berat.text.toString().toDouble()
                    val tb = et_tinggi.text.toString().toDouble() / 100
                    val bmi = bb/Math.pow(tb, 2.0)

                    val ket = if (bmi < 18.4){
                        "Berat badang kurang"
                    }else if (bmi in 18.5 .. 24.9){
                        "Berat badan ideal"
                    }else if (bmi in 25.0 .. 29.9){
                        "Berat badan lebih"
                    }else if (bmi in 30.0 .. 39.9){
                        "Gemuk"
                    }else{
                        "Sangat gemuk"
                    }

                    tv_hasil.text = "Hasil : "
                    tv_hasil.append(ket)
                }
                CoroutineScope(Dispatchers.IO).launch {
                    Log.d("Dispatchers.IO", "Halo IO")
                }
                CoroutineScope(Dispatchers.Default).launch {
                    Log.d("Dispatchers.Default", "Halo Default")
                }
            }
        }


    }

    /*private fun contoh() {
        GlobalScope.launch {
            delay(2000)

            *//*val a = async { "Hello World" }
            val hasil = a.await()
            Log.d("globalScope", hasil)*//*
            runOnUiThread {
                tv_nama.text = "tes"
            }

//            hasil()
        }
    }

    suspend fun getString(s: String): String {
        delay(2000)
        return s
    }

    suspend fun hasil() : String {
        delay(2000)
        val a = tv_nama.setText("Hello World")
        return a.toString()
    }*/
}