package com.github.felipealafy.learningcomposer.personalcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.felipealafy.learningcomposer.personalcard.ui.theme.PersonalCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card(name = "Felipe Alafy",
                        title = "Junior Kotlin Developer",
                        phone = "+55 (35) 90000-0000",
                        socialMidia = "@falaf",
                        email = "felipealafy@mail.com",
                        modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Card(name: String, title: String, phone: String, socialMidia: String, email: String, modifier: Modifier,) {
    Box(modifier = Modifier.background(Color(7, 48, 66))) {
       Box(modifier = Modifier.align(Alignment.Center)) {
           Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
               //Image
               val painter = painterResource(id = R.drawable.android_logo)
               Image(painter = painter, contentDescription = stringResource(R.string.content_description_image1), modifier = Modifier.size(120.dp, 120.dp))
               Text(text = name, textAlign = TextAlign.Center, fontSize = 32.sp, color = Color.White)
               Text(text = title, textAlign = TextAlign.Center, fontSize = 20.sp, color = Color.Green, fontWeight = FontWeight.Bold)
           }
       }

       Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Column {
                Divider()
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 32.dp)) {
                    Icon(Icons.Rounded.Phone, contentDescription = stringResource(R.string.phone_number), Modifier.padding(16.dp), Color(0xFF3ddc84))
                    Text(text = phone, fontSize = 18.sp, textAlign=TextAlign.Center,  color = Color.White)
                }
                Divider()
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 32.dp)) {
                    Icon(Icons.Rounded.Share, contentDescription = stringResource(R.string.social_medias), Modifier.padding(16.dp), Color(0xFF3ddc84))
                    Text(text = socialMidia, fontSize = 18.sp, textAlign=TextAlign.Center,  color = Color.White)
                }
                Divider()
                Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 32.dp)) {
                    Icon(Icons.Rounded.Email, contentDescription = stringResource(R.string.email), Modifier.padding(16.dp), Color(0xFF3ddc84))
                    Text(text = email, fontSize = 18.sp, textAlign=TextAlign.Center,  color = Color.White)
                }
            }
       }
    }
}

@Preview(showBackground=true)
@Composable
fun CardPreview() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Card(name = "Felipe Alafy",
            title = "Junior Kotlin Developer",
            phone = "+55 (35) 90000-0000",
            socialMidia = "@falaf",
            email = "felipealafy@mail.com",
            modifier = Modifier)
    }
}