package com.example.alarm_manager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.TimePicker
import java.util.*


class MainActivity : AppCompatActivity() {


    private var timePicker : TimePicker? = null
    private var hour = 0
    private var minute  = 0
    private var alarmManager : AlarmManager? = null
            //= applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alarmManager = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        timePicker  = findViewById<TimePicker>(R.id.TimePicker)
    }
    fun regist(view : View){
        val intent = Intent(this, Alarm::class.java)
        val pIntent = PendingIntent.getBroadcast(this, 0, intent, 0)


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){//버전에 따른 시간 세팅인듯

            hour = timePicker!!.hour
            minute = timePicker!!.minute
        }

        val calendar : Calendar = Calendar.getInstance() //현재시간으로 세팅
        calendar.set(Calendar.HOUR_OF_DAY, hour) // 시간단위 입력 Calendar.HOUR_OF_DAY
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        Log.d("전", "여기까지 실행 1")
        alarmManager!!.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pIntent);

    } //Regist()

        fun unregist(view : View){
            val intent = Intent(this, Alarm::class.java)
            val pIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
            alarmManager!!.cancel(pIntent)
        }


}


