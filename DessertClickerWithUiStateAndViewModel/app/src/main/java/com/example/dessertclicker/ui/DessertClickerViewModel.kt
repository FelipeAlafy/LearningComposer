package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    private var currentDessert: Dessert


    init {
        val dessert = Datasource.dessertList.first()
        currentDessert = dessert
        _uiState.update { currentState ->
            currentState.copy(
                currentDessertIndex = 0,
                currentDessertPrice = dessert.price,
                currentDessertImageId = dessert.imageId,
            )
        }
    }



    fun soldDessert() {
        val updatedSold = _uiState.value.revenue.plus(currentDessert.price)
        val dessertsSold = _uiState.value.dessertsSold + 1
        _uiState.update { currentState ->
            currentState.copy(revenue = updatedSold, dessertsSold = dessertsSold)
        }
    }

    fun determineDessertToShow() {
        //First Load all the desserts
        val desserts = Datasource.dessertList
        //check if a dessert need to change
        for ((index, dessert) in desserts.withIndex()) {
            if (_uiState.value.dessertsSold >= currentDessert.startProductionAmount)  {
                currentDessert = dessert
                _uiState.update { currentState ->
                    currentState.copy(
                        currentDessertIndex = index,
                        currentDessertPrice = dessert.price,
                        currentDessertImageId = dessert.imageId,
                    )
                }
            } else {
                break
            }
        }
    }

}