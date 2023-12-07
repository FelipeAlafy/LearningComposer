package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.R
import org.junit.Rule
import org.junit.Test

class CupcakeOrderSummaryScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun OrderSummaryScreen_verifyContent() {
        val orderUiState = OrderUiState(
            quantity=1,
            flavor="Vanilla",
            date="Nov 18",
            price="$ 300",
            pickupOptions= listOf("Nov 18")
        )

        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState= orderUiState,
                onCancelButtonClicked= {},
                onSendButtonClicked= {_ : String, _: String ->}
            )
        }

        composeTestRule.onNodeWithText(orderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(orderUiState.date).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.subtotal_price, orderUiState.price)
        ).assertIsDisplayed()
        composeTestRule.onNodeWithText(orderUiState.pickupOptions[0]).assertIsDisplayed()

        composeTestRule.onNodeWithStringId(R.string.send).assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.send).assertIsEnabled()

        composeTestRule.onNodeWithStringId(R.string.cancel).assertIsDisplayed()
        composeTestRule.onNodeWithStringId(R.string.cancel).assertIsEnabled()
    }
}