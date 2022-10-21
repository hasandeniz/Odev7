package com.hasandeniz.odev7.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.hasandeniz.odev7.R
import com.hasandeniz.odev7.data.entity.YapilacakIs
import com.hasandeniz.odev7.databinding.FragmentAnasayfaBinding
import com.hasandeniz.odev7.ui.adapter.IsAdapter
import com.hasandeniz.odev7.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnasayfaBinding
    private val viewModel : AnasayfaViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)

        binding.anasayfaFragmentNesnesi = this
        binding.anasayfaToolbarBaslik = "Yapılacaklar"
        //toolbarda arama yapabilmek için bu gerekli
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)


        viewModel.islerListesi.observe(viewLifecycleOwner){
            val adapter = IsAdapter(requireContext(),it,viewModel)
            binding.isAdapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.anasayfa_toolbar_menu,menu)

                val item = menu.findItem(R.id.actionAra)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false

            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    fun fabTikla(view:View){
        Navigation.findNavController(view).navigate(R.id.action_anasayfaFragment_to_isKayitFragment)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.isleriYukle()
    }

}