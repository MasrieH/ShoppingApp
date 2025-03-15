package com.masrietech.shoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masrietech.shoppingapp.ui.theme.ShoppingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel:CounterVM = viewModel()
            ShoppingAppTheme {
   //             Shopping()
            //    val counterVM:CounterVM=CounterVM()
                CountUpDown(viewModel)
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Masrie",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}




//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true, device = Devices.PIXEL_6)
@Composable
fun GreetingPreview() {
    ShoppingAppTheme {
     //   Shopping()
        CountUpDown(CounterVM())
    }
}