package com.afterbitestudio.eurojackpot.drawHistory.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afterbitestudio.eurojackpot.drawHistory.DrawHistoryRoute

const val DRAW_HISTORY_ROUTE = "draw_history_route"

fun NavController.navigateToDrawHistory(navOptions: NavOptions) = navigate(DRAW_HISTORY_ROUTE, navOptions)

fun NavGraphBuilder.activeDrawScreen() {
    composable(
        route = DRAW_HISTORY_ROUTE,
    ) {
        DrawHistoryRoute({})
    }
}