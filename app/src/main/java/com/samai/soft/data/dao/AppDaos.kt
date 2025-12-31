package com.samai.soft.data.dao
import androidx.room.*
import com.samai.soft.data.entities.*

@Dao
interface AccountDao {
    @Query("SELECT * FROM accounts")
    fun getAll(): List<Account>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: Account)

    @Query("UPDATE accounts SET balance = balance + :amount WHERE id = :accId")
    fun updateBalance(accId: Int, amount: Double)
}

@Dao
interface InventoryDao {
    @Query("SELECT * FROM products WHERE barcode = :code")
    fun getByBarcode(code: String): Product?
    
    @Update
    fun updateProduct(product: Product)
}