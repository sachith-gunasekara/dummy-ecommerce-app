package lk.ac.kln.stu.dummyecommerceapp.adapters

import android.content.Context
import android.provider.Settings.System.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lk.ac.kln.stu.dummyecommerceapp.R
import lk.ac.kln.stu.dummyecommerceapp.database.product.Product

class ProductAdapter(
    private val products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageviewProductImage: ImageView = view.findViewById(R.id.imageview_product_image)
        val textviewProductTitle: TextView = view.findViewById(R.id.textview_product_title)
        val textviewProductDescription: TextView =
            view.findViewById(R.id.textview_product_description)
        val textViewProductPrice: TextView = view.findViewById(R.id.textview_product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_product, parent, false)

        return ProductViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.imageviewProductImage.load(product.image)
        holder.textviewProductTitle.text = product.title
        holder.textviewProductDescription.text = product.description
        holder.textViewProductPrice.text = product.price.toString()
    }

    override fun getItemCount() = products.size
}