package ikhwan.binar.chapterenam.designpattern.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem
import ikhwan.binar.chapterenam.designpattern.mvp.presenter.DetailNewsPresenter
import ikhwan.binar.chapterenam.designpattern.mvp.presenter.DetailNewsView
import ikhwan.binar.chapterenam.designpatternmvvm.model.GetMvvmNewsResponseItem
import ikhwan.binar.chapterlima.networking.model.GetFilmResponseItem
import kotlinx.android.synthetic.main.activity_detail_mvp.*

class DetailMvpActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mvp)


        val detailNews = intent.getParcelableExtra<GetMvvmNewsResponseItem>("detail") as GetMvvmNewsResponseItem

        Glide.with(this).load(detailNews.image).into(img_news)
        tv_title.text = detailNews.title
        tv_author.text = detailNews.author
        tv_author.append(" (${detailNews.createdAt})")
        tv_deskripsi.text = detailNews.description

    }

    /*override fun onSuccess(message: String, detailNews: GetNewsResponseItem) {
        Glide.with(this).load(detailNews.image).into(img_news)
        tv_title.text = detailNews.title
        tv_author.text = detailNews.author
        tv_author.append(" (${detailNews.createdAt})")
        tv_deskripsi.text = detailNews.description
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }*/
}