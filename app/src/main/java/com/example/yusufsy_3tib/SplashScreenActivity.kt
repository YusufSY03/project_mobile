package com.example.yusufsy_3tib

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.yusufsy_3tib.tutorial.TutorialActivity
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

        // --- Logika Splash Screen 3 Kondisi (Modul Tahap 3 + Onboarding) ---
        lifecycleScope.launch {
            delay(2000) // Tahan layar splash 2 detik

            // 1. Cek status login dari SharedPreferences user_pref
            val userPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val isLogin = userPref.getBoolean("isLogin", false)

            // 2. Cek status tutorial dari SharedPreferences app_pref
            val appPref = getSharedPreferences("app_pref", Context.MODE_PRIVATE)
            val tutorialSeen = appPref.getBoolean("tutorial_seen", false)

            // 3. Tentukan halaman tujuan berdasarkan kondisi
            val intent = when {
                isLogin -> {
                    // Jika sudah login, langsung ke halaman utama BaseActivity
                    Intent(this@SplashScreenActivity, BaseActivity::class.java)
                }
                !tutorialSeen -> {
                    // Jika belum login dan belum pernah lihat tutorial, buka TutorialActivity dari awal
                    Intent(this@SplashScreenActivity, TutorialActivity::class.java).apply {
                        putExtra("DARI_AWAL", true)
                    }
                }
                else -> {
                    // Jika sudah pernah melihat tutorial tapi belum login, langsung ke LoginActivity
                    Intent(this@SplashScreenActivity, LoginActivity::class.java)
                }
            }

            startActivity(intent)
            finish()
        }
    }
}