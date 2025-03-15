package com.masrietech.shoppingapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun thoughtList(){
    val momentList=ArrayList<CriticalThought>()
    val thisYearList=ArrayList<CriticalThought>()
    val nextYearList=ArrayList<CriticalThought>()
    val nextPlanList=ArrayList<CriticalThought>()
    momentList.add(CriticalThought("+","Our family is happy"))
    momentList.add(CriticalThought("+","I'm fine/happy of getting her"))
    momentList.add(CriticalThought("-","Don't know each other"))
    momentList.add(CriticalThought("-","Her interest (May be influenced by her family)"))
    momentList.add(CriticalThought("-","The process is unpredictable"))
    momentList.add(CriticalThought("-","Financial insecurity"))
    momentList.add(CriticalThought("-","My codding program will be interrupted"))
    momentList.add(CriticalThought("-","Mortgage plan might be interrupted"))
    thisYearList.add(CriticalThought("+","Possible getting her"))
    thisYearList.add(CriticalThought("+","Her and my family will be happy"))
    thisYearList.add(CriticalThought("-","Things will be unpredictable (up/down)"))
    nextYearList.add(CriticalThought("-","Mother, she and her family might be disappointed"))
    nextYearList.add(CriticalThought("-","Possible losing her & one year value"))
    nextYearList.add(CriticalThought("-","Might be a double wedding with her brother"))
    nextYearList.add(CriticalThought("+","I'll have upper hand"))
    nextYearList.add(CriticalThought("+","Give us a chance to know each other"))
    nextYearList.add(CriticalThought("+","Will be financially stable"))
    nextYearList.add(CriticalThought("+","Codding program and Mortgage plan will be secured"))
    nextYearList.add(CriticalThought("+","The process will be clear"))
    nextPlanList.add(CriticalThought("+","Express that I'm glad that she said yes"))
    nextPlanList.add(CriticalThought("+","What is her/there thought and how/in what way they are going to do things"))
    nextPlanList.add(CriticalThought("-","Not this year unless they/she require it"))
    nextPlanList.add(CriticalThought("+","It would be great if we do next year(January or Easter)"))
    nextPlanList.add(CriticalThought("+","I will compensate her with gold-ring,well-dress and ..."))
    nextPlanList.add(CriticalThought("+","Or this year engagement, next year wedding"))
    nextPlanList.add(CriticalThought("-","To proceed with out wedding, I need her approval"))


    Column (modifier = Modifier.fillMaxSize()){
Text(" ==== My perspective on her ====  \n", fontSize = 28.sp)

listDisplay("Current View",momentList)
listDisplay("This Year",thisYearList)
listDisplay("Next Year",nextYearList)
listDisplay("Next Plan",nextPlanList)




    }
}

@Composable
fun listDisplay(category:String,itemList:ArrayList<CriticalThought>){
Text(category, fontWeight = FontWeight.Medium, fontSize = 20.sp)
    LazyColumn {
        items(itemList){val item=it
            Row {
                Text("    "+item.sign+"  ", fontSize = 12.sp)
                Text(item.list, fontSize = 16.sp)
            }
        }
    }
}


data class CriticalThought(
    val sign:String="+",
    val list:String
)


@Preview(showBackground = true, device = Devices.PIXEL_6)
@Composable
fun thought(){
    thoughtList()
}