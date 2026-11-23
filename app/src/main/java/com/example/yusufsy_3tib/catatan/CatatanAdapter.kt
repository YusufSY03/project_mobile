package com.example.yusufsy_3tib.catatan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yusufsy_3tib.R
import com.example.yusufsy_3tib.data.entity.CatatanEntity
import com.example.yusufsy_3tib.databinding.ItemCatatanBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CatatanAdapter(
    private val catatanList: List<CatatanEntity>,
    private val onDelete: (CatatanEntity) -> Unit
) : RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder>() {

    class CatatanViewHolder(val binding: ItemCatatanBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatatanViewHolder {
        val binding = ItemCatatanBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CatatanViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CatatanViewHolder,
        position: Int
    ) {
        val catatan = catatanList[position]
        holder.binding.tvJudul.text = catatan.judul
        holder.binding.tvDestinasi.text = catatan.destinasi
        holder.binding.tvIsiCatatan.text = catatan.isiCatatan

        holder.binding.btnDelete.setOnClickListener {
            val context = holder.itemView.context
            MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(R.string.dialog_hapus_judul))
                .setMessage(context.getString(R.string.dialog_hapus_pesan))
                .setPositiveButton(context.getString(R.string.btn_ya)) { _, _ ->
                    onDelete(catatan)
                }
                .setNegativeButton(context.getString(R.string.btn_batal), null)
                .show()
        }
    }

    override fun getItemCount(): Int = catatanList.size
}