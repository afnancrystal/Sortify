package com.example.sortify.data

import com.example.sortify.model.Item

class ItemRepository {
    private val apiService = ApiService.create()

    suspend fun fetchItems(): List<Item> {
        return apiService.getItems()
            .filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy({ it.listId }, { it.name }))
    }
}
