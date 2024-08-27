package com.afterbitestudio.eurojackpot.activeDraw

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afterbitestudio.eurojackpot.ActiveDrawRoute
import com.afterbitestudio.eurojackpot.ui.theme.EurojackpotTheme

@Composable
internal fun ActiveDrawRoute(onAction: (ActiveDrawAction) -> Unit)
{
    ActiveDrawScreen(
        state = ActiveDrawState(),
        onAction = onAction,
    )
}

@Composable
fun ActiveDrawScreen(
    state: ActiveDrawState,
    onAction: (ActiveDrawAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = state.name
        )
        Button(
            onClick = {
                onAction(ActiveDrawAction.OnSomethingChange)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)) {
            Text(text = "Click")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ActiveDrawScreenPreview(modifier: Modifier = Modifier) {
    EurojackpotTheme {
        ActiveDrawScreen(
            state = ActiveDrawState(
                name = "Test"
            ),
            onAction = {}
        )
    }

}