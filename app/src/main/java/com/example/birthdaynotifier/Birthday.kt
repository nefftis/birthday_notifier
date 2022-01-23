package com.example.birthdaynotifier

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "birthday")
class birthday() : Comparable<birthday> {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
        get() {
            return field;
        }
        set (value) { field = value}

    @ColumnInfo(name = "name")
    var name: String = ""
        get() {
            return field;
        }
        set (value) { field = value}

    @ColumnInfo(name = "year")
    var year : Int = 0
        get() {
            return field;
        }
        set (value) { field = value}

    @ColumnInfo(name = "month") var month : Int = 0
        get() {
            return field;
        }
        set (value) { field = value}

    @ColumnInfo(name = "day")
    var day : Int = 0
        get() {
            return field;
        }
        set (value) { field = value}

    override fun compareTo(other: birthday): Int = when {
        this.month != other.month -> this.month compareTo other.month // compareTo() in the infix form
        this.day != other.day -> this.day compareTo other.day
        else -> 0
    }
}