package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.cupcake.data.DataSource
import com.example.cupcake.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class CupcakeStartScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun startScreenTest_VerifyOptions() {
        val quantityOptions = DataSource.quantityOptions

        composeTestRule.setContent {
            StartOrderScreen(quantityOptions= quantityOptions, onNextButtonClicked = {})
        }

        quantityOptions.forEach {qo ->
            composeTestRule.onNodeWithStringId(qo.first).assertIsDisplayed()
        }
    }
}