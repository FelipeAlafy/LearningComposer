package com.github.felipealafy.learningcomposer.exercise3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.felipealafy.learningcomposer.exercise3.ui.theme.Exercise3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exercise3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Board(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Board(modifier: Modifier) {
    val config = LocalConfiguration.current
    val maxHeight = config.screenHeightDp.dp
    val maxWidth = config.screenWidthDp.dp
   Box(modifier = modifier.fillMaxSize()) {
       Column(
           modifier = modifier
               .background(Color.Green)
               .align(Alignment.TopStart)
               .size(maxWidth / 2, maxHeight / 2)
               .padding(16.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Arrangement.Center
            Text(stringResource(R.string.text_composable), modifier = modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.text_composable_description), modifier = modifier, textAlign = TextAlign.Justify)

       }
       Column(
           modifier = modifier
               .background(Color.Yellow)
               .align(Alignment.TopEnd)
               .size(maxWidth / 2, maxHeight / 2)
               .padding(16.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Text(stringResource(R.string.image_composable), modifier = modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)
           Text(stringResource(R.string.image_composable_description), modifier = modifier, textAlign = TextAlign.Justify)
       }
       Column(
           modifier = modifier
               .background(Color.Cyan)
               .align(Alignment.BottomStart)
               .size(maxWidth / 2, (maxHeight / 2) + 1.dp)
               .padding(16.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Text(stringResource(R.string.row_composable), modifier = modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)
           Text(stringResource(R.string.row_composable_description), modifier = modifier, textAlign = TextAlign.Justify)
       }
       Column(
           modifier = modifier
               .background(Color.LightGray)
               .align(Alignment.BottomEnd)
               .size((maxWidth / 2) + 1.dp, (maxHeight / 2) + 1.dp)
               .padding(16.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Text(stringResource(R.string.column_composable), modifier = modifier.padding(bottom = 16.dp), fontWeight = FontWeight.Bold)
           Text(stringResource(R.string.column_composable_description), modifier = modifier, textAlign = TextAlign.Justify)
       }
   }
}

@Preview(showBackground = true)
@Composable
fun BoardPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Board(modifier = Modifier)
    }
}