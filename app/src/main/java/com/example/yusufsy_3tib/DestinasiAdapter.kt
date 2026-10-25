package com.example.yusufsy_3tib

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.yusufsy_3tib.databinding.ItemDestinasiBinding

class DestinasiAdapter(
    context: Context,
    private val destinasiList: List<DestinasiModel>
) : ArrayAdapter<DestinasiModel>(context, 0, destinasiList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemDestinasiBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val data = destinasiList[position]

        // Memuat gambar langsung dari file lokal drawable
        binding.imgDestinasi.setImageResource(data.imageResId)

        binding.tvNamaDestinasi.text = data.nama
        binding.tvDeskripsiDestinasi.text = data.deskripsi

        // Aksi klik pada item list
        view.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("EXTRA_NAMA", data.nama)
            intent.putExtra("EXTRA_DESKRIPSI", data.deskripsi)
            intent.putExtra("EXTRA_GAMBAR", data.imageResId) // Mengirim ID resource gambar (Int)
            context.startActivity(intent)
        }

        return view
    }
}