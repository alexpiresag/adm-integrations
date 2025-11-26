package com.example.admintegrations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.admintegrations.ui.theme.AdmintegrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdmintegrationsTheme {
               // VerticalButtonsSample()
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp) // spacing between columns
    ) {

        Column(
            modifier = Modifier.weight(1f)   // each column takes equal width
        ) {
            Button(onClick = {  }) {
                Text("SERIAL NUMBER")
            }

            Button(onClick = {  }) {
                Text("MAC ADDRESS")
            }
        }
        Column(
            modifier = Modifier.weight(2f)
        ) {
            Text("Right item 1")
        }
    }

}

//@Composable
//fun VerticalButtonsSample() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp),
//        horizontalAlignment = Alignment.Start
//    ) {
//        Button(onClick = {  }) {
//            Text("SERIAL NUMBER")
//        }
//
//        Button(onClick = {  }) {
//            Text("MAC ADDRESS")
//        }
//    }
//}