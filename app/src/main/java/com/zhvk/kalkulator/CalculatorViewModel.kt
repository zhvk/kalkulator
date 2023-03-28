package com.zhvk.kalkulator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CalculatorUiState(
    val displayedValue: String = "0",
    val secondValue: String = "",
    val operation: String = "",
    val isOperationClicked: Boolean = false,
)

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()

    fun updateDisplayValue(char: Char) {
        _uiState.update { currentState ->
            // Start typing new value after operation is clicked
            if (currentState.isOperationClicked) {
                currentState.copy(
                    displayedValue = char.toString(),
                    isOperationClicked = false,
                )
            } else {
                currentState.copy(
                    displayedValue = if (currentState.displayedValue == "0") char.toString()
                    else currentState.displayedValue + char,
                )
            }
        }
    }

    fun setOperation(operation: String) {
        _uiState.update { currentState ->
            currentState.copy(
                operation = operation,
                isOperationClicked = true,
                secondValue = currentState.displayedValue,
            )
        }
    }

    fun calculate() {
        val operand1 = _uiState.value.secondValue.toDoubleOrNull()
        val operand2 = _uiState.value.displayedValue.toDoubleOrNull()
        var result: Double? = null

        when (_uiState.value.operation) {
            "/" -> {
                result = if (operand1 == null || operand2 == null || operand2 == 0.0) null
                else operand1 / operand2
            }
            "X" -> {
                if (operand1 != null && operand2 != null) result = operand1 * operand2
            }
            "-" -> {
                if (operand1 != null && operand2 != null) result = operand1 - operand2
            }
            "+" -> {
                if (operand1 != null && operand2 != null) result = operand1 + operand2
            }
            else -> {
                result = null
            }
        }

        _uiState.update { currentState ->
            currentState.copy(
                secondValue = currentState.displayedValue,
                displayedValue = fixResult(result),
            )
        }
    }

    private fun fixResult(result: Double?): String {
        if (result == null) return "Error"

        // Trim extra unnecessary decimal zeroes
        return if (result == result.toLong().toDouble()) String.format("%d", result.toLong())
        else String.format("%s", result)
    }
}