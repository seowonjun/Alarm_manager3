package com.example.alarm_manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class Alarm : BroadcastReceiver(){

    var context : Context? = null
    override fun onReceive(Context: Context, Intent: Intent) {
        var intent2 = Intent("android.intent.action.sec")
        intent2.setClass(Context, DoitActivity2::class.java )
        intent2.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK
        Toast.makeText(Context, "알람~!!", Toast.LENGTH_SHORT).show()
        Log.e("Alarm", "알람입니다.")

       this.context = Context
       this.context!!.startActivity(intent2)
    }

}