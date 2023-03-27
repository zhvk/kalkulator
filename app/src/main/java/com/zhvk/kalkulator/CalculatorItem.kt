package com.zhvk.kalkulator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorItem(
    modifier: Modifier, action: String, textColor: Color, background: Color, onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable { onClick() }
            .then(modifier),
        contentAlignment = Alignment.Center) {

        Text(
            text = action,
            color = textColor,
            fontSize = 32.sp
        )

    }
}