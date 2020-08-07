package com.example.synrgy_sharedprefernces

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val SP_NAME = "data_user"
//        const val FIELD_NAME = "name"
//        const val FIELD_PASSWORD = "password"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //akan mendapatkan SP dengan nama data_user, kalau belum ada, bakalan membuat file SP nya
        val sharedPreferences = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
//        val nameInSP = sharedPreferences.getString(FIELD_NAME, "No Data")
//        val ageInSP = sharedPreferences.getInt(FIELD_PASSWORD, -1)
        val modeLogin = sharedPreferences.getBoolean("modeLogin", false)

        if (modeLogin){
           val intent = Intent (this, Dashboard::class.java)
           startActivity(intent)
           finish()
        }

        btnSave.setOnClickListener{
            val editor = sharedPreferences.edit()

            if (cbIngatSaya.isChecked) {
                editor.putBoolean("modeLogin", true)
            } else {
                editor.putBoolean("modeLogin", false)
            }
            editor.putString("name", etName.text.toString())

            val intent = Intent (this, Dashboard::class.java)
            startActivity(intent)

            editor.apply()
        }

//        tvName.setText(nameInSP)
//        tvAge.setText(ageInSP.toString())
//
//        btnSave.setOnClickListener{
//            val editor = sharedPreferences.edit()
//
//            editor.putString(FIELD_NAME, etName.text.toString())
//            editor.putInt(FIELD_PASSWORD, etAge.text.toString().toInt())
//
//            //kesimpan aja ga tau kesimpan dimana
////            editor.apply()
//
//            //kesimpan dan bisa return lagi :
//            val isSaved = editor.commit()
//
//            if (isSaved) {
//                Toast.makeText(this, "Data dapat tersimpan", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(this, "Data gagal disimpan", Toast.LENGTH_LONG).show()
//            }
//        }
    }
}