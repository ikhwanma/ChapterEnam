package ikhwan.binar.chapterenam.designpattern.mvp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpattern.mvp.model.GetNewsResponseItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val listNews : List<GetNewsResponseItem>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listNews[position]

        holder.itemView.apply {
            tv_title.text = data.title
            tv_author.text = data.author
            tv_tanggal.text = data.createdAt
            Glide.with(holder.itemView).load(data.image).into(holder.itemView.img_film)
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}