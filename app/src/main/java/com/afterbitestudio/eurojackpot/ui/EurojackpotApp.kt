package com.afterbitestudio.eurojackpot.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.afterbitestudio.eurojackpot.R

@Composable
fun EurojackpotApp(
    modifier: Modifier = Modifier,
) {
    EurojackpotApp(
        test = stringResource(id = R.string.app_name),
        modifier = modifier)
}

@Composable
internal fun EurojackpotApp(
    test: String,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {

        }
        Text(text = test)
    }
}