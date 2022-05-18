package lk.ac.kln.stu.dummyecommerceapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import lk.ac.kln.stu.dummyecommerceapp.database.product.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://fakestoreapi.com"

private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface StoreApiService {
    @GET("products")
    fun getProducts(): Call<List<Product>>
}

object StoreApi {
    val retrofitService: StoreApiService by lazy {
        retrofit.create(StoreApiService::class.java)
    }
}