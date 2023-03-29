package com.zhvk.kalkulator.calculator_items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhvk.kalkulator.ui.theme.Black
import com.zhvk.kalkulator.ui.theme.Platinum

@Composable
fun CalculatorSecondaryOperationItem(
    modifier: Modifier, action: String, onClick: () -> Unit
) {
    CalculatorItem(
        modifier = modifier,
        action = action,
        textColor = Black,
        background = Platinum,
        onClick = onClick
    )
}