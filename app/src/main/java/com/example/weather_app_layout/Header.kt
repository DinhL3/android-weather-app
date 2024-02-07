package com.example.weather_app_layout

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Header(cityName: String) {
    Row(
            modifier = Modifier.fillMaxWidth().background(Color.DarkGray).padding(8.dp),
            horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                    text = cityName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White
            )
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, HH:mm", Locale.getDefault())
            val formatted = current.format(formatter)
            Text(text = formatted, fontSize = 16.sp, color = Color.White)
        }
    }
}
