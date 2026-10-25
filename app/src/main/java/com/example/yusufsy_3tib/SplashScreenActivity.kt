package com.example.yusufsy_3tib

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- Logika Splash Screen (Modul Tahap 3) ---
        lifecycleScope.launch {
            delay(2000) // Tahan layar 2 detik

            // Cek status login dari SharedPreferences
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            // Tentukan halaman tujuan
            val target = if (isLogin) BaseActivity::class.java else LoginActivity::class.java

            // Pindah halaman lalu tutup Splash Screen
            startActivity(Intent(this@SplashScreenActivity, target))
            finish()
        }
    }
}