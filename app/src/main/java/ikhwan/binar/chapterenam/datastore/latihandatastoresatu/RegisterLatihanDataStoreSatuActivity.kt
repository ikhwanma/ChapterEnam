package ikhwan.binar.chapterenam.datastore.latihandatastoresatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.chapterenam.R

import kotlinx.android.synthetic.main.activity_register_latihan_data_store_satu.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterLatihanDataStoreSatuActivity : AppCompatActivity() {

    private lateinit var latihanSatuDataStoreManager: LatihanSatuDataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_latihan_data_store_satu)

        supportActionBar?.hide()

        latihanSatuDataStoreManager = LatihanSatuDataStoreManager(this)

        btn_register.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            GlobalScope.launch {
                latihanSatuDataStoreManager.registerUser(username, password)
            }

            startActivity(Intent(this, MainLatihanDataStoreSatuActivity::class.java))
            finish()
        }
    }
}