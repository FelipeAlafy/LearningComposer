package com.github.felipealafy.learningcomposer.trintareceitas

import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.felipealafy.learningcomposer.trintareceitas.model.Recipe

class RecipesWidgets {
    @Composable
    fun IngredientBullet(@StringRes ingredient: Int) {
        Text(text = "• ${stringResource(id = ingredient)}")
    }

    @Composable
    fun PreparationMethod(@StringRes preparationMethod: Int, modifier: Modifier = Modifier) {
        Column {
            Text(text = "Modo de Preparo:", style = MaterialTheme.typography.titleLarge, modifier = Modifier.align(CenterHorizontally))
            Text(text = stringResource(id = preparationMethod), textAlign = TextAlign.Justify)
        }
    }

    @Composable
    fun Expanser(expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
        IconButton(onClick = onClick, modifier = modifier) {
            val expandState = if (expanded) {
                Icons.Filled.ExpandLess
            } else {
                Icons.Filled.ExpandMore
            }
            Icon(imageVector = expandState, contentDescription = stringResource(R.string.expand), tint = MaterialTheme.colorScheme.secondary)
        }
    }

    @Composable
    fun Title(@StringRes title: Int, modifier: Modifier = Modifier) {
        Text(text = stringResource(id = title), style = MaterialTheme.typography.displaySmall, textAlign = TextAlign.Center)
    }

    @Composable
    fun RecipeCard(recipe: Recipe, modifier: Modifier = Modifier) {
        var descriptionIsExtended by remember { mutableStateOf(false) }
        val expandedCardColor by animateColorAsState(targetValue = if (descriptionIsExtended) {
            MaterialTheme.colorScheme.tertiaryContainer
        } else {
            MaterialTheme.colorScheme.primaryContainer
        })

        Card (
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    top = 16.dp,
                    bottom = 16.dp,
                    start = 8.dp,
                    end = 8.dp
                )
        ) {
            Column(modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = expandedCardColor)
                .align(Alignment.CenterHorizontally)
            ) {
                Title(title = recipe.Name, modifier = Modifier.align(Alignment.CenterHorizontally))
                Image(painter = painterResource(id = recipe.Image), contentDescription = null, modifier = Modifier.align(Alignment.CenterHorizontally))
                if (descriptionIsExtended) {
                    Text(text = stringResource(id = R.string.ingredientes), modifier = Modifier.align(CenterHorizontally), style = MaterialTheme.typography.titleLarge)
                    recipe.Ingredients.forEach {
                        IngredientBullet(ingredient = it)
                    }
                    PreparationMethod(preparationMethod = recipe.Preparation)
                }
                Expanser(expanded = descriptionIsExtended, onClick = { descriptionIsExtended = !descriptionIsExtended }, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}