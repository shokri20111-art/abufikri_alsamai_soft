package com.samai.soft.data

import android.content.Context
import androidx.room.*
import com.samai.soft.data.dao.*
import com.samai.soft.data.entities.*

@Database(entities = [Account::class, Product::class, Voucher::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun inventoryDao(): InventoryDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "samai_soft_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}