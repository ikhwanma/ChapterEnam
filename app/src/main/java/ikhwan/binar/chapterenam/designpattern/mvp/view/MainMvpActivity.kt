package ikhwan.binar.chapterenam.designpattern.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem
import ikhwan.binar.chapterenam.designpattern.mvp.network.NetApiClient
import ikhwan.binar.chapterenam.designpattern.mvp.adapter.NewsAdapter
import ikhwan.binar.chapterenam.designpattern.mvp.presenter.NewsPresenter
import ikhwan.binar.chapterenam.designpattern.mvp.presenter.NewsView
import kotlinx.android.synthetic.main.activity_main_mvp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMvpActivity : AppCompatActivity() , NewsView{

    private lateinit var newsPresenter : NewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mvp)

        newsPresenter = NewsPresenter(this)
        newsPresenter.getNews()

    }

    override fun onSuccess(message: String, listNews: List<GetNewsResponseItem>) {
        rv_news.layoutManager = LinearLayoutManager(this)
        val adapter = NewsAdapter(listNews)
        rv_news.adapter = adapter
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}