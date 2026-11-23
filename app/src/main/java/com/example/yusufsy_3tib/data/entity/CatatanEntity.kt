package com.example.yusufsy_3tib.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catatan_perjalanan")
data class CatatanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val judul: String,
    val destinasi: String,
    val isiCatatan: String,
    val createdAt: Long = System.currentTimeMillis()
)