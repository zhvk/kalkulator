package com.zhvk.kalkulator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zhvk.kalkulator.ui.theme.*

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp)
    ) {
        val itemSpacing = 16.dp

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(itemSpacing),
        ) {

            Text(
                text = "0",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 72.sp,
                fontWeight = FontWeight.Light,
                color = White,
                textAlign = TextAlign.End
            )

            // 1st row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "C",
                    textColor = Black,
                    background = Platinum,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "AC",
                    textColor = Black,
                    background = Platinum,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "+/-",
                    textColor = Black,
                    background = Platinum,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "/",
                    textColor = White,
                    background = Orange,
                    onClick = {})
            }

            // 2nd row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "7",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "8",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "9",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "X",
                    textColor = White,
                    background = Orange,
                    onClick = {})
            }

            // 3rd row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "4",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "5",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "6",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "-",
                    textColor = White,
                    background = Orange,
                    onClick = {})
            }

            // 4th row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "1",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "2",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "3",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "+",
                    textColor = White,
                    background = Orange,
                    onClick = {})
            }

            // 5th row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorItem(modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                    action = "0",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = ".",
                    textColor = White,
                    background = Gray,
                    onClick = {})
                CalculatorItem(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    action = "=",
                    textColor = White,
                    background = Orange,
                    onClick = {}
                )
            }
        }
    }
}