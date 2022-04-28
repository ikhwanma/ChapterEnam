package ikhwan.binar.chapterenam.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.coroutines.*

class MainCoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)

        contoh()

        /*CoroutineScope(Dispatchers.Main).launch {

        }*/


    }

    private fun contoh() {
        GlobalScope.launch {
            delay(2000)

            /*val a = async { "Hello World" }
            val hasil = a.await()
            Log.d("globalScope", hasil)*/
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
    }
}