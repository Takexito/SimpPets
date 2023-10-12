package dev.xaenox.simppets.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.xaenox.simppets.ui.utils.getItemWidthForItemCountDp

@Composable
fun NavigationItem(item: NavigationItem, onClick: (NavigationItem) -> Unit) {
    val itemWidth = getItemWidthForItemCountDp(fixedWidth = 24 * 2 + 8 * 2, itemCount = 3)
    // TODO: change shape
    Card(
        modifier = Modifier
            .width(itemWidth)
            .aspectRatio(1f)
            .padding(8.dp)
            .clickable { onClick(item) },
        colors = CardDefaults.cardColors(containerColor = item.color)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp),
                imageVector = item.icon,
                contentDescription = "Navigation item"
            )

            Text(
                text = item.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
private fun NavigationItemPreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        NavigationItem.list.forEach {
            NavigationItem(it, {})
        }
    }
}