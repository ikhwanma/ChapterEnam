package ikhwan.binar.chapterenam.designpattern.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem
import ikhwan.binar.chapterenam.designpattern.mvp.presenter.DetailNewsPresenter
import ikhwan.binar.chapterenam.designpattern.mvp.presenter.DetailNewsView
import kotlinx.android.synthetic.main.activity_detail_mvp.*

class DetailMvpActivity : AppCompatActivity(), DetailNewsView {

    private lateinit var detailNewsPresenter: DetailNewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mvp)

        val id = intent.getStringExtra("id")

        detailNewsPresenter = DetailNewsPresenter(this)
        detailNewsPresenter.getDetailNews(id.toString())


    }

    override fun onSuccess(message: String, detailNews: GetNewsResponseItem) {
        Glide.with(this).load(detailNews.image).into(img_news)
        tv_title.text = detailNews.title
        tv_author.text = detailNews.author
        tv_author.append(" (${detailNews.createdAt})")
        tv_deskripsi.text = detailNews.description
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}