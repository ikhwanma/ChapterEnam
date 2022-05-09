package ikhwan.binar.chapterenam.datastore.latihandatastoresatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.asLiveData
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_home_latihan_data_store_satu.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class HomeLatihanDataStoreSatuActivity : AppCompatActivity() {

    private lateinit var latihanSatuDataStoreManager: LatihanSatuDataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_latihan_data_store_satu)

        supportActionBar?.hide()

        latihanSatuDataStoreManager = LatihanSatuDataStoreManager(this)

        latihanSatuDataStoreManager.userName.asLiveData().observe(this){
            tv_hello.append(" ${it.replaceFirstChar { str -> if (str.isLowerCase()) str.titlecase(Locale.getDefault()) else str.toString() }}!")
        }

        btn_logout.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Logout")
                .setMessage("Apakah anda yakin ingin logout?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Yes") { _, _ ->
                    GlobalScope.launch {
                        latihanSatuDataStoreManager.clearData()
                        startActivity(Intent(this@HomeLatihanDataStoreSatuActivity, MainLatihanDataStoreSatuActivity::class.java))
                        finish()
                    }
                }.setNegativeButton("No") { _, _ ->

                }
                .show()
        }
    }
}