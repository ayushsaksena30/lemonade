package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var tap by remember { mutableStateOf( 1) }

    //var result=1
    val imageResource = when (tap) {
        1 -> R.drawable.lemon_tree
        in 2..10 -> R.drawable.lemon_squeeze
        11 -> R.drawable.lemon_drink
        12 -> R.drawable.lemon_restart
        else -> { tap=1
            R.drawable.lemon_tree}
    }

    val image = painterResource(R.drawable.lemon_tree)


    Box {
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF9E44B)),
            fontWeight = FontWeight.Bold
        )


        Column(
            modifier = Modifier
                .wrapContentSize(Alignment.TopCenter)
                .fillMaxSize()
                .fillMaxHeight(),
                //.shadow(30.dp),
                //.background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //Spacer(modifier = Modifier.height(150.dp))

            Button( onClick = { tap++},
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                            .shadow(50.dp)
                            .clip(RoundedCornerShape(16.dp))

                ) {
                Image(painter = painterResource(id = imageResource),
                    contentDescription = tap.toString())
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = when (tap) {
                1 -> "Tap the lemon tree to select a lemon"
                in 2..7-> "Keep tapping the lemon to squeeze it"
                in 8..10 -> "Almost Empty!"
                11 -> "Tap the lemonade to drink it"
                12 -> "Tap the Empty glass to start again"
                else -> { tap=1
                    "Tap the lemon tree to select a lemon"}})
                }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Greeting("Android")
    }
}