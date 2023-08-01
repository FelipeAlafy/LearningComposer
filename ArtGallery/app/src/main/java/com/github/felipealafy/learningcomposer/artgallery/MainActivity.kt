package com.github.felipealafy.learningcomposer.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.felipealafy.learningcomposer.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtGallery(Modifier)
                }
            }
        }
    }
}

@Composable
fun ArtGallery(modifier: Modifier) {

    val photo1 = CircularQueue(R.drawable.photo1, R.string.photo_1_content_description, R.string.photo_1_artwork_name, R.string.artist_name, R.string.artwork_year, null, null)
    val photo2 = CircularQueue(R.drawable.photo2, R.string.photo_2_content_description, R.string.photo_2_artwork_name, R.string.artist_name, R.string.artwork_year, null, photo1)
    val photo3 = CircularQueue(R.drawable.photo3, R.string.photo_3_content_description, R.string.photo_3_artwork_name, R.string.artist_name, R.string.artwork_year, null, photo2)
    val photo4 = CircularQueue(R.drawable.photo4, R.string.photo_4_content_description, R.string.photo_4_artwork_name, R.string.artist_name, R.string.artwork_year, null, photo3)

    photo1.Previous = photo4
    photo1.Next = photo2
    photo2.Next = photo3
    photo3.Next = photo4
    photo4.Next = photo1

    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        var currentPhoto by remember { mutableStateOf(photo1) }

        Surface (
            shadowElevation = 10.dp,
            border = BorderStroke(2.dp, Color.DarkGray)
        ) {
            Row(Modifier.padding(20.dp)) {
                Image(painter = painterResource(id = currentPhoto.ImageResourceID), contentDescription = stringResource(
                    id = currentPhoto.ContentDescriptionID,
                ))
            }
        }

        Surface(shadowElevation = 10.dp, border = BorderStroke(1.dp, Color.LightGray)) {
             Column () {
                Text(text = stringResource(id = currentPhoto.ArtWorkTitle), fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text(text = "${stringResource(id = currentPhoto.ArtistName)} (${stringResource(id = currentPhoto.ArtYear)})", fontSize = 16.sp)
             }
        }

        Row (verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { currentPhoto = currentPhoto.Previous!! }) {
                Text(text = "Previous")
            }

            Button(onClick = { currentPhoto = currentPhoto.Next!! }) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtGalleryPreview() {
    ArtGalleryTheme {
        ArtGallery(Modifier.fillMaxSize())
    }
}