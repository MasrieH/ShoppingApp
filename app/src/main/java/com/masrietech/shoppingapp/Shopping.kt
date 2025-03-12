package com.masrietech.shoppingapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextField

@Composable
fun Shopping(){
    var sItems = remember {  mutableStateOf(listOf<ShoppingItem>())}
    val showDialog= remember { mutableStateOf(false) }
    val itemName= remember { mutableStateOf("A") }
    val itemQty= remember { mutableStateOf("1") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {showDialog.value=true}) {
            Text("Add Item")
        }
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Text(text = "Item")
            Text(text = "Quantity")
            Text(text = "Edit")
            Text(text = "Delete")
        }
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            items(sItems.value){
      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
          Text(text = itemName.value)
          Text(text = itemQty.value)
          IconButton(onClick ={} ) {  }
          Button(onClick = {}) { Icons.Default.Delete}
      }
            }
        }
    }
    if(showDialog.value) {

        AlertDialog(
            onDismissRequest = {showDialog.value=false},
            confirmButton = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = {
                        if (itemName.value.isNotBlank()) {
                            val newItem= ShoppingItem(
                                id=sItems.value.size + 1,
                                name = itemName.value,
                                quantity = itemQty.value.toInt()
                            )
                            sItems.value += newItem
                            showDialog.value=false
                        }
                    }) {
                        Text("Add")
                    }
                    Button(onClick = {showDialog.value=false}) {
                        Text("Cancel")
                    } }
            },
            title = { Text("Add Shopping Item") },
            text = {
                Column {
                    TextField(value =itemName.value, onValueChange = {
                        itemName.value=it}, placeholder = { Text("Item Name") })
                    TextField(value = itemQty.value, onValueChange = {itemQty.value=it},
                        placeholder = { Text("Item Quantity") })
                }
            })
    }
}

data class ShoppingItem (
    val id:Int,
    var name:String,
    var quantity:Int,
    var isEditing:Boolean=false
)