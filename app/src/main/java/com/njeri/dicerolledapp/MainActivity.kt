package com.njeri.dicerolledapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.njeri.dicerolledapp.ui.theme.DiceRolledAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRolledAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRolledApp()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DiceRolledApp() {

    DiceRolledComponent(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))

}

@Composable
fun DiceRolledComponent( modifier:Modifier= Modifier) {
    var resultOfRoll by remember {
        mutableStateOf(1)
      }
    val imageResource = when(resultOfRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
   Column(
       modifier = modifier,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Image(painter = painterResource(id = imageResource),
           contentDescription = "1")

       Spacer(modifier = Modifier.height(20.dp))

       Button(onClick = { resultOfRoll= (1..6).random() }) {
       Text(text = "Roll")
       }
   }
}

//@Composable
//fun RollTheDice():Int{
//    var resultOfRoll by remember {
//        mutableStateOf(1)
//    }
//    val imageResource = when(resultOfRoll) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
//    resultOfRoll=(1..6).random()
//    return resultOfRoll;
//}
