package com.example.synrgy_sharedprefernces

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val sharedPreferences: SharedPreferences = getSharedPreferences(MainActivity.SP_NAME,MODE_PRIVATE)

        var nameSP = sharedPreferences.getString("name", "No Data")

        namaLogin.text = nameSP
    }
}