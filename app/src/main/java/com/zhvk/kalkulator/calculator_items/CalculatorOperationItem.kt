package com.zhvk.kalkulator.calculator_items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.zhvk.kalkulator.ui.theme.Orange
import com.zhvk.kalkulator.ui.theme.White

@Composable
fun CalculatorOperationItem(
    modifier: Modifier, action: String, onClick: () -> Unit, selectedOperation: String?
) {
    val isSelected = remember { mutableStateOf(false) }
    val textColor = remember { mutableStateOf(White) }
    val backgroundColor = remember { mutableStateOf(Orange) }

    isSelected.value = action == selectedOperation
    if (isSelected.value) {
        textColor.value = Orange
        backgroundColor.value = White
    } else {
        textColor.value = White
        backgroundColor.value = Orange
    }

    CalculatorItem(
        modifier = modifier,
        action = action,
        textColor = textColor.value,
        background = backgroundColor.value,
        onClick = onClick
    )
}