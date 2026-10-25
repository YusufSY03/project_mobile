package com.example.yusufsy_3tib

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yusufsy_3tib.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {
    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Arahkan klik kartu Bukittinggi ke DaerahActivity
        binding.cardBukittinggi.setOnClickListener {
            val intent = Intent(requireContext(), DaerahActivity::class.java)
            intent.putExtra("NAMA_DAERAH", "Bukittinggi")
            startActivity(intent)
        }

        // Catatan: Jika kartu Kab. Lima Puluh Kota sudah kamu beri id (misal: cardLimaPuluh)
        // di file fragment_beranda.xml, kamu bisa gunakan kode di bawah ini:
        /*
        binding.cardLimaPuluh.setOnClickListener {
            val intent = Intent(requireContext(), DaerahActivity::class.java)
            intent.putExtra("NAMA_DAERAH", "Kab. Lima Puluh Kota")
            startActivity(intent)
        }
        */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}