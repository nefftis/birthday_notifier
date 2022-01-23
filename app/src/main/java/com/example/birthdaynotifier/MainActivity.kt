package com.example.birthdaynotifier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import java.text.SimpleDateFormat
import java.util.*

class MainActivity() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text_date = findViewById<TextView>(R.id.date_text)
        val button = findViewById<AppCompatButton>(R.id.add_button)
        val calendar = Calendar.getInstance()
        val simple_date_format = SimpleDateFormat("dd-MM-yyyy")
        val date = simple_date_format.format(calendar.time)
        text_date.setText("Сегодня: " + date);

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH) + 1

        // button.setBackgroundColor("");

        val data_base = Room.databaseBuilder(this, app_database::class.java, "birthday_db3.db")
            .allowMainThreadQueries()
            .build()

        val recycler_view = findViewById<RecyclerView>(R.id.birthday_list)
        recycler_view.layoutManager = LinearLayoutManager(this)
        val adapter = birthday_adapter(data_base.get_birthday_dao(), day, month)
        recycler_view.adapter = adapter

        button.setOnClickListener{
            val intent = Intent(this, BirthdayActivity::class.java)
            startActivity(intent)
            finish()
        }

        var button_background : Int = 1;

        //button.setOnFocusChangeListener{ _, hasFocus ->
        //    if (hasFocus)
        //        button.setBackgroundResource(R.drawable.btn_center_gradient);
        //    else
        //        button.setBackgroundResource(R.drawable.btn_oval_gradient);
        //}
    }
}