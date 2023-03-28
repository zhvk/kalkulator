package com.zhvk.kalkulator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CalculatorUiState(
    val displayedValue: String = "0",
    val firstOperand: String? = null,
    val secondOperand: String? = null,
    val operation: String = "",
    val isOperationClicked: Boolean = false,
)

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()

    fun typeNumber(char: Char) {
        _uiState.update { currentState ->
            val newValue: String

            // Start typing new value after operation is clicked
            if (currentState.isOperationClicked) {
                newValue = char.toString()
                currentState.copy(
                    displayedValue = newValue,
                    secondOperand = newValue,
                    isOperationClicked = false,
                )
            } else {
                newValue = if (currentState.displayedValue == "0") char.toString()
                else currentState.displayedValue + char
                currentState.copy(
                    displayedValue = newValue,
                    secondOperand = newValue
                )
            }
        }
    }

    fun setOperation(operation: String) {
        // This shows result when user consecutively presses operation buttons
        if (_uiState.value.firstOperand != null && _uiState.value.secondOperand != null
            && !_uiState.value.isOperationClicked
        ) calculate()

        _uiState.update { currentState ->
            currentState.copy(
                operation = operation,
                isOperationClicked = true,
                firstOperand = currentState.displayedValue,
            )
        }
    }

    fun calculate() {
        val operand1 = _uiState.value.firstOperand?.toDoubleOrNull()
        val operand2 = _uiState.value.secondOperand?.toDoubleOrNull()
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
                displayedValue = fixResult(result),
                firstOperand = fixResult(result)
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