package ikhwan.binar.chapterenam.thread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.thread.hitungumur.MainHitungActivity
import kotlinx.android.synthetic.main.activity_kelas_thread.*

class KelasThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelas_thread)

//        contohThread()
//        contohHandler()
        contohHandlerThread()
        contohHandlerThreadDua()
    }

    private fun contohHandlerThreadDua() {
        val handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val message = msg.obj as String
                tv_dua.text = message
            }
        }
        Thread(Runnable {
            btn_change.setOnClickListener {
                val msg = Message.obtain()
                msg.obj = "Ini dari button"
                msg.target = handler
                msg.sendToTarget()
            }
        }).start()
    }

    private fun contohHandlerThread() {
        val handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val message = msg.obj as String
                tv_satu.text = message
            }
        }

        Thread(Runnable {
            val a = "Contoh Handler Thread"
            val msg = Message.obtain()
            msg.obj = a
            msg.target = handler
            msg.sendToTarget()
        }).start()
    }


    private fun contohHandler() {
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this, MainHitungActivity::class.java))
        },7000)

        Handler(Looper.getMainLooper()).post(Runnable {
            tv_satu.text = "Haloooooo"
        })
    }

    private fun contohThread() {

        Thread(Runnable {
            /*tv_satu.post(Runnable {
                tv_satu.text = "Hello"
            })*/

            tv_dua.postDelayed(Runnable {
                tv_dua.text = "World"
            }, 2000)

            btn_change.setOnClickListener{
                tv_satu.post(Runnable {
                    tv_satu.text = "Halo"
                })

                tv_dua.postDelayed(Runnable {
                    tv_dua.text = "Dunia"
                }, 2000)
            }
        }).start()
    }


}