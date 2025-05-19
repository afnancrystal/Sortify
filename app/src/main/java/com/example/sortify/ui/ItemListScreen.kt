////full lists in one page
////
////package com.example.sortify.ui
////
////import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.lazy.LazyColumn
////import androidx.compose.foundation.lazy.items
////import androidx.compose.material3.*
////import androidx.compose.runtime.Composable
////import androidx.compose.runtime.collectAsState
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.unit.dp
////import com.example.sortify.model.Item
////import com.example.sortify.viewmodel.ItemViewModel
////
////@Composable
////fun ItemListScreen(viewModel: ItemViewModel) {
////    val groupedItems = viewModel.items.collectAsState().value
////
////    MaterialTheme {
////        LazyColumn(
////            contentPadding = PaddingValues(16.dp),
////            verticalArrangement = Arrangement.spacedBy(12.dp)
////        ) {
////            groupedItems.forEach { (listId, items) ->
////                item {
////                    Text(
////                        text = "List ID: $listId",
////                        style = MaterialTheme.typography.titleLarge
////                    )
////                }
////                items(items) { item ->
////                    ItemCard(item)
////                }
////            }
////        }
////    }
////}
////
////@Composable
////fun ItemCard(item: Item) {
////    Card(
////        modifier = Modifier.fillMaxWidth(),
////        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
////    ) {
////        Column(modifier = Modifier.padding(16.dp)) {
////            Text(text = "ID: ${item.id}")
////            Text(text = "Name: ${item.name}")
////        }
////    }
////}

//scroll state not maintained individually
//package com.example.sortify.ui
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.sortify.viewmodel.ItemViewModel
//import com.example.sortify.model.Item
//
//@Composable
//fun ItemListScreen(viewModel: ItemViewModel) {
//    val groupedItems = viewModel.items.collectAsState().value
//    val tabTitles = groupedItems.keys.toList()
//    var selectedTabIndex by remember { mutableStateOf(0) }
//
//    Column {
//        TabRow(selectedTabIndex = selectedTabIndex) {
//            tabTitles.forEachIndexed { index, listId ->
//                Tab(
//                    selected = selectedTabIndex == index,
//                    onClick = { selectedTabIndex = index },
//                    text = { Text("List $listId") }
//                )
//            }
//        }
//
//        val currentListId = tabTitles.getOrNull(selectedTabIndex)
//        currentListId?.let { listId ->
//            LazyColumn(
//                contentPadding = PaddingValues(16.dp),
//                verticalArrangement = Arrangement.spacedBy(12.dp),
//                modifier = Modifier.fillMaxSize()
//            ) {
//                items(groupedItems[listId] ?: emptyList()) { item ->
//                    ItemCard(item)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ItemCard(item: Item) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = "ID: ${item.id}")
//            Text(text = "Name: ${item.name}")
//        }
//    }
//}

package com.example.sortify.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sortify.viewmodel.ItemViewModel
import com.example.sortify.model.Item

@Composable
fun ItemListScreen(viewModel: ItemViewModel) {
    val groupedItems = viewModel.items.collectAsState().value
    val tabTitles = groupedItems.keys.toList().sorted()
    var selectedTabIndex by remember { mutableStateOf(0) }

    // Remember individual scroll state per tab
    val scrollStates = remember { mutableStateMapOf<Int, LazyListState>() }

    Column {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, listId ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text("List $listId") }
                )
            }
        }

        val currentListId = tabTitles.getOrNull(selectedTabIndex)
        currentListId?.let { listId ->
            val listState = scrollStates.getOrPut(listId) { rememberLazyListState() }
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(groupedItems[listId] ?: emptyList()) { item ->
                    ItemCard(item)
                }
            }
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${item.id}")
            Text(text = "Name: ${item.name}")
        }
    }
}