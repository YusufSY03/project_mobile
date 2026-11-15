package com.example.yusufsy_3tib

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yusufsy_3tib.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur agar Toolbar mentok ke atas dan tidak terpotong
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.toolbarDetail.setPadding(0, systemBars.top, 0, 0)
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup Toolbar dan fungsi tombol Back secara langsung (String Resource)
        binding.toolbarDetail.title = getString(R.string.title_detail_destinasi)
        binding.toolbarDetail.setNavigationOnClickListener {
            finish()
        }

        // Menangkap data dari Intent (String Resource Fallback)
        val nama = intent.getStringExtra("EXTRA_NAMA") ?: getString(R.string.default_destinasi_wisata)
        val imageResId = intent.getIntExtra("EXTRA_GAMBAR", 0)

        // Memasang nama dan gambar ke komponen UI atas
        binding.tvNamaDetail.text = nama
        if (imageResId != 0) {
            binding.imgDetail.setImageResource(imageResId)
        }

        // Menghitung jumlah ulasan untuk ditampilkan di Badge Tab Ulasan
        val jumlahUlasan = (dataUlasanDestinasi[nama] ?: ulasanDefault).size

        // 1. Inisialisasi adapter Tab (Pertemuan 10)
        val tabsAdapter = DetailTabsAdapter(this)

        // 2. Pasang adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout dan ViewPager2 dengan TabLayoutMediator
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.tab_informasi)
                }
                1 -> {
                    tab.text = getString(R.string.tab_ulasan)
                    // Menambahkan badge angka sesuai jumlah ulasan (Tahap 2.1 Modul)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = jumlahUlasan
                }
            }
        }.attach()
    }
}