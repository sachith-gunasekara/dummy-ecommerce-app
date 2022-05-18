package lk.ac.kln.stu.dummyecommerceapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import lk.ac.kln.stu.dummyecommerceapp.database.product.Product
import lk.ac.kln.stu.dummyecommerceapp.database.product.ProductDao

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "ecommerce-db"
                    )
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}