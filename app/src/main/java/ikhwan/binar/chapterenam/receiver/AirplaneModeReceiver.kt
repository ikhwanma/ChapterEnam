package ikhwan.binar.chapterenam.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val airplaneMode = p1?.getBooleanExtra("state", false)

        Log.d("airplaneMode", airplaneMode.toString())

        if (airplaneMode == true){
            Toast.makeText(p0, "Mode Pesawat Aktif", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(p0, "Mode Pesawat Tidak Aktif", Toast.LENGTH_SHORT).show()
        }
    }
}