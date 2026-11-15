package com.example.yusufsy_3tib

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yusufsy_3tib.databinding.ItemUlasanBinding

class UlasanAdapter(
    private val ulasanList: List<UlasanModel>,
    private val onItemClick: (UlasanModel) -> Unit
) : RecyclerView.Adapter<UlasanAdapter.UlasanViewHolder>() {

    inner class UlasanViewHolder(val binding: ItemUlasanBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UlasanViewHolder {
        val binding = ItemUlasanBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UlasanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UlasanViewHolder, position: Int) {
        val item = ulasanList[position]
        with(holder.binding) {
            tvNamaPengunjung.text = item.namaPengunjung
            tvRatingUlasan.text = item.rating
            tvKomentarUlasan.text = item.komentar

            root.setOnClickListener { onItemClick(item) }
        }
    }

    override fun getItemCount(): Int = ulasanList.size
}