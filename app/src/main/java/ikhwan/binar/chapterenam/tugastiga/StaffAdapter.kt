package ikhwan.binar.chapterenam.tugastiga

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.tugastiga.model.GetStaffResponseItem
import kotlinx.android.synthetic.main.item_staff.view.*

class StaffAdapter(private val listStaff : List<GetStaffResponseItem>): RecyclerView.Adapter<StaffAdapter.ViewHolder>() {
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_staff, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listStaff[position]

        holder.itemView.apply {
            tv_name.text = data.name
            tv_email.text = data.email
            Glide.with(holder.itemView).load(data.image).into(img_staff)
        }
    }

    override fun getItemCount(): Int {
        return listStaff.size
    }
}