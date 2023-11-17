package com.example.unscramble.ui.test

import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import com.example.unscramble.ui.GameViewModel
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue


class GameViewModelTest {
    private val viewModel = GameViewModel()
    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
        private const val EXPECTED_DEFAULT_SCORE = 0
    }

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdateAndErrorFlagUnset() {
        var currentGameState = viewModel.uiState.value
        val unscrambledWord = getUnscrambledWord(currentGameState.currentScrambledWord)
        
        viewModel.updateUserGuess(unscrambledWord)
        viewModel.checkUserGuess()

        currentGameState = viewModel.uiState.value
        assertFalse(currentGameState.isGuessedWordWrong)
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameState.score)
    }

    @Test
    fun gameViewModel_IncorrectWordGuessed_ErrorFlagSet() {
        var currentGameState = viewModel.uiState.value
        val currentWord = getUnscrambledWord(currentGameState.currentScrambledWord)
        val randomizedWord = currentWord.shuffleCurrentWord()

        viewModel.updateUserGuess(randomizedWord)
        viewModel.checkUserGuess()

        currentGameState = viewModel.uiState.value
        assertTrue(currentGameState.isGuessedWordWrong)
        assertEquals(0, currentGameState.score)
    }

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        var currentGameState = viewModel.uiState.value
        val unScrambledWord = getUnscrambledWord(currentGameState.currentScrambledWord)

        assertNotEquals(unScrambledWord, currentGameState.currentScrambledWord)
        assertTrue(currentGameState.currentWordCount == 1)
        assertTrue(currentGameState.score == EXPECTED_DEFAULT_SCORE)
        assertFalse(currentGameState.isGuessedWordWrong)
        assertFalse(currentGameState.isGameOver)
    }

    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdateCorrectly() {
        var expectedScore = 0
        var currentGameState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameState.currentScrambledWord)
        repeat(MAX_NO_OF_WORDS) {
            expectedScore += SCORE_INCREASE
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            currentGameState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameState.currentScrambledWord)
            assertEquals(expectedScore, currentGameState.score)
        }
        assertEquals(MAX_NO_OF_WORDS, currentGameState.currentWordCount)
        assertTrue(currentGameState.isGameOver)
    }

    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased() {
        var currentGameState = viewModel.uiState.value
        var correctWord = getUnscrambledWord(currentGameState.currentScrambledWord)
        viewModel.updateUserGuess(correctWord)
        viewModel.checkUserGuess()

        currentGameState = viewModel.uiState.value
        val lastWordCount = currentGameState.currentWordCount
        viewModel.skipWord()
        currentGameState = viewModel.uiState.value

        assertEquals(currentGameState.score, SCORE_AFTER_FIRST_CORRECT_ANSWER)
        assertEquals(lastWordCount + 1, currentGameState.currentWordCount)
    }

    private fun String.shuffleCurrentWord(): String {
        val tempWord = this.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord) == this) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }
}