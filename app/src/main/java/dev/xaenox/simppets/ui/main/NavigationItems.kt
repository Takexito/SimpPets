package dev.xaenox.simppets.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

data class NavigationItem(val name: String, val color: Color, val icon: ImageVector) {
    companion object {
        val list = listOf(
            NavigationItem("Календарь", Color(0xFFE7F7FC), Icons.Filled.DateRange),
            NavigationItem("Карты", Color(0xFFF3F3F3), Icons.Outlined.Place),
            NavigationItem("Здоровье", Color(0xFFFCE8EF), Icons.Outlined.FavoriteBorder)
        )
    }
}

@Composable
fun NavigationItems(
    list: List<NavigationItem>,
    onClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        list.forEach { item ->
            NavigationItem(item, onClick)
        }
    }
}

@Preview
@Composable
fun NavigationItemsPreview() {
    NavigationItems(NavigationItem.list, {})
}