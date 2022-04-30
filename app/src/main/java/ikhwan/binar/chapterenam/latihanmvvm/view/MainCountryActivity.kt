package ikhwan.binar.chapterenam.latihanmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.latihanmvvm.network.CountryApiClient
import ikhwan.binar.chapterenam.latihanmvvm.viewmodel.MainCountryViewModel
import ikhwan.binar.latihanlistcountryretrofit.model.GetCountryResponseItem
import kotlinx.android.synthetic.main.activity_main_country.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainCountryActivity : AppCompatActivity() {

    private val viewModel : MainCountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_country)

        viewModel.getCountry()
        viewModel.liveDataCountry.observe(this){
            rv_country.layoutManager = GridLayoutManager(this@MainCountryActivity, 2)
            rv_country.adapter = CountryAdapter(it!!)
        }

    }
}