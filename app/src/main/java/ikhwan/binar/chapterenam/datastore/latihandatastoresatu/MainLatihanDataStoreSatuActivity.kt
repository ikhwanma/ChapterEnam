package ikhwan.binar.chapterenam.datastore.latihandatastoresatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_main_latihan_data_store_satu.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainLatihanDataStoreSatuActivity : AppCompatActivity() {

    private lateinit var latihanSatuDataStoreManager: LatihanSatuDataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_latihan_data_store_satu)

        supportActionBar?.hide()

        latihanSatuDataStoreManager = LatihanSatuDataStoreManager(this)

        btn_register.setOnClickListener {
            startActivity(Intent(this, RegisterLatihanDataStoreSatuActivity::class.java))
        }

        btn_login.setOnClickListener {
            val lgnUsername = et_username.text.toString()
            val lgnPassword = et_password.text.toString()

            latihanSatuDataStoreManager.userName.asLiveData().observe(this){
                if (lgnUsername == it){
                    latihanSatuDataStoreManager.password.asLiveData().observe(this){ data ->
                        if (lgnPassword == data){
                            GlobalScope.launch {
                                latihanSatuDataStoreManager.setLogin(true)
                            }
                            startActivity(Intent(this, HomeLatihanDataStoreSatuActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "Password salah", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Username belum terdaftar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}