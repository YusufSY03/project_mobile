package com.example.yusufsy_3tib

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yusufsy_3tib.databinding.FragmentProfilBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data untuk Simple ListView (Menu Profil)
        val listMenuProfil = listOf(
            mapOf("title" to "Pusat Bantuan", "desc" to "Panduan dan solusi masalah"),
            mapOf("title" to "Tentang Aplikasi", "desc" to "Versi aplikasi Jelajah Ranah V1.0"),
            mapOf("title" to "Syarat & Ketentuan", "desc" to "Kebijakan privasi pengguna")
        )

        // Memasang SimpleAdapter sesuai modul
        val adapter = SimpleAdapter(
            requireContext(),
            listMenuProfil,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listViewProfil.adapter = adapter

        // Aksi saat item Simple ListView diklik
        binding.listViewProfil.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = listMenuProfil[position]
            Toast.makeText(
                requireContext(),
                "Membuka ${selectedItem["title"]}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Logika Tombol Log Out
        binding.btnLogOut.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)

            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.dialog_logout_title)
                .setMessage(R.string.dialog_logout_msg)
                .setPositiveButton(R.string.dialog_ya) { dialog, _ ->
                    sharedPref.edit().clear().apply()
                    dialog.dismiss()

                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton(R.string.dialog_tidak) { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}