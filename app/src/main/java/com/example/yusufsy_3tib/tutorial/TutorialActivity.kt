package com.example.yusufsy_3tib.tutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yusufsy_3tib.LoginActivity
import com.example.yusufsy_3tib.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.mainTutorial) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Daftar fragment tutorial yang akan ditampilkan
        val fragments = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )

        // Pasang adapter ke ViewPager2
        val adapter = TutorialFragmentAdapter(this, fragments)
        binding.tutorialViewPager.adapter = adapter

        // Hubungkan DotsIndicator ke ViewPager2 (wajib dipanggil setelah adapter terpasang)
        binding.dotIndicator.attachTo(binding.tutorialViewPager)
    }

    // Fungsi publik untuk menyelesaikan tutorial
    fun selesaiTutorial() {
        // Simpan status sudah melihat tutorial di SharedPreferences "app_pref" (terpisah dari user_pref)
        val appPref = getSharedPreferences("app_pref", Context.MODE_PRIVATE)
        appPref.edit().putBoolean("tutorial_seen", true).apply()

        val dariAwal = intent.getBooleanExtra("DARI_AWAL", true)
        if (dariAwal) {
            // Jika pertama kali install/buka, lanjutkan ke halaman Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        // Jika dibuka ulang dari menu Pusat Bantuan (Profil), cukup tutup halaman ini
        finish()
    }
}