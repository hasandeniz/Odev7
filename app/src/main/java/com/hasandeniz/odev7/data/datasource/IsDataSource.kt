package com.hasandeniz.odev7.data.datasource

import android.util.Log
import com.hasandeniz.odev7.data.entity.YapilacakIs
import com.hasandeniz.odev7.room.IslerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IsDataSource(var idao:IslerDao) {

    suspend fun kaydet(is_tanim:String) {
        val yeniIs = YapilacakIs(0,is_tanim)
        idao.kaydet(yeniIs)
    }

    suspend fun guncelle(is_id:Int, is_tanim:String) {
        val guncellenenIs = YapilacakIs(is_id,is_tanim)
        idao.guncelle(guncellenenIs)
    }

    suspend fun isleriYukle() : List<YapilacakIs> =
        withContext(Dispatchers.IO){
            idao.isleriYukle()
        }

    suspend fun ara(aramaKelimesi:String) : List<YapilacakIs> =
        withContext(Dispatchers.IO){
            idao.ara(aramaKelimesi)
        }

    suspend fun sil(is_id:Int){
        val silinenIs = YapilacakIs(is_id,"")
        idao.sil(silinenIs)
    }
}