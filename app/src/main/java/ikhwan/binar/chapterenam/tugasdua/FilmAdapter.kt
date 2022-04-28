package ikhwan.binar.chapterenam.tugasdua

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterlima.networking.model.GetFilmResponseItem
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter(
    private val listFilm: List<GetFilmResponseItem>
) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listFilm[position]

        holder.itemView.apply {
            tv_film.text = data.name
            tv_sutradara.text = data.director
            tv_tanggal.text = data.date
            this@FilmAdapter.let {
                Glide.with(holder.itemView)
                    .load(data.image)
                    .into(holder.itemView.img_film)
            }
        }
    }

    override fun getItemCount(): Int {
        if(listFilm == null){
            return 0
        }else{
            return listFilm.size
        }
    }
}