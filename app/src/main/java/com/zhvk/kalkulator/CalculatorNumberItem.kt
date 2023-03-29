package com.zhvk.kalkulator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhvk.kalkulator.ui.theme.Gray
import com.zhvk.kalkulator.ui.theme.White

@Composable
fun CalculatorNumberItem(
    modifier: Modifier, action: String, onClick: () -> Unit
) {
    CalculatorItem(
        modifier = modifier,
        action = action,
        textColor = White,
        background = Gray,
        onClick = onClick
    )
}