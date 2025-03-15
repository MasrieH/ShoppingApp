package com.masrietech.shoppingapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

@Composable
fun CountUpDown(viewModel: CounterVM){

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Text("Count: ${viewModel.count.value}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {viewModel.increment()}) { Text("Increment") }
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = {viewModel.decrement()}) { Text("Decrement") }
        }

    }
}