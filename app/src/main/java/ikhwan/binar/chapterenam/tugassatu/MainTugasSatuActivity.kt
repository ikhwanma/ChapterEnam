package ikhwan.binar.chapterenam.tugassatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_kelas_thread.*
import kotlinx.android.synthetic.main.activity_main_tugas_satu.*

class MainTugasSatuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tugas_satu)

        Thread(Runnable {
            btn_hitung.setOnClickListener {
                val bb = et_berat.text.toString().toDouble()
                val tb = et_tinggi.text.toString().toDouble() / 100
                val bmi = bb/Math.pow(tb, 2.0)

                val ket = cekKeterangan(bmi)

                tv_thread.post(Runnable {
                    tv_thread.text = "Thread :"
                    tv_thread.append(" $ket")
                })
            }
        }).start()

        val handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val message = msg.obj as String
                tv_handler.text = "Thread dan Handler :"
                tv_handler.append(" $message")
            }
        }

        Thread(Runnable {
            btn_hitung_handler.setOnClickListener {
                val bb = et_berat.text.toString().toDouble()
                val tb = et_tinggi.text.toString().toDouble() / 100
                val bmi = bb/Math.pow(tb, 2.0)

                val msg = Message.obtain()
                msg.obj = cekKeterangan(bmi)
                msg.target = handler
                msg.sendToTarget()

            }
        }).start()
    }

    private fun cekKeterangan(bmi: Double): String {
        return if (bmi < 18.5){
            "Kurus"
        }else if (bmi in 18.5 .. 24.9){
            "Normal"
        }else if (bmi in 24.9 .. 29.9){
            "Overweight"
        }else{
            "Obesitas"
        }
    }
}