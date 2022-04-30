package ikhwan.binar.chapterenam.tugastiga.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterenam.tugastiga.StaffAdapter
import ikhwan.binar.chapterenam.tugastiga.model.GetStaffResponseItem
import ikhwan.binar.chapterenam.tugastiga.presenter.StaffPresenter
import ikhwan.binar.chapterenam.tugastiga.presenter.StaffView
import kotlinx.android.synthetic.main.activity_main_tugas_tiga.*

class MainTugasTigaActivity : AppCompatActivity(), StaffView {

    private lateinit var staffPresenter: StaffPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tugas_tiga)

        staffPresenter = StaffPresenter(this)
        staffPresenter.getStaff()
    }

    override fun onSuccess(message: String, listNews: List<GetStaffResponseItem>) {
        rv_staff.layoutManager = GridLayoutManager(this, 2)
        rv_staff.adapter = StaffAdapter(listNews)
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}