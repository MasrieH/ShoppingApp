package com.masrietech.shoppingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.graphics.Color

@Composable
fun Shopping(){
    val sItems = remember {  mutableStateOf(listOf<ShoppingItem>())}
    val showDialog= remember { mutableStateOf(false) }
    val itemName= remember { mutableStateOf("") }
    val itemQty= remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(40.dp))
       // thoughtList()
        Button(onClick = {showDialog.value=true}) {
            Text("Add Item")
        }


        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            items(sItems.value){
                item ->
                if(item.isEditing){
                    ShoppingItemEditor(item, onEditComplete={
                        editedName,editedQty ->
                        sItems.value=sItems.value.map {
                            it.copy(isEditing = false)
                        }
                        val editedItem=sItems.value.find { it.id==item.id }
                        editedItem?.let {
                            it.name=editedName
                            it.quantity=editedQty
                         //   it.isEditing=false
                        }
                    })
                }
                else {
                    ShoppingItemList(item, onEditItem = {
                        sItems.value=sItems.value.map {
                            it.copy(isEditing = it.id==item.id)
                        }
                    },
                        onDeleteItem = {
                            sItems.value -=item
                        })
                }
            }
        }
    }
    if(showDialog.value) {

        AlertDialog(
            onDismissRequest = {showDialog.value=false},
            confirmButton = {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = {
                        if (itemName.value.isNotBlank()) {
                            val newItem= ShoppingItem(
                                id=sItems.value.size + 1,
                                name = itemName.value,
                                quantity = itemQty.value.toInt()
                            )
                            sItems.value += newItem
                            showDialog.value=false
                            itemName.value=""
                            itemQty.value=""

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
                        itemName.value=it}, placeholder = {Text("i.e Apple")  },
                        label = {Text("Item Name") })
                    TextField(value = itemQty.value, onValueChange = {itemQty.value=it},
                        placeholder = { Text("i.e 4") },
                        label = { Text("Item Quantity") })
                }
            })
    }
}
@Composable
fun ShoppingItemList(item: ShoppingItem,onEditItem:()->Unit,onDeleteItem:()->Unit){

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color(0XFF018786)),
                shape = RoundedCornerShape(20)
            ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = item.name, modifier = Modifier.padding(8.dp).wrapContentSize())
        Text(text = "Qty:${item.quantity}", modifier = Modifier.padding(8.dp))
        Row {
            IconButton(onClick = onEditItem) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
            IconButton(onClick = onDeleteItem) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }

        }
    }
}
@Composable
fun ShoppingItemEditor(item: ShoppingItem,onEditComplete:(String,Int)->Unit){
    val editedName= remember { mutableStateOf(item.name) }
    val editedQuantity= remember { mutableStateOf(item.quantity.toString()) }
    val isEditing= remember { mutableStateOf(item.isEditing) }

    Row (modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .background(Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically){
        Column {
            BasicTextField(value = editedName.value, onValueChange = {editedName.value=it },
                singleLine = true,
                modifier = Modifier.wrapContentSize().padding(8.dp))

            BasicTextField(value = editedQuantity.value, onValueChange = {editedQuantity.value=it },
                singleLine = true,
                modifier = Modifier.wrapContentSize().padding(8.dp))

        }

        Button(onClick = {
            isEditing.value=false
            onEditComplete(editedName.value,editedQuantity.value.toIntOrNull()?:1)
        }) {
            Text("Save")
        }
    }
}

data class ShoppingItem (
    val id:Int,
    var name:String,
    var quantity:Int,
    var isEditing:Boolean=false
)



/*

What is the criteria that I have to consider

Pros
 -Our family is happy
 -I'm fine/happy If I have her
Cons
 -Don't know each other
 -Her interest (May be influenced by her family)
 -The process is unpredictable
 -Financial insecurity
 -My codding program will be interrupted
 -Mortgage plan might be interrupted
This Year
-Possible getting her
-Her and my family will be happy
-Things will be unpredictable (up/down)
Next year
-Mother, she and her family might be disappointed
-Possible losing her & one year value
-Might be a double wedding with her brother
-I'll have upper hand
-Give us a chance to know each other
-Will be financially stable
-Codding program and Mortgage plan will be secured
-The process will be clear
Next Plan
 - I'm glad that she said yes
 - What is there thought and how/in what way they are going to do things
 - Not this year unless they/she require it
 - It would be great if we do next year(January or Easter)
 - I will compensate her with gold-ring,well-dress and ...
 - Or this year engagement, next year wedding
 - To proceed with out wedding, I need her approval

 */