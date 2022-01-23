package com.example.birthdaynotifier

import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class bithday_item_holder(val view : View) : RecyclerView.ViewHolder(view) {

    var name_view: TextView = view.findViewById<TextView>(R.id.name_list_item)
        get() = field

    var birthday_view: TextView = view.findViewById<TextView>(R.id.birthday_list_item)
        get() = field

    var background_view : LinearLayout = view.findViewById<LinearLayout>(R.id.background_list_item)
        get() = field

   // var birthday_instance: birthday = TODO()
   //     get() = field

    //val delete_button = view.findViewById<AppCompatButton>(R.id.delete_button)

    init {
        //delete_button.setOnClickListener {

            //val intent = Intent(this, MainActivity::class.java)
           //startActivity(intent)
            //finish()

            //val data_base = Room.databaseBuilder(null, app_database::class.java, "birthday_db3.db")
            //    .allowMainThreadQueries()
           //    .build()

           // val dao = data_base.get_birthday_dao()

           // dao.delete_birthday(birthday_instance)
        //}
    }
}