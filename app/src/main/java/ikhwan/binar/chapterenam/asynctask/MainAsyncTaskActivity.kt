@file:Suppress("DEPRECATION")

package ikhwan.binar.chapterenam.asynctask

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ikhwan.binar.chapterenam.R
import kotlinx.android.synthetic.main.activity_main_async_task.*
import kotlinx.android.synthetic.main.activity_main_async_task.et_berat
import kotlinx.android.synthetic.main.activity_main_async_task.et_tinggi

class MainAsyncTaskActivity : AppCompatActivity() {

    lateinit var  context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async_task)
        context = this

        btn_hitung.setOnClickListener {
            ContohAsyncTask().execute()
        }

    }

    inner class ContohAsyncTask : AsyncTask<Int, Void, String>() {

        private lateinit var progressDialog : ProgressDialog

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(context)
            progressDialog.show()
        }

        override fun doInBackground(vararg p0: Int?): String {
            val bb = et_berat.text.toString().toDouble()
            val tb = et_tinggi.text.toString().toDouble() / 100
            val bmi = bb/Math.pow(tb, 2.0)

            val ket = if (bmi < 18.4){
                "Berat badang kurang"
            }else if (bmi in 18.5 .. 24.9){
                "Berat badan ideal"
            }else if (bmi in 25.0 .. 29.9){
                "Berat badan lebih"
            }else if (bmi in 30.0 .. 39.9){
                "Gemuk"
            }else{
                "Sangat gemuk"
            }

            return ket
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tv_hasil.text = "Hasil : "
            tv_hasil.append(result)
            progressDialog.dismiss()
            et_berat.setText("")
            et_tinggi.setText("")
        }

    }
}