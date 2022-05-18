package lk.ac.kln.stu.dummyecommerceapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import lk.ac.kln.stu.dummyecommerceapp.database.AppDatabase
import lk.ac.kln.stu.dummyecommerceapp.database.product.Product
import lk.ac.kln.stu.dummyecommerceapp.databinding.ActivityMainBinding
import lk.ac.kln.stu.dummyecommerceapp.network.StoreApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var products: MutableList<Product> = mutableListOf()

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonViewData.setOnClickListener {
            navigateToStoreActivity()
        }
    }

    private fun navigateToStoreActivity() {
        val intent = Intent(this, StoreActivity::class.java)
        startActivity(intent)
    }
}