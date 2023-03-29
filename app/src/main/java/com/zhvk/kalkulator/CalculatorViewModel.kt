package com.zhvk.kalkulator

import android.util.Log
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
    val isEqualsClicked: Boolean = false
)

class CalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()

    // TODO: Improve logic to not use copy constructor so much

    // TODO: Implement history. This can help to optimise the ViewModel logic

    fun typeNumber(char: Char) {
        Log.d("Debug", "typeNumber($char)")

        _uiState.update { currentState ->
            val newValue: String

            // Start typing new value after operation or if equals is clicked
            if (currentState.isOperationClicked || currentState.isEqualsClicked) {
                // Clear memory only when equals was previously clicked
                if (currentState.isEqualsClicked && !currentState.isOperationClicked) allClear()

                newValue = char.toString()
                currentState.copy(
                    displayedValue = newValue,
                    secondOperand = newValue,
                    isOperationClicked = false,
                    isEqualsClicked = false
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
        Log.d("Debug", "setOperation($operation)")

        // This shows result when user consecutively presses operation buttons
        if (_uiState.value.firstOperand != null && _uiState.value.secondOperand != null
            && !_uiState.value.isOperationClicked && !_uiState.value.isEqualsClicked
        ) calculate(false)

        _uiState.update { currentState ->
            currentState.copy(
                operation = operation,
                isOperationClicked = true,
                firstOperand = currentState.displayedValue,
            )
        }
    }

    fun getOperation(): String? {
        return if (_uiState.value.isOperationClicked) _uiState.value.operation
        else null
    }

    fun calculate(isEqualsPressed: Boolean) {
        val operand1 = _uiState.value.firstOperand?.toDoubleOrNull()
        val operand2 = _uiState.value.secondOperand?.toDoubleOrNull()
        var result: Double? = null

        when (_uiState.value.operation) {
            Constants.DIVISION -> {
                result = if (operand1 == null || operand2 == null || operand2 == 0.0) null
                else operand1 / operand2
            }
            Constants.MULTIPLICATION -> {
                if (operand1 != null && operand2 != null) result = operand1 * operand2
            }
            Constants.SUBTRACTION -> {
                if (operand1 != null && operand2 != null) result = operand1 - operand2
            }
            Constants.ADDITION -> {
                if (operand1 != null && operand2 != null) result = operand1 + operand2
            }
            else -> {
                result = null
            }
        }

        Log.d("Debug", "calculate($operand1 ${_uiState.value.operation} $operand2 = $result)")


        _uiState.update { currentState ->
            currentState.copy(
                displayedValue = fixResult(result),
                firstOperand = fixResult(result),
                isEqualsClicked = isEqualsPressed
            )
        }
    }

    fun allClear() {
        Log.d("Debug", "allClear()")
        _uiState.update { currentState ->
            currentState.copy(
                displayedValue = "0",
                firstOperand = null,
                secondOperand = null,
                operation = "",
                isOperationClicked = false,
                isEqualsClicked = false
            )
        }
    }

    fun reverseNumberSign() {
        Log.d("Debug", "reverseNumberSign()")

        // If memory is not empty, first calculate data from memory
        if (_uiState.value.firstOperand != null && _uiState.value.secondOperand != null
            && !_uiState.value.isOperationClicked && !_uiState.value.isEqualsClicked
        ) calculate(false)

        _uiState.update { currentState ->
            currentState.copy(
                firstOperand = currentState.displayedValue,
                secondOperand = "-1",
                operation = Constants.MULTIPLICATION,
            )
        }
        calculate(true)
    }

    fun toDecimal() {
        Log.d("Debug", "toDecimal()")

        // If memory is not empty, first calculate data from memory
        if (_uiState.value.firstOperand != null && _uiState.value.secondOperand != null
            && !_uiState.value.isOperationClicked && !_uiState.value.isEqualsClicked
        ) calculate(false)

        _uiState.update { currentState ->
            currentState.copy(
                firstOperand = currentState.displayedValue,
                secondOperand = "100",
                operation = Constants.DIVISION
            )
        }
        calculate(true)
    }

    private fun fixResult(result: Double?): String {
        if (result == null) return "Error"

        // Trim extra unnecessary decimal zeroes
        return if (result == result.toLong().toDouble()) String.format("%d", result.toLong())
        else String.format("%s", result)
    }
}