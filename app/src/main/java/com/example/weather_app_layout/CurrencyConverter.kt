package com.example.weather_app_layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyConverter() {
    var eurAmount by remember { mutableStateOf("") }
    val currencies = listOf("USD", "GBP", "SEK")
    val exchangeRates = mapOf("USD" to 1.08, "GBP" to 0.86, "SEK" to 11.25)
    var expanded by remember { mutableStateOf(false) }
    var selectedCurrency by remember { mutableStateOf("USD") }
    var convertedAmount by remember { mutableStateOf("") }

    val icon =
        if (expanded) {
            Icons.Filled.KeyboardArrowUp
        } else {
            Icons.Filled.KeyboardArrowDown
        }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AppHeader("Currency Converter", Color.DarkGray)
        OutlinedTextField(
            value = eurAmount,
            onValueChange = { eurAmount = it },
            label = { Text("EUR amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = selectedCurrency,
            onValueChange = {},
            label = { Text("Currency") },
            readOnly = true,
            trailingIcon = {
                Text(text = "v".orEmpty(),
                    modifier = Modifier.clickable { expanded = !expanded })
            }
        )

        Row {
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                currencies.forEach { currency ->
                    DropdownMenuItem(
                        text = { Text(currency) },
                        onClick = {
                            selectedCurrency = currency
                            expanded = false
                        }
                    )
                }
            }
        }

        Button(onClick = {
            val amount = eurAmount.toFloatOrNull()
            if (amount != null) {
                val rate = exchangeRates[selectedCurrency]
                if (rate != null) {
                    convertedAmount = (amount * rate).toString()
                }
            }
        }) { Text("Convert") }

        //display text x EUR = y USD, but only display after the button is clicked
        if (convertedAmount.isNotEmpty()) {
            Text(
                text = "$eurAmount EUR = $convertedAmount $selectedCurrency",
                color = Color.Blue
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyConverterPreview() {
    CurrencyConverter()
}
