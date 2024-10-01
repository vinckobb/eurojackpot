package com.afterbitestudio.eurojackpot.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.afterbitestudio.eurojackpot.R
import com.afterbitestudio.eurojackpot.designsystem.component.EurojackpotNavigationSuiteScaffold
import com.afterbitestudio.eurojackpot.designsystem.component.EurojackpotTopAppBar
import com.afterbitestudio.eurojackpot.navigation.EurojackpotNavHost
import com.afterbitestudio.eurojackpot.navigation.TopLevelDestination

@Composable
fun EurojackpotApp(
    appState: EurojackpotAppState,
    modifier: Modifier = Modifier,
) {
    EurojackpotApp(
        appState = appState,
        test = stringResource(id = R.string.app_name),
        modifier = modifier)
}

@Composable
internal fun EurojackpotApp(
    appState: EurojackpotAppState,
    test: String,
    modifier: Modifier = Modifier,
) {
    val currentDestination = appState.currentDestination

    EurojackpotNavigationSuiteScaffold(
        navigationSuiteItems = {
            appState.topLevelDestinations.forEach { destination ->
                val selected = currentDestination
                    .isTopLevelDestinationInHierarchy(destination)
                item(
                    icon = {
                        Icon(
                            imageVector = destination.unselectedIcon,
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = destination.iconTextId)
                        )
                    },
                    selected = selected,
                    onClick = { appState.navigateToTopLevelDestination(destination) }
                )
            }
        },
        floatingActionButton = {
            IconButton(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.Red),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        Scaffold(
            modifier = modifier,
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    )
            ) {
                val destination = appState.currentTopLevelDestination

                if (destination != null) {
                    EurojackpotTopAppBar(
                        titleRes = destination.titleTextId,
                    )
                }

                Box(
                    // Workaround for https://issuetracker.google.com/338478720
                    modifier = Modifier.consumeWindowInsets(
                        WindowInsets(0, 0, 0, 0)
                    ),
                ) {
                    EurojackpotNavHost(
                        appState = appState,
                    )
                }
            }
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false