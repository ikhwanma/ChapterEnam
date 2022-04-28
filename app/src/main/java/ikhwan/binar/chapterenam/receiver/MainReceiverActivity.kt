package ikhwan.binar.chapterenam.receiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.chapterenam.R

class MainReceiverActivity : AppCompatActivity() {

    lateinit var airplaneModeReceiver: AirplaneModeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_receiver)

        airplaneModeReceiver = AirplaneModeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneModeReceiver, it)
        }
    }
}