package com.example.birthdaynotifier

import androidx.room.*

@Dao
interface birthday_dao {

    @Query("SELECT * FROM birthday ORDER BY month ASC, day ASC")
    fun get_birthdays() : MutableList<birthday>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add_birthday(vararg bd: birthday)

    @Delete
    fun delete_birthday(bd: birthday)
}