package com.example.yusufsy_3tib.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yusufsy_3tib.data.dao.CatatanDao
import com.example.yusufsy_3tib.data.entity.CatatanEntity

@Database(
    entities = [CatatanEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun catatanDao(): CatatanDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "jelajah_ranah_db"
                ).build().also { INSTANCE = it }
            }
    }
}