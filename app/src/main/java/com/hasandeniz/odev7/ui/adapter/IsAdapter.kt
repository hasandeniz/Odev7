package com.hasandeniz.odev7.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hasandeniz.odev7.R
import com.hasandeniz.odev7.data.entity.YapilacakIs
import com.hasandeniz.odev7.databinding.CardTasarimBinding
import com.hasandeniz.odev7.ui.fragment.AnasayfaFragmentDirections
import com.hasandeniz.odev7.ui.viewmodel.AnasayfaViewModel

class IsAdapter(var mContext: Context,
                var isListesi:List<YapilacakIs>,
                var viewModel:AnasayfaViewModel)
    : RecyclerView.Adapter<IsAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(binding:CardTasarimBinding) : RecyclerView.ViewHolder(binding.root){
        var binding:CardTasarimBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim ,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacakIs = isListesi[position]
        val binding = holder.binding
        binding.isNesnesi = yapilacakIs

        binding.satirCard.setOnClickListener {
            val action = AnasayfaFragmentDirections.actionAnasayfaFragmentToIsDetayFragment(yapilacakIs)
            Navigation.findNavController(it).navigate(action)
        }

        binding.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacakIs.is_tanim} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacakIs.is_id)
                }.show()
        }
    }



    override fun getItemCount(): Int {
        return isListesi.size
    }
}