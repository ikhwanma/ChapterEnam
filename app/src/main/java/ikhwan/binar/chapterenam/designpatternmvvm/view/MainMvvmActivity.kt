package ikhwan.binar.chapterenam.designpatternmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpatternmvvm.viewmodel.MainMvvMViewModel
import kotlinx.android.synthetic.main.activity_main_mvvm.*


class MainMvvmActivity : AppCompatActivity() {

    private val viewModel : MainMvvMViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvvm)

        viewModel.getNews()
        viewModel.liveDataNews.observe(this){
            rv_news.layoutManager = LinearLayoutManager(this@MainMvvmActivity)
            rv_news.adapter = MvvmNewsAdapter(it!!)
        }
    }
}