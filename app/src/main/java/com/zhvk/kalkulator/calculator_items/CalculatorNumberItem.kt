package com.zhvk.kalkulator.calculator_items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.zhvk.kalkulator.ui.theme.Gray
import com.zhvk.kalkulator.ui.theme.White

@Composable
fun CalculatorNumberItem(
    modifier: Modifier, action: String, onClick: () -> Unit
) {
    CalculatorItem(
        modifier = modifier,
        action = action,
        textSize = 32.sp,
        textColor = White,
        background = Gray,
        onClick = onClick
    )
}