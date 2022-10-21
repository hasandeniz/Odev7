package com.hasandeniz.odev7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hasandeniz.odev7.data.entity.YapilacakIs

@Dao
interface IslerDao {
    @Query("SELECT * FROM isler")
    suspend fun isleriYukle() : List<YapilacakIs>

    @Insert
    suspend fun kaydet(yapilacakIs:YapilacakIs)

    @Update
    suspend fun guncelle(yapilacakIs: YapilacakIs)

    @Delete
    suspend fun sil(yapilacakIs: YapilacakIs)

    @Query("SELECT * FROM isler WHERE is_tanim like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<YapilacakIs>

}