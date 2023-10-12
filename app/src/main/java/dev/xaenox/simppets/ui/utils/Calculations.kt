package dev.xaenox.simppets.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun getItemWidthForItemCountDp(fixedWidth: Int, itemCount: Int): Dp {
    return getItemWidthForItemCount(
        LocalConfiguration.current.screenWidthDp.dp,
        fixedWidth,
        itemCount
    )
}

fun getItemWidthForItemCount(screenWidth: Dp, fixedWidth: Int, itemCount: Int): Dp {
    return (screenWidth - (fixedWidth.dp)) / itemCount
}