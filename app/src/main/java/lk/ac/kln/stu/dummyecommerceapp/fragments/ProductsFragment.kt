package lk.ac.kln.stu.dummyecommerceapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import lk.ac.kln.stu.dummyecommerceapp.adapters.ProductAdapter
import lk.ac.kln.stu.dummyecommerceapp.database.product.Product
import lk.ac.kln.stu.dummyecommerceapp.databinding.FragmentProductsBinding
import lk.ac.kln.stu.dummyecommerceapp.network.StoreApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsFragment : Fragment() {
    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!
    private val products: MutableList<Product> = mutableListOf()
    private var adapter: ProductAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerViewProducts = binding.recyclerviewProducts

        adapter = ProductAdapter(products)
        recyclerViewProducts.adapter = adapter

        fetchProducts()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun fetchProducts() {
        val call = StoreApi.retrofitService.getProducts()
        call.enqueue(object : Callback<List<Product>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.body() != null) {
                    products.addAll(response.body()!!)
                    adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("ProductsFragment", t.message.toString())
            }
        })
    }
}