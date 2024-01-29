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
        var counter by remember{ mutableStateOf(0) }
        var result by remember{ mutableStateOf(11) }
        var timeCheck by remember { mutableStateOf((5..10).random()) }
        var orange = when(result)
        {
            in 1..10 -> R.drawable.orange_fruit
             0 -> R.drawable.orange_drink_full
             -1 -> R.drawable.orange_drink_empty
            else -> {R.drawable.orange_tree}
        }

        Button(onClick = {
            result = timeCheck

            if(timeCheck == -1)
            {
                counter += 1
            }
            if(timeCheck < -1)
            {
                timeCheck = (5..10).random()
            }
            timeCheck -= 1

        }) {

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
