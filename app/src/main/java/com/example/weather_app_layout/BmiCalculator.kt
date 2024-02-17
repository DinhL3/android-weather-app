package com.example.weather_app_layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun BmiCalculator() {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var bmi by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally)  {
        AppHeader("BMI Calculator", Color.DarkGray)
        OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Weight (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Height (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
                onClick = {
                    val weightValue = weight.toFloatOrNull()
                    val heightValue = height.toFloatOrNull()
                    if (weightValue != null && heightValue != null && heightValue != 0f) {
                        val heightInMeters = heightValue / 100
                        bmi = (weightValue / (heightInMeters * heightInMeters)).toString()
                    } else {
                        bmi = "Invalid input"
                    }
                }
        ) { Text("Calculate") }
        Text(
            text = "BMI: $bmi",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BmiCalculatorPreview() {
    BmiCalculator()
}
