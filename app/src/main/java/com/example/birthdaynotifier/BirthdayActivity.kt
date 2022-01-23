package com.example.birthdaynotifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.room.Room

class BirthdayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)

        val button = findViewById<AppCompatButton>(R.id.btn_ok)
        val name_view = findViewById<EditText>(R.id.etName)
        val year_view = findViewById<EditText>(R.id.etYear)
        val month_view = findViewById<EditText>(R.id.etMonth)
        val day_view = findViewById<EditText>(R.id.etDay)

        button.setOnClickListener{
            val name = name_view.text.toString()
            val year = year_view.text.toString().toInt()
            val month = month_view.text.toString().toInt()
            val day = day_view.text.toString().toInt()

            val data_base = Room.databaseBuilder(this, app_database::class.java, "birthday_db3.db")
                .allowMainThreadQueries()
                .build()

            val dao = data_base.get_birthday_dao()
            val bd = birthday()
            bd.month = month
            bd.day = day
            bd.year = year
            bd.name = name

            dao.add_birthday(bd)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}