package com.afterbitestudio.eurojackpot.statistics.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afterbitestudio.eurojackpot.drawHistory.DrawHistoryRoute

const val STATISTICS_ROUTE = "statistics_route"

fun NavController.navigateToStatistics(navOptions: NavOptions) = navigate(STATISTICS_ROUTE, navOptions)

fun NavGraphBuilder.statisticsScreen() {
    composable(
        route = STATISTICS_ROUTE,
    ) {
        DrawHistoryRoute({})
    }
}