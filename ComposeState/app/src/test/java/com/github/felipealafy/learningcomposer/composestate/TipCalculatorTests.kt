package com.github.felipealafy.learningcomposer.composestate

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat
import java.util.logging.Logger

class TipCalculatorTests {
    @Test
    fun calculate_20_percent_tip_no_round_up() {
        val tipAmount = 10.0
        val tipPercentage = 20.0

        val tip = tipAmount.calculateTip(tipPercentage, false)
        val expected = NumberFormat.getCurrencyInstance().format(2)

        val log = Logger.getGlobal()
        log.info("calculate_20_percent_tip_no_round_up >>> tip is equals to \t\t$tip")
        log.info("calculate_20_percent_tip_no_round_up >>> expected is equals to \t\t$expected")

        assertEquals(expected, tip)
    }

    @Test
    fun calculate_20_percent_tip_round_up() {
        val tipAmount = 10.0
        val tipPercentage = 20.0

        val tip = tipAmount.calculateTip(tipPercentage, true)
        val expected = NumberFormat.getCurrencyInstance().format(2)

        val log = Logger.getGlobal()
        log.info("calculate_20_percent_tip_round_up >>> tip is equals to \t\t$tip")
        log.info("calculate_20_percent_tip_round_up >>> expected is equals to \t\t$expected")

        assertEquals(expected, tip)
    }

    @Test
    fun calculate_15_percent_tip_no_round_up() {
        val tipAmount = 10.0
        val tipPercentage = 15.0

        val tip = tipAmount.calculateTip(tipPercentage, false)
        val expected = NumberFormat.getCurrencyInstance().format(1.5)


        val log = Logger.getGlobal()
        log.info("calculate_15_percent_tip_no_round_up >>> tip is equals to \t\t$tip")
        log.info("calculate_15_percent_tip_no_round_up >>> expected is equals to \t\t$expected")

        assertEquals(expected, tip)
    }

    @Test
    fun calculate_15_percent_tip_round_up() {
        val tipAmount = 10.0
        val tipPercentage = 15.0

        val tip = tipAmount.calculateTip(tipPercentage, true)
        val expected = NumberFormat.getCurrencyInstance().format(2)

        val log = Logger.getGlobal()
        log.info("calculate_15_percent_tip_no_round_up >>> tip is equals to \t\t$tip")
        log.info("calculate_15_percent_tip_no_round_up >>> expected is equals to \t\t$expected")

        assertEquals(expected, tip)
    }
}