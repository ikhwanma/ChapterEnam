package ikhwan.binar.chapterenam.designpatternmvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.designpatternmvvm.model.GetMvvmNewsResponseItem
import kotlinx.android.synthetic.main.item_news.view.*

class MvvmNewsAdapter(private val listNews : List<GetMvvmNewsResponseItem>) : RecyclerView.Adapter<MvvmNewsAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return MvvmNewsAdapter.ViewHolder(itemView)
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