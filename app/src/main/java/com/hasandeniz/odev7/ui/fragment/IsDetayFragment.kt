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
import androidx.navigation.fragment.navArgs
import com.hasandeniz.odev7.R
import com.hasandeniz.odev7.data.entity.YapilacakIs
import com.hasandeniz.odev7.databinding.FragmentIsDetayBinding
import com.hasandeniz.odev7.ui.viewmodel.IsDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IsDetayFragment : Fragment() {
    private lateinit var binding: FragmentIsDetayBinding
    private val viewModel : IsDetayViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bundle : IsDetayFragmentArgs by navArgs()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_is_detay ,container, false)
        binding.isDetayFragmentNesnesi = this
        binding.isDetayToolbarBaslik = "Yapılacak İş Detay"
        binding.isNesnesi = bundle.yapilacakIs

        return binding.root
    }

    fun butonGuncelle(view: View,is_id:Int, is_tanim:String) {
        viewModel.guncelle(is_id, is_tanim)
        Navigation.findNavController(view).navigate(R.id.action_isDetayFragment_to_anasayfaFragment)
    }
}