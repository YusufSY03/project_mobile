package com.example.yusufsy_3tib

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yusufsy_3tib.databinding.ActivityDaerahBinding

class DaerahActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaerahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDaerahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.toolbarDaerah.setPadding(0, systemBars.top, 0, 0)
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil nama daerah dengan fallback resmi dari strings.xml
        val namaDaerah = intent.getStringExtra("NAMA_DAERAH") ?: getString(R.string.default_daftar_destinasi)

        // Set judul Toolbar dan tombol navigasi kembali
        binding.toolbarDaerah.title = namaDaerah
        binding.toolbarDaerah.setNavigationOnClickListener {
            finish()
        }

        // Menentukan list data berdasarkan nama daerah dari DestinasiData.kt
        val destinasiDaerah = when (namaDaerah) {
            "Kab. Lima Puluh Kota" -> daftarLimaPuluhKota
            "Bukittinggi" -> daftarBukittinggi
            else -> daftarDefault
        }

        val adapter = DestinasiAdapter(this, destinasiDaerah)
        binding.listViewDaerah.adapter = adapter
    }
}