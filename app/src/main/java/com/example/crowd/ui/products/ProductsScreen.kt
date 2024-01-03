package com.example.crowd.ui.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.crowd.data.model.Product
import com.example.crowd.data.repo.ProductsRepositoryImp

@Composable
fun ProductsScreen() {

    val products = remember {
        mutableStateOf(listOf<Product>())
    }
    LaunchedEffect(key1 = true, block = {
        val result: Result<List<Product>> = ProductsRepositoryImp().getProducts()

        result.onSuccess {
            products.value = it
        }.onFailure {

        }
    })

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))

        products.value.forEach {
            ProductItem(it)
            Spacer(modifier = Modifier.height(16.dp))
        }

    }

}