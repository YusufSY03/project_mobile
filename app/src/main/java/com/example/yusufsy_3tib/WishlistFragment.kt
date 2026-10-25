package com.example.yusufsy_3tib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.yusufsy_3tib.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {
    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    // Data List dengan URL Gambar yang stabil
    private val destinasiList = listOf(
        DestinasiModel("Jam Gadang", "Ikon kota Bukittinggi...", R.drawable.jam_gadang),
        DestinasiModel("Kawasan Mandeh", "Gugusan pulau memukau...", R.drawable.mandeh1),
        DestinasiModel("Lembah Harau", "Lembah subur...", R.drawable.lembah_harau),
        DestinasiModel("Istano Basa", "Istana replika...", R.drawable.pagaruyuang)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        val adapter = DestinasiAdapter(requireContext(), destinasiList)
        binding.listViewDestinasi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}