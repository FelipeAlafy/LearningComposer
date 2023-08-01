package com.github.felipealafy.learningcomposer.composestate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.felipealafy.learningcomposer.composestate.ui.theme.ComposeStateTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeScreen()
                }
            }
        }
    }
}

@Composable
fun TipTimeScreen() {
    var roundUp by remember { mutableStateOf(false) }
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull()?: 0.0
    var tipInput by remember { mutableStateOf("") }
    val tipValue = tipInput.toDoubleOrNull()?: 15.0
    val tip = amount.calculateTip(tipValue, roundUp)

    val focusManager = LocalFocusManager.current

    Column (
        modifier= Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        EditNumberField(
            Label = R.string.bill_amount,
            Action = ImeAction.Next,
            KeyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            Value = amountInput,
            OnValueChange = {amountInput = it})

        EditNumberField(
            Label = R.string.how_was_the_service,
            Action =  ImeAction.Done,
            KeyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            Value = tipInput,
            OnValueChange = {tipInput = it
            })

        RoundTheTipRow(roundUp = roundUp, onRoundUpChange = { roundUp = it })

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(Label: Int,
                    Action:ImeAction = ImeAction.Default,
                    KeyboardActions: KeyboardActions,
                    Value: String, OnValueChange: (String) -> Unit) {
    TextField(
        value = Value,
        onValueChange = OnValueChange,
        label = { Text(stringResource(Label))},
        modifier = Modifier,
        singleLine = true,
        keyboardActions = KeyboardActions,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = Action
        )
    )
}

@Composable
fun RoundTheTipRow(roundUp: Boolean, onRoundUpChange: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.round_up_tip))
        Switch (
            checked = roundUp,
            onCheckedChange = onRoundUpChange,
            colors = SwitchDefaults.colors (
                uncheckedThumbColor = Color.DarkGray,
            ),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TipTimeScreenPreview() {
    ComposeStateTheme {
        TipTimeScreen()
    }
}

@VisibleForTesting
internal fun Double.calculateTip(TipPercentage: Double = 15.0, ShouldRoundUp: Boolean): String {
    val tip = TipPercentage / 100 * this
    return if (ShouldRoundUp) {
        NumberFormat.getCurrencyInstance().format(kotlin.math.ceil(tip))
    } else {
        NumberFormat.getCurrencyInstance().format(tip)
    }
}
