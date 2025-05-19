package com.example.sortify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sortify.data.ItemRepository
import com.example.sortify.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val repository = ItemRepository()
    private val _items = MutableStateFlow<Map<Int, List<Item>>>(emptyMap())
    val items: StateFlow<Map<Int, List<Item>>> = _items

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val itemList = repository.fetchItems()
            _items.value = itemList.groupBy { it.listId }
        }
    }
}
