package com.afterbitestudio.eurojackpot.drawEntry

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun AddDrawEntryTypeRoute()
{
    AddDrawEntryTypeScreen()
}

@Composable
fun AddDrawEntryTypeScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "TODO"
        )
    }
}