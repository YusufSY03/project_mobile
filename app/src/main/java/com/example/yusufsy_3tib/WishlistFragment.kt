package com.example.yusufsy_3tib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yusufsy_3tib.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {
    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tampilan awal: tampilkan semua destinasi wishlist
        binding.listViewDestinasi.adapter = DestinasiAdapter(requireContext(), daftarWishlist)

        // Filter kategori menggunakan ChipGroup
        binding.chipGroupKategori.setOnCheckedStateChangeListener { _, checkedIds ->
            val selectedId = checkedIds.firstOrNull()

            val hasilFilter = when (selectedId) {
                R.id.chipAlam -> daftarWishlist.filter { it.kategori == "Alam" }
                R.id.chipSejarah -> daftarWishlist.filter { it.kategori == "Sejarah" }
                R.id.chipBudaya -> daftarWishlist.filter { it.kategori == "Budaya" }
                else -> daftarWishlist
            }

            // Pasang adapter baru dengan data hasil saringan
            binding.listViewDestinasi.adapter = DestinasiAdapter(requireContext(), hasilFilter)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}