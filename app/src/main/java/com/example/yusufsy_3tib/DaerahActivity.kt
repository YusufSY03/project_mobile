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

        val namaDaerah = intent.getStringExtra("NAMA_DAERAH") ?: "Daftar Destinasi"

        // Set judul dan fungsi tombol kembali secara langsung
        binding.toolbarDaerah.title = namaDaerah
        binding.toolbarDaerah.setNavigationOnClickListener {
            finish()
        }

        // Menampilkan daftar destinasi dinamis sesuai daerah yang dipilih
        val destinasiDaerah = when (namaDaerah) {
            "Kab. Lima Puluh Kota" -> listOf(
                DestinasiModel(
                    "Lembah Harau",
                    "Ngarai subur yang diapit oleh tebing-tebing batu granit terjal setinggi ratusan meter dengan air terjun alami dan keindahan alam yang memukau di Kabupaten Lima Puluh Kota.",
                    R.drawable.lembah_harau
                ),
                DestinasiModel(
                    "Kelok 9",
                    "Karya infrastruktur jembatan layang megah yang meliuk-liuk di antara perbukitan hijau tropis, menghubungkan Sumatera Barat dan Riau.",
                    R.drawable.lembah_harau
                )
            )
            "Bukittinggi" -> listOf(
                DestinasiModel(
                    "Jam Gadang",
                    "Ikon sejarah dan landmark utama Kota Bukittinggi yang dibangun pada masa kolonial dengan atap khas rumah gadang Minangkabau.",
                    R.drawable.jam_gadang
                ),
                DestinasiModel(
                    "Ngarai Sianok",
                    "Lembah hijau nan curam dengan tebing patahan bumi yang menakjubkan, membentang di perbatasan Kota Bukittinggi dan Kabupaten Agam.",
                    R.drawable.ngarai_sianok
                ),
                DestinasiModel(
                    "Lobang Jepang",
                    "Kompleks terowongan bawah tanah bersejarah peninggalan masa pendudukan Jepang yang membentang di bawah kawasan Taman Panorama.",
                    R.drawable.lubang_jepang
                )
            )
            else -> listOf(
                DestinasiModel(
                    "Kawasan Wisata Mandeh",
                    "Gugusan pulau eksotis di pesisir selatan dengan perairan jernih nan tenang, sering dijuluki surga bahari Raja Ampat-nya Sumatera Barat.",
                    R.drawable.mandeh1
                ),
                DestinasiModel(
                    "Istano Basa Pagaruyuang",
                    "Kemegahan istana replika kebanggaan suku Minangkabau dengan arsitektur rumah gadang khas di Batusangkar.",
                    R.drawable.pagaruyuang
                )
            )
        }

        val adapter = DestinasiAdapter(this, destinasiDaerah)
        binding.listViewDaerah.adapter = adapter
    }
}