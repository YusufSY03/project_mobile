package com.example.yusufsy_3tib.catatan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.yusufsy_3tib.R
import com.example.yusufsy_3tib.data.AppDatabase
import com.example.yusufsy_3tib.data.entity.CatatanEntity
import com.example.yusufsy_3tib.databinding.ActivityCatatanFormBinding
import kotlinx.coroutines.launch

class CatatanFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatatanFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCatatanFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.toolbar.setPadding(0, systemBars.top, 0, 0)
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        db = AppDatabase.getInstance(this)

        binding.btnSimpanCatatan.setOnClickListener {
            val judul = binding.etJudul.text.toString().trim()
            val destinasi = binding.etDestinasi.text.toString().trim()
            val isiCatatan = binding.etIsiCatatan.text.toString().trim()

            if (judul.isBlank() || destinasi.isBlank() || isiCatatan.isBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.toast_isi_semua_kolom),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            binding.btnSimpanCatatan.isEnabled = false
            lifecycleScope.launch {
                try {
                    db.catatanDao().insert(
                        CatatanEntity(
                            judul = judul,
                            destinasi = destinasi,
                            isiCatatan = isiCatatan
                        )
                    )
                    finish()
                } catch (e: Exception) {
                    binding.btnSimpanCatatan.isEnabled = true
                    Toast.makeText(
                        this@CatatanFormActivity,
                        getString(R.string.toast_gagal_simpan),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}