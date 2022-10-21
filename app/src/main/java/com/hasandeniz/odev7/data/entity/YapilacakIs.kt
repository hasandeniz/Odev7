package com.hasandeniz.odev7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "isler")
data class YapilacakIs (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "is_id") var is_id:Int,

    @ColumnInfo(name = "is_tanim") var is_tanim:String) : Serializable