package com.afterbitestudio.eurojackpot.designsystem.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.only
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collection.MutableVector
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

private val NoWindowInsets = WindowInsets(0, 0, 0, 0)

internal val WindowAdaptiveInfoDefault
    @Composable get() = currentWindowAdaptiveInfo()

private interface NavigationSuiteItemProvider {
    val itemsCount: Int
    val itemList: MutableVector<NavigationSuiteItem>
    val middleIndex: Int
}

private class NavigationSuiteItem(
    val selected: Boolean,
    val onClick: () -> Unit,
    val icon: @Composable () -> Unit,
    val modifier: Modifier,
    val enabled: Boolean,
    val label: @Composable (() -> Unit)?,
    val alwaysShowLabel: Boolean,
    val badge: (@Composable () -> Unit)?,
    val colors: NavigationSuiteItemColors?,
    val interactionSource: MutableInteractionSource?
)

sealed interface NavigationSuiteScope {
    fun item(
        selected: Boolean,
        onClick: () -> Unit,
        icon: @Composable () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        label: @Composable (() -> Unit)? = null,
        alwaysShowLabel: Boolean = true,
        badge: (@Composable () -> Unit)? = null,
        colors: NavigationSuiteItemColors? = null,
        interactionSource: MutableInteractionSource? = null
    )
}

private class NavigationSuiteScopeImpl : NavigationSuiteScope, NavigationSuiteItemProvider {

    override fun item(
        selected: Boolean,
        onClick: () -> Unit,
        icon: @Composable () -> Unit,
        modifier: Modifier,
        enabled: Boolean,
        label: @Composable (() -> Unit)?,
        alwaysShowLabel: Boolean,
        badge: (@Composable () -> Unit)?,
        colors: NavigationSuiteItemColors?,
        interactionSource: MutableInteractionSource?
    ) {
        itemList.add(NavigationSuiteItem(
                selected = selected,
                onClick = onClick,
                icon = icon,
                modifier = modifier,
                enabled = enabled,
                label = label,
                alwaysShowLabel = alwaysShowLabel,
                badge = badge,
                colors = colors,
                interactionSource = interactionSource
            )
        )
    }

    override val itemList: MutableVector<NavigationSuiteItem> = mutableVectorOf()

    override val itemsCount: Int
        get() = itemList.size

    override val middleIndex: Int
        get() = (itemList.size+1)/2
}

@Composable
fun EurojackpotNavigationSuiteScaffold(
    navigationSuiteItems: NavigationSuiteScope.() -> Unit,
    modifier: Modifier = Modifier,
    floatingActionButton: @Composable (() -> Unit)? = null,
    layoutType: NavigationSuiteType =
        NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(WindowAdaptiveInfoDefault),
    content: @Composable () -> Unit = {},
) {
    Surface(
        modifier = modifier
    ) {
        NavigationSuiteScaffoldLayout(
            navigationSuite = {
                EurojackpotNavigationSuite(
                    floatingActionButton = floatingActionButton,
                    content = navigationSuiteItems,
                )
            },
            layoutType = layoutType,
            content = {
                Box(
                    Modifier.consumeWindowInsets(
                        when (layoutType) {
                            NavigationSuiteType.NavigationBar ->
                                NavigationBarDefaults.windowInsets.only(WindowInsetsSides.Bottom)
                            NavigationSuiteType.NavigationRail ->
                                NavigationRailDefaults.windowInsets.only(WindowInsetsSides.Start)
                            NavigationSuiteType.NavigationDrawer ->
                                DrawerDefaults.windowInsets.only(WindowInsetsSides.Start)
                            else -> NoWindowInsets
                        }
                    )
                ) {
                    content()
                }
            }
        )
    }
}

@Composable
fun EurojackpotNavigationSuite(
    modifier: Modifier = Modifier,
    floatingActionButton: @Composable (() -> Unit)? = null,
    layoutType: NavigationSuiteType =
        NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(WindowAdaptiveInfoDefault),
    content: NavigationSuiteScope.() -> Unit,
) {
    val scope by rememberStateOfItems(content)

    EurojackpotNavigationBar(
        modifier = modifier,
    ) {
        scope.itemList.forEachIndexed { index, it ->
            if (floatingActionButton != null && index == scope.middleIndex) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center,
                ) {
                    floatingActionButton()
                }
            }
            Surface(
                modifier = Modifier.weight(1f),
                onClick = it.onClick
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    it.label?.invoke()
                }
            }
            if (floatingActionButton != null && index == scope.itemsCount-1 && scope.itemsCount % 2 == 1) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center,
                ) {}
            }
        }
    }
}

@Composable
private fun rememberStateOfItems(
    content: NavigationSuiteScope.() -> Unit
): State<NavigationSuiteItemProvider> {
    val latestContent = rememberUpdatedState(content)
    return remember { derivedStateOf { NavigationSuiteScopeImpl().apply(latestContent.value) } }
}