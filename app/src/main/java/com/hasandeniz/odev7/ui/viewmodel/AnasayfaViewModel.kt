package com.hasandeniz.odev7.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasandeniz.odev7.data.entity.YapilacakIs
import com.hasandeniz.odev7.data.repo.IsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var irepo:IsRepository) : ViewModel() {

    var islerListesi = MutableLiveData<List<YapilacakIs>>()

    init {
        isleriYukle()
    }

    fun isleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = irepo.isleriYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = irepo.ara(aramaKelimesi)
        }
    }

    fun sil(is_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            irepo.sil(is_id)
            isleriYukle()
        }
    }
}