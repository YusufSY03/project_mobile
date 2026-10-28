package com.example.yusufsy_3tib

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yusufsy_3tib.databinding.ActivityDetailBinding

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
            finish() // Menutup halaman ini dan kembali ke halaman sebelumnya
        }

        // Menangkap data dari Intent (String Resource Fallback)
        val nama = intent.getStringExtra("EXTRA_NAMA") ?: getString(R.string.default_destinasi_wisata)
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI") ?: getString(R.string.default_deskripsi_kosong)
        val imageResId = intent.getIntExtra("EXTRA_GAMBAR", 0)

        // Memasang data ke komponen UI
        binding.tvNamaDetail.text = nama
        binding.tvDeskripsiDetail.text = deskripsi

        if (imageResId != 0) {
            binding.imgDetail.setImageResource(imageResId)
        }
    }
}