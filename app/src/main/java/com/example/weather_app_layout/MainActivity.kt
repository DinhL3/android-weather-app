package com.example.weather_app_layout

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather_app_layout.ui.theme.WeatherapplayoutTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WeatherapplayoutTheme { App() } }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "currentWeatherScreen") {
        composable("currentWeatherScreen") { CurrentWeatherScreen(navController) }
        composable("forecastScreen") { ForecastScreen(navController) }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastScreen(navController: NavHostController) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    val weatherForeCastList = listOf(
            WeatherData("Monday", 5, "sunny"),
            WeatherData("Tuesday", 6, "rainy"),
            WeatherData("Wednesday", 7, "cloudy"),
            WeatherData("Thursday", 0, "foggy"),
            WeatherData("Friday", -9, "snowy"),
    )
    Column(
            modifier = Modifier.fillMaxSize().padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(cityName = "Tampere")
        Text(
                text = "Weather the next 5 days",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
        )
        Divider (
            color = Color.LightGray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //start displaying weather forecast list here, using WeatherListItem
            weatherForeCastList.forEach {
                WeatherListItem(it.date, it.temperature, it.weather)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
                onClick = { navController.navigate("currentWeatherScreen") },
                modifier = Modifier.padding(bottom = 16.dp)
        ) { Text(text = stringResource(R.string.return_button)) }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CurrentWeatherScreen(navController: NavHostController) {
    Column(
            modifier = Modifier.fillMaxSize().padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(cityName = "Tampere")
        Spacer(modifier = Modifier.height(8.dp))
        Row(
                modifier = Modifier.padding(horizontal = 0.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                        painter = painterResource(id = R.drawable.cloudy),
                        contentDescription = "Weather Icon",
                        modifier = Modifier.size(100.dp)
                )
            }
            Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                        text = "-1°C",
                        fontWeight = FontWeight.Bold,
                        fontSize = 48.sp,
                        color = Color.Blue
                )
            }
        }
        Row(
                modifier = Modifier.padding(horizontal = 0.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) { Text(text = stringResource(R.string.overcast), fontSize = 16.sp) }
            Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) { Text(text = stringResource(R.string.feels_like_6_c), fontSize = 16.sp) }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
                onClick = { navController.navigate("forecastScreen") },
                modifier = Modifier.padding(bottom = 16.dp)
        ) { Text(text = stringResource(R.string.forecast)) }
    }
}

// @RequiresApi(Build.VERSION_CODES.O)
// @Preview(showBackground = true)
// @Composable
// fun WeatherAppPreview() {
//    WeatherapplayoutTheme {
//        CurrentWeatherScreen()
//    }
// }
