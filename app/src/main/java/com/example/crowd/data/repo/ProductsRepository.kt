package com.example.crowd.data.repo

import com.example.crowd.data.ProductsApi
import com.example.crowd.data.RetrofitInstance
import com.example.crowd.data.model.Product
import com.example.crowd.data.model.ProductsResponse
import retrofit2.Response

interface ProductsRepository {
    suspend fun getProducts(): Result<List<Product>>
}

class ProductsRepositoryImp(private val api: ProductsApi = RetrofitInstance.api) : ProductsRepository {
    override suspend fun getProducts(): Result<List<Product>> {
        return try {
            val response: Response<ProductsResponse> = api.getProducts()
            if (response.isSuccessful) {
                val products = response.body()?.products ?: emptyList()
                Result.success(products)
            } else {
                Result.failure(Throwable())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(Throwable())
        }
    }
}
