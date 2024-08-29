package com.afterbitestudio.eurojackpot.activeDraw.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afterbitestudio.eurojackpot.activeDraw.ActiveDrawRoute
import com.afterbitestudio.eurojackpot.activeDraw.ActiveDrawViewModel

const val ACTIVE_DRAW_ROUTE = "active_draw_route"

fun NavController.navigateToActiveDraw(navOptions: NavOptions) = navigate(ACTIVE_DRAW_ROUTE, navOptions)

fun NavGraphBuilder.drawHistoryScreen() {
    composable(
        route = ACTIVE_DRAW_ROUTE,
    ) {
        ActiveDrawRoute({})
    }
}