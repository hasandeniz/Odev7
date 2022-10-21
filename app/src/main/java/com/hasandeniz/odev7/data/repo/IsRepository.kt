package com.hasandeniz.odev7.data.repo

import com.hasandeniz.odev7.data.datasource.IsDataSource
import com.hasandeniz.odev7.data.entity.YapilacakIs

class IsRepository(var ids: IsDataSource) {

    suspend fun kaydet(is_tanim:String) = ids.kaydet(is_tanim)

    suspend fun guncelle(is_id:Int, is_tanim:String) = ids.guncelle(is_id,is_tanim)

    suspend fun isleriYukle() : List<YapilacakIs> = ids.isleriYukle()

    suspend fun ara(aramaKelimesi:String) : List<YapilacakIs> = ids.ara(aramaKelimesi)

    suspend fun sil(is_id:Int) = ids.sil(is_id)
}