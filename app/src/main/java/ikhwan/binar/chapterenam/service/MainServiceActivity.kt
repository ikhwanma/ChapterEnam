package ikhwan.binar.chapterenam.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_main_service.*

class MainServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_service)

        btn_play.setOnClickListener {
            startService(Intent(this, ServicePlayer::class.java))
        }

        btn_stop.setOnClickListener {
            stopService(Intent(this, ServicePlayer::class.java))
        }
    }
}