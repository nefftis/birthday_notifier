package com.example.birthdaynotifier

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class birthday_adapter(birthdayDao: birthday_dao, day : Int, month : Int) : RecyclerView.Adapter<bithday_item_holder>() {

    var birthdays : MutableList<birthday>
    val current_day : Int
    val current_month : Int
    init {
        birthdays = birthdayDao.get_birthdays()
        val birthdays_iterator = birthdays.iterator()

        current_day = day
        current_month = month
        val new_birthdays = mutableListOf<birthday>()

        // сортируем по месяцам
        val index = 0
        while (birthdays_iterator.hasNext()) {
            val bd = birthdays_iterator.next()
            if(bd.month == current_month && bd.day == current_day)
                new_birthdays.add(0, bd)
            else
                new_birthdays.add(bd)
        }
        birthdays = new_birthdays
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bithday_item_holder {

        // Создаем хранилище для контрола информации о дне рождения и возвращаем его
        val view = LayoutInflater.from(parent.context).inflate(R.layout.birthday_item, parent, false)

        return bithday_item_holder(view)
    }

    override fun onBindViewHolder(holder: bithday_item_holder, position: Int) {
        val b = birthdays.get(position)

        //holder.birthday_instance = b;
        holder.name_view.setText(b.name)
        holder.birthday_view.setText(b.day.toString().plus(".")  + b.month.toString() + '.' + b.year)
        if(b.day == current_day && b.month == current_month)
           holder.background_view.setBackgroundColor(Color.parseColor("#f36f78"));
        else
            holder.background_view.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    override fun getItemCount(): Int {
        return birthdays.size
    }
}