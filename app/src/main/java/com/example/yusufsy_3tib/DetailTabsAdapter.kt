package com.example.yusufsy_3tib

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailTabsAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    // Jumlah total tab yang ada (Informasi dan Ulasan)
    override fun getItemCount(): Int = 2

    // Menentukan Fragment yang ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> InformasiFragment()
            1 -> UlasanFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}