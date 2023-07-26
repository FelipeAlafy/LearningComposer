package com.github.felipealafy.learningcomposer.lemonade

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
import com.github.felipealafy.learningcomposer.lemonade.ui.theme.LemonadeTheme

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
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    LemonadeWithImage()
}

@Composable
fun LemonadeWithImage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.wrapContentSize(align = Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var clicksNeed by remember {mutableStateOf(GetCountOfSteps()) }
        var clicks by remember { mutableStateOf(1) }
        var info by remember { mutableStateOf(R.string.lemon_tree) }
        var step by remember { mutableStateOf(R.drawable.lemon_tree) }

        Text(text = stringResource(id = info), fontSize = 18.sp, modifier = modifier.padding(bottom=16.dp))
        Button(onClick = { clicks++ }) {
            Image(painter = painterResource(id = step), contentDescription = "")
        }

        step = when (clicks) {
            1 -> {info = R.string.lemon_tree; R.drawable.lemon_tree}
            in (2..clicksNeed - 3) ->{info = R.string.tap_the_lemon; R.drawable.lemon_squeeze}
            (clicksNeed - 2) -> {info = R.string.drink_the_lemonade; R.drawable.lemon_drink}
            (clicksNeed - 1) -> {info = R.string.tap_the_empty_glass_to_start_again; R.drawable.lemon_restart}
            else -> {clicks = 1; clicksNeed = GetCountOfSteps(); info = R.string.lemon_tree; R.drawable.lemon_tree;}
        }
    }
}

@Preview(showBackground=true)
@Composable
fun LemonadePreview() {
    LemonadeTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(), 
            color = MaterialTheme.colorScheme.background
        ) {
            LemonadeApp()    
        }
    }
}