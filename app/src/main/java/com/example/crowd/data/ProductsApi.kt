package com.example.crowd.data

import com.example.crowd.data.model.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {
    @GET("/v1/sample-data/products?offset=5&limit=20")
   suspend fun getProducts(): Response<ProductsResponse>
}