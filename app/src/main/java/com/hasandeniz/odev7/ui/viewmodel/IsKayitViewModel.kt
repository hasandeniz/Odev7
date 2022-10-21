package com.hasandeniz.odev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.hasandeniz.odev7.data.repo.IsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IsKayitViewModel @Inject constructor(var irepo:IsRepository): ViewModel() {

    fun kaydet(is_tanim:String){
        CoroutineScope(Dispatchers.Main).launch{
            irepo.kaydet(is_tanim)
        }
    }
}