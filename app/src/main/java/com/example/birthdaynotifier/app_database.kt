package com.example.birthdaynotifier

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(birthday::class), version = 1)
abstract class app_database() : RoomDatabase() {
    abstract fun get_birthday_dao() : birthday_dao
}
