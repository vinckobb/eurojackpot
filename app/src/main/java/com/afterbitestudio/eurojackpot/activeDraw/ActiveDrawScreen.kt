package com.afterbitestudio.eurojackpot.activeDraw

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.afterbitestudio.eurojackpot.ActiveDrawRoute
import com.afterbitestudio.eurojackpot.ui.theme.EurojackpotTheme
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ActiveDrawRoute(
    onAction: (ActiveDrawAction) -> Unit,
    viewModel: ActiveDrawViewModel = koinViewModel()
)
{
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ActiveDrawScreen(
        uiState = uiState,
        onAction = onAction,
    )
}

@Composable
fun ActiveDrawScreen(
    uiState: ActiveDrawUiState,
    onAction: (ActiveDrawAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        when (uiState) {
            ActiveDrawUiState.Loading ->
                Text(text = "Loading")
            is ActiveDrawUiState.ActiveDraw -> {
                val scrollableState = rememberLazyListState()
                LazyColumn(
                    modifier = Modifier
                        .padding(
                            horizontal = 24.dp
                        ),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    state = scrollableState,
                ) {
                    uiState.draws.forEach { draw ->
                        item(key = draw.id) {
                            Card {
                                Text(text = draw.id)
                            }
                        }
                    }
                }
            }
            is ActiveDrawUiState.Empty ->
                Text(text = "Empty")
        }
//        Button(
//            onClick = {
//                onAction(ActiveDrawAction.OnSomethingChange)
//            },
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)) {
//            Text(text = "Click")
//        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ActiveDrawScreenPreview(modifier: Modifier = Modifier) {
    EurojackpotTheme {
        ActiveDrawScreen(
            uiState = ActiveDrawUiState.Loading,
            onAction = {}
        )
    }

}