package ikhwan.binar.chapterenam.datastore.kelassatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_main_kelas_data_store.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainKelasDataStoreActivity : AppCompatActivity() {

    private lateinit var kelasDataStoreManager: KelasDataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kelas_data_store)

        kelasDataStoreManager = KelasDataStoreManager(this)


        btn_save.setOnClickListener {
            val name = et_nama.text.toString()
            val age = et_age.text.toString().toInt()

            GlobalScope.launch {
                kelasDataStoreManager.saveData(name, age)
            }
        }

        kelasDataStoreManager.userName.asLiveData().observe(this){
            tv_name.text = it
        }

        kelasDataStoreManager.userAge.asLiveData().observe(this){
            tv_age.text = it.toString()
        }

        btn_delete.setOnClickListener {
            GlobalScope.launch {
                kelasDataStoreManager.clearData()
            }
        }
    }
}