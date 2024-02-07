package com.example.weather_app_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale


@Composable
fun WeatherListItem(date: String, temperature: Short, weather: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.Start) {
            Text(
                text = date,
                fontSize = 16.sp,
            )
        }
        Column(modifier = Modifier
            .weight(1f),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$temperature°C",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }
        Column(modifier = Modifier
            .weight(1f),horizontalAlignment = Alignment.CenterHorizontally) {
            //add image here depending on the weather
            val imageResourceId = when (weather) {
                "sunny" -> R.drawable.sunny
                "rainy" -> R.drawable.rainy
                "cloudy" -> R.drawable.cloudy
                "foggy" -> R.drawable.foggy
                "snowy" -> R.drawable.snowy
                else -> R.drawable.error
            }

            Image(
                //add image here depending on the weather text, for example sunny.png
                painter = painterResource(id = imageResourceId),
                contentDescription = "weather icon",
                modifier = Modifier.size(24.dp)
            )

        }
        Column(modifier = Modifier
            .weight(1f),horizontalAlignment = Alignment.End) {
            Text(
                text = weather.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        }
    }
    Divider (
        color = Color.LightGray,
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun WeatherListItemPreview() {
    WeatherListItem(date = "Mon", temperature = 5, weather = "foggy")
}
