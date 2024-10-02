package com.afterbitestudio.eurojackpot.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.afterbitestudio.eurojackpot.activeDraw.navigation.ACTIVE_DRAW_ROUTE
import com.afterbitestudio.eurojackpot.activeDraw.navigation.drawHistoryScreen
import com.afterbitestudio.eurojackpot.drawHistory.navigation.activeDrawScreen
import com.afterbitestudio.eurojackpot.settings.navigation.settingsScreen
import com.afterbitestudio.eurojackpot.statistics.navigation.statisticsScreen
import com.afterbitestudio.eurojackpot.ui.EurojackpotAppState

@Composable
fun EurojackpotNavHost(
    appState: EurojackpotAppState,
    modifier: Modifier = Modifier,
    startDestination: String = ACTIVE_DRAW_ROUTE,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        activeDrawScreen()
        drawHistoryScreen()
        statisticsScreen()
        settingsScreen()
    }
}