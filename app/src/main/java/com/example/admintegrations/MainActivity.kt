package com.example.admintegrations

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.example.admintegrations.ui.theme.AdmintegrationsTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.core.component.KoinComponent

/**
 * Class to test library functionalities for all integrations
 * */
class MainActivity : ComponentActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdmintegrationsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {
    val label by viewModel.label.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Button(onClick = {
                val serial = viewModel.getSerialNumber()
                viewModel.updateLabel(serial ?: "")
            }) {
                Text("SERIAL NUMBER")
            }

            Button(onClick = {
                val mac = viewModel.getMacAddress()
                viewModel.updateLabel(mac ?: "")
            }) {
                Text("MAC ADDRESS")
            }

            Button(onClick = {
                val listApps = viewModel.getRunningAppList()
                val list = StringBuilder()
                for (app in listApps) {
                    list.append(app)
                        .append("\n")
                }
                viewModel.updateLabel(list.toString())
            }) {
                Text("APPS LIST")
            }

            Button(onClick = {
                val listServices = viewModel.getRunningServiceList()
                val list = StringBuilder()
                for (app in listServices) {
                    list.append(app)
                        .append("\n")
                }
                viewModel.updateLabel(list.toString())
            }) {
                Text("SERVICES LIST")
            }

            Button(onClick = {
                viewModel.injectKeyEvent(3)
                Log.i("KEY EVENT", "INJECTED keycode= "+3)
            }) {
                Text("INJECT KEY EVENT")
            }
        }
        Column(
            modifier = Modifier.weight(3f)
        ) {
            Text(
                label,
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }

}

