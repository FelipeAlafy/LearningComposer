package com.github.felipealafy.learningcomposer.composestate

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.github.felipealafy.learningcomposer.composestate.ui.theme.ComposeStateTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class MainUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            ComposeStateTheme {
                TipTimeScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")

        val expectedResult = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedResult").assertExists("No node with this text was found.")
    }
}