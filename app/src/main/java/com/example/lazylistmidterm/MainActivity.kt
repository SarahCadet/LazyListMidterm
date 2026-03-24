package com.example.lazylistmidterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazylistmidterm.ui.theme.LazyListMidtermTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyListMidtermTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    val students = listOf(
        "Alice","Bob","Charlie","Dana","Eric",
        "Fatima","Grace","Hiro","Isabel","Jack",
        "Karen","Luis","Maya","Nate","Olivia",
        "Priya","Quinn","Ravi","Sara","Tom"
    )
    Card(modifier = modifier.fillMaxSize()){
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround){
            Text("Students")
            LazyColumn(modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.Start){
                items(students.size){
                    i ->
                    Card(modifier = Modifier.padding(16.dp).size(90.dp)){
                            Text(text = students[i])
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyListMidtermTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ListScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}