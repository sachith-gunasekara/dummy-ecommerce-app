package lk.ac.kln.stu.dummyecommerceapp.database.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM product ORDER BY id")
    fun getAll(): List<Product>

    @Insert
    fun insertAll(vararg products: Product)
}