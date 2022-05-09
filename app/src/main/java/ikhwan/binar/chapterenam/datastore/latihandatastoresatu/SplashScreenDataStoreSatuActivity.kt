package ikhwan.binar.chapterenam.datastore.latihandatastoresatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.asLiveData
import ikhwan.binar.chapterenam.R

class SplashScreenDataStoreSatuActivity : AppCompatActivity() {

    private lateinit var latihanSatuDataStoreManager: LatihanSatuDataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_data_store_satu)

        supportActionBar?.hide()

        latihanSatuDataStoreManager = LatihanSatuDataStoreManager(this)

        Handler(Looper.getMainLooper()).postDelayed({
            latihanSatuDataStoreManager.boolean.asLiveData().observe(this){
                if (it == true){
                    startActivity(Intent(this, HomeLatihanDataStoreSatuActivity::class.java))
                    finish()
                }else{
                    startActivity(Intent(this, MainLatihanDataStoreSatuActivity::class.java))
                    finish()
                }
            }
        }, 1000)
    }
}