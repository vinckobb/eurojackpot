package com.afterbitestudio.eurojackpot.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.afterbitestudio.eurojackpot.R
import com.afterbitestudio.eurojackpot.designsystem.icon.EurojackpotIcons

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    ACTIVE_DRAW(
        selectedIcon = EurojackpotIcons.ActiveDraw,
        unselectedIcon = EurojackpotIcons.ActiveDraw,
        iconTextId = R.string.active_title,
        titleTextId = R.string.active_draw_title,
    ),
    DRAW_HISTORY(
    selectedIcon = EurojackpotIcons.DrawHistory,
    unselectedIcon = EurojackpotIcons.DrawHistory,
    iconTextId = R.string.history_title,
    titleTextId = R.string.draw_history_title,
    ),
//    STATISTICS(
//        selectedIcon = EurojackpotIcons.Statistics,
//        unselectedIcon = EurojackpotIcons.Statistics,
//        iconTextId = R.string.statistics_title,
//        titleTextId = R.string.statistics_title,
//    ),
//    PROFILE(
//        selectedIcon = EurojackpotIcons.Profile,
//        unselectedIcon = EurojackpotIcons.Profile,
//        iconTextId = R.string.profile_title,
//        titleTextId = R.string.profile_title,
//    )
}