@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.felipealafy.learningcomposer.woofapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.felipealafy.learningcomposer.woofapp.data.DogLoader
import com.github.felipealafy.learningcomposer.woofapp.model.Dog
import com.github.felipealafy.learningcomposer.woofapp.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WoofApp()
                }
            }
        }
    }
}

@Composable
fun WoofApp() {
    WoofList(DogList = DogLoader().loadDogs(), modifier = Modifier)
}

@Composable
fun WoofList(DogList: List<Dog>, modifier: Modifier) {
    Scaffold (
        topBar = {
            WoofTopBar()
        }
    ) {it ->
        LazyColumn(contentPadding = it) {
            items(DogList) {
                WoofCard(dog = it)
            }
        }
    }
}

@Composable
fun DogExpanser(expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier) {
        val image = if (expanded) {
            Icons.Filled.ExpandLess
        } else {
            Icons.Filled.ExpandMore
        }
        Icon(
            imageVector = image,
            contentDescription = stringResource(R.string.expand_more),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun DogHobby(@StringRes Hobby: Int, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = stringResource(R.string.about), style = MaterialTheme.typography.labelSmall)
        Text(text = stringResource(id = Hobby), style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun WoofTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_woof_logo),
                    contentDescription = stringResource(R.string.woof_logo),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun WoofCard(dog: Dog) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = dimensionResource(id = R.dimen.padding_small),
            end = dimensionResource(id = R.dimen.padding_small),
            bottom = dimensionResource(id = R.dimen.padding_medium),
        )) {
        Column {
            Row (
                Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            ) {

                Image(
                    painter = painterResource(id = dog.DogsPhoto),
                    contentDescription = stringResource(id = dog.DogsName),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .clip(MaterialTheme.shapes.small),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier) {
                    Text(
                        text = stringResource(id = dog.DogsName),
                        style = MaterialTheme.typography.displayMedium,
                    )
                    Text(
                        text = "${dog.DogsAge} ${stringResource(id = R.string.years_old)}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(modifier = Modifier.weight(1F))
                DogExpanser(expanded = expanded, onClick = { expanded = !expanded }, modifier = Modifier)
            }
            if (expanded) {
                DogHobby(Hobby = dog.hobbies, modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_small),
                    end = dimensionResource(R.dimen.padding_medium),
                    bottom = dimensionResource(R.dimen.padding_medium)

                ))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoofTheme {
        WoofApp()
    }
}