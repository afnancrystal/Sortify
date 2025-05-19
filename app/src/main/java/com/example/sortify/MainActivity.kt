package com.example.sortify
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sortify.ui.ItemListScreen
import com.example.sortify.viewmodel.ItemViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ItemViewModel()
        setContent {
            ItemListScreen(viewModel)
        }
    }
}
