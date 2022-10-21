package com.hasandeniz.odev7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hasandeniz.odev7.data.entity.YapilacakIs

@Database(entities = [YapilacakIs::class], version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun getIslerDao() : IslerDao
}