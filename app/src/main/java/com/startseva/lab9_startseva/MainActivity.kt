package com.startseva.lab9_startseva

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.startseva.lab9_startseva.data.Datasource
import com.startseva.lab9_startseva.ui.theme.Lab9_StartsevaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab9_StartsevaTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val datasource = Datasource()
    var currentIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val currentCity = datasource.cities.getOrNull(currentIndex)
        currentCity?.let { city ->
            Image(
                painter = painterResource(id = city.imageResourceId),
                contentDescription = stringResource(city.titleResourceId),
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = stringResource(city.titleResourceId),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text(
                text = stringResource(city.descriptionResourceId),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if (currentIndex > 0) {
                            currentIndex--
                        }
                    },
                    enabled = currentIndex > 0
                ) {
                    Text("Предыдущий")
                }
                Button(
                    onClick = {
                        if (currentIndex < datasource.cities.size - 1) {
                            currentIndex++
                        }
                    },
                    enabled = currentIndex < datasource.cities.size - 1
                ) {
                    Text("Следующий")
                }
            }
        }
    }
}