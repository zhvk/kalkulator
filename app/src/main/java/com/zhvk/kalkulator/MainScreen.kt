package com.zhvk.kalkulator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zhvk.kalkulator.ui.theme.Black
import com.zhvk.kalkulator.ui.theme.Orange
import com.zhvk.kalkulator.ui.theme.White

@Composable
fun MainScreen(
    viewModel: CalculatorViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
                text = uiState.displayedValue,
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
                CalculatorSecondaryOperationItem(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    action = "C",
                    onClick = {})
                CalculatorSecondaryOperationItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "AC",
                    onClick = {})
                CalculatorSecondaryOperationItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "+/-",
                    onClick = {})
                CalculatorOperationItem(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    action = "/",
                    onClick = { viewModel.setOperation("/") },
                    viewModel.getOperation()
                )
            }

            // 2nd row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "7",
                    onClick = { viewModel.typeNumber('7') })
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "8",
                    onClick = { viewModel.typeNumber('8') })
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "9",
                    onClick = { viewModel.typeNumber('9') })
                CalculatorOperationItem(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    action = "X",
                    onClick = { viewModel.setOperation("X") },
                    viewModel.getOperation()
                )
            }

            // 3rd row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "4",
                    onClick = { viewModel.typeNumber('4') })
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "5",
                    onClick = { viewModel.typeNumber('5') })
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "6",
                    onClick = { viewModel.typeNumber('6') })
                CalculatorOperationItem(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    action = "-",
                    onClick = { viewModel.setOperation("-") },
                    viewModel.getOperation()
                )
            }

            // 4th row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "1",
                    onClick = { viewModel.typeNumber('1') })
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "2",
                    onClick = { viewModel.typeNumber('2') })
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "3",
                    onClick = { viewModel.typeNumber('3') })
                CalculatorOperationItem(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    action = "+",
                    onClick = { viewModel.setOperation("+") },
                    selectedOperation = viewModel.getOperation()
                )
            }

            // 5th row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                    action = "0",
                    onClick = { viewModel.typeNumber('0') })
                CalculatorNumberItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = ".",
                    onClick = { viewModel.typeNumber('.') })
                CalculatorItem(modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                    action = "=",
                    textColor = White,
                    background = Orange,
                    onClick = { viewModel.calculate() })
            }
        }
    }
}