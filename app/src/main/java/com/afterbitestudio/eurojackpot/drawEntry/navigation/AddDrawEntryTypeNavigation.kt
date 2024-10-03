package com.afterbitestudio.eurojackpot.drawEntry.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.afterbitestudio.eurojackpot.drawEntry.AddDrawEntryTypeRoute

const val ADD_DRAW_ENTRY_TYPE_ROUTE = "add_draw_entry_type_route"

fun NavController.navigateToAddDrawEntryType(navOptions: NavOptions? = null) = navigate(ADD_DRAW_ENTRY_TYPE_ROUTE, navOptions)

fun NavGraphBuilder.addDrawEntryTypeScreen() {
    composable(
        route = ADD_DRAW_ENTRY_TYPE_ROUTE,
    ) {
        AddDrawEntryTypeRoute()
    }
}