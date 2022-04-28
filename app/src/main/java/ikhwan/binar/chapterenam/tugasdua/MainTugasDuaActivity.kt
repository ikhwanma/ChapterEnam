@file:Suppress("DEPRECATION")

package ikhwan.binar.chapterenam.tugasdua

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ikhwan.binar.chapterenam.R
import ikhwan.binar.chapterlima.networking.model.GetFilmResponseItem
import ikhwan.binar.chapterlima.networking.network.ApiClient
import kotlinx.android.synthetic.main.activity_main_tugas_dua.*

class MainTugasDuaActivity : AppCompatActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tugas_dua)
        context = this

        BackgroundProcess().execute()
    }

    inner class BackgroundProcess : AsyncTask<Void, Void, List<GetFilmResponseItem>>() {

        private lateinit var progressDialog : ProgressDialog
        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(context)
            progressDialog.setMessage("Getting Data...")
            progressDialog.show()
        }

        override fun onPostExecute(result: List<GetFilmResponseItem>?) {
            super.onPostExecute(result)
            rv_film.layoutManager = LinearLayoutManager(context)
            val adapter = result?.let { FilmAdapter(it) }
            rv_film.adapter = adapter
            progressDialog.dismiss()
        }

        override fun doInBackground(vararg p0: Void?): List<GetFilmResponseItem> {
            return ApiClient.instance.getFilm().execute().body()!!
        }

    }
}