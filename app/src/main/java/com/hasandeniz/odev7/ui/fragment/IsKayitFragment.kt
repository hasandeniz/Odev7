package com.hasandeniz.odev7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.hasandeniz.odev7.R
import com.hasandeniz.odev7.databinding.FragmentIsKayitBinding
import com.hasandeniz.odev7.ui.viewmodel.IsKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IsKayitFragment : Fragment() {
    private lateinit var binding: FragmentIsKayitBinding
    private val viewModel : IsKayitViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_is_kayit,container, false)
        binding.isKayitFragmentNesnesi = this
        binding.isKayitToolbarBaslik = "Yapılacak İş Kayıt"

        return binding.root
    }

    fun butonKaydet(view: View, is_tanim:String) {
        viewModel.kaydet(is_tanim)
        Navigation.findNavController(view).navigate(R.id.action_isKayitFragment_to_anasayfaFragment)
    }
}