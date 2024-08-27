package com.afterbitestudio.eurojackpot.drawHistory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afterbitestudio.eurojackpot.ui.theme.EurojackpotTheme

@Composable
internal fun DrawHistoryRoute(onAction: (DrawHistoryAction) -> Unit)
{
    DrawHistoryScreen(
        state = DrawHistoryState("History"),
        onAction = onAction,
    )
}

@Composable
fun DrawHistoryScreen(
    state: DrawHistoryState,
    onAction: (DrawHistoryAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = state.something
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DrawHistoryScreenPreview() {
    EurojackpotTheme {
        DrawHistoryScreen(
            DrawHistoryState(
                something = "History",
            ),
            onAction = {}
        )
    }
}