package com.example.yusufsy_3tib

import android.content.Context
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

        // Menampilkan sapaan user dari SharedPreferences (Wajib Modul P7 Latihan 5.1)
        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Pengguna") ?: "Pengguna"
        binding.tvGreeting.text = getString(R.string.greeting_user, username)

        // Arahkan klik kartu Bukittinggi ke DaerahActivity
        binding.cardBukittinggi.setOnClickListener {
            val intent = Intent(requireContext(), DaerahActivity::class.java)
            intent.putExtra("NAMA_DAERAH", "Bukittinggi")
            startActivity(intent)
        }

        // Arahkan klik kartu Kab. Lima Puluh Kota ke DaerahActivity
        binding.cardLimaPuluh.setOnClickListener {
            val intent = Intent(requireContext(), DaerahActivity::class.java)
            intent.putExtra("NAMA_DAERAH", "Kab. Lima Puluh Kota")
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}