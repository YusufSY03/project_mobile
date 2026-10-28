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

    // Data Destinasi Wishlist dengan deskripsi informatif dan gambar lokal
    private val destinasiList = listOf(
        DestinasiModel(
            "Jam Gadang",
            "Ikon sejarah dan landmark utama Kota Bukittinggi yang dibangun pada masa kolonial dengan atap khas rumah gadang Minangkabau.",
            R.drawable.jam_gadang
        ),
        DestinasiModel(
            "Kawasan Wisata Mandeh",
            "Gugusan pulau eksotis di pesisir selatan dengan perairan jernih nan tenang, sering dijuluki surga bahari Raja Ampat-nya Sumatera Barat.",
            R.drawable.mandeh1
        ),
        DestinasiModel(
            "Lembah Harau",
            "Ngarai subur yang diapit oleh tebing-tebing batu granit terjal setinggi ratusan meter dengan air terjun alami dan keindahan alam yang memukau di Kabupaten Lima Puluh Kota.",
            R.drawable.lembah_harau
        ),
        DestinasiModel(
            "Istano Basa Pagaruyuang",
            "Kemegahan istana replika kebanggaan suku Minangkabau dengan arsitektur rumah gadang khas di Batusangkar.",
            R.drawable.pagaruyuang
        )
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

        // Penyeragaman: Toolbar diperlakukan mandiri tanpa setSupportActionBar
        val adapter = DestinasiAdapter(requireContext(), destinasiList)
        binding.listViewDestinasi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}