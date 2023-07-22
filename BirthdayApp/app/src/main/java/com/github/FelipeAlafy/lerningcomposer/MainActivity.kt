package com.github.felipealafy.lerningcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.FelipeAlafy.lerningcomposer.R
import com.github.FelipeAlafy.lerningcomposer.ui.theme.LerningComposerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LerningComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BirthdayGreetingWithImage(name = "Denis", from = "Felipe")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(name: String, from: String, modifier: Modifier = Modifier) {
    Box{
        val image = painterResource(id = R.drawable.androidparty)
        Image(
            painter = image,
            contentDescription = "A party image with a cake",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.happy_birthday) + " $name!",
                fontSize=36.sp,
                modifier = Modifier.padding(top=16.dp)
            )
            Text(
                text = stringResource(R.string.from) + " $name",
                fontSize=24.sp,
                modifier = Modifier
                    .padding(top=16.dp)
                    .align(alignment = Alignment.End)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LerningComposerTheme {
        BirthdayGreetingWithImage("Denis", "Felipe")
    }
}