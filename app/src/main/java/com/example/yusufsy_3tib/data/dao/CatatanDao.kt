package com.example.yusufsy_3tib.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.yusufsy_3tib.data.entity.CatatanEntity

@Dao
interface CatatanDao {

    @Query("SELECT * FROM catatan_perjalanan ORDER BY createdAt DESC")
    suspend fun getAll(): List<CatatanEntity>

    @Insert
    suspend fun insert(catatan: CatatanEntity)

    @Delete
    suspend fun delete(catatan: CatatanEntity)
}