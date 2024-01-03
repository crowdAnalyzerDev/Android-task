package com.example.crowd.data.model

data class ProductsResponse(
    val products : List<Product>?
)
data class Product(
    val id: Int?,
    val price: Double?,
    val photo_url: String?,
    val description: String?,
    val name: String?,
    val created_at: String?,
)