package com.example.orange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orange.ui.theme.OrangeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(align = Alignment.Center)) {

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        var orange = R.drawable.orange_tree
        var counter: Int = 0
        var result by remember{ mutableStateOf(-1) }
        var squeeze by remember { mutableStateOf(0) }
        var  timeCheck =  (5 .. 10).random()
        orange = when(result)
        {
            -1 -> R.drawable.orange_tree

             0 -> R.drawable.orange_drink_empty
            else -> {R.drawable.orange_fruit}
        }


        Button(onClick = {
            result = timeCheck
        }) {
            timeCheck = timeCheck - 1
            Image(painter = painterResource(id = orange), contentDescription = "tree")
            Text(text = stringResource(id = R.string.RollOrange))





        }
        Text(
            text = "Games count: $counter",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )

    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OrangeTheme {
        Greeting()
    }
}


/*
fun RollDiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(align = Alignment.Center))
{
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
    {

        var result by remember{ mutableStateOf(1) }
        var diceImageID = when(result)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        Image(painter = painterResource(diceImageID), contentDescription = "dice")

        Spacer(modifier = Modifier.height(60.dp))


        Button(onClick = {
            result = (1 .. 6).random()
        }) {

            Text(text = stringResource(id = R.string.RollDiceBtnText))
            //Text(text = stringResource(id = "roll"))

        }
    }
}
 */