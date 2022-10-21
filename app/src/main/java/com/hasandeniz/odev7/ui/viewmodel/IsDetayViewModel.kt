package com.hasandeniz.odev7.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hasandeniz.odev7.data.entity.YapilacakIs
import com.hasandeniz.odev7.data.repo.IsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IsDetayViewModel @Inject constructor(var irepo:IsRepository): ViewModel() {

    fun guncelle(is_id:Int, is_tanim:String) {
        CoroutineScope(Dispatchers.Main).launch {
            irepo.guncelle(is_id, is_tanim)
        }
    }
}