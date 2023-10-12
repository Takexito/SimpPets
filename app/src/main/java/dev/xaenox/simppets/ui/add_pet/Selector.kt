package dev.xaenox.simppets.ui.add_pet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Selector(
    modifier: Modifier = Modifier,
    label: String,
    @DrawableRes icon1: Int,
    @DrawableRes icon2: Int,
    @DrawableRes selectedIcon: Int,
    onIconSelected: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            color = Color(0xFFC6C6C8)
        )

        Icon(
            painter = painterResource(id = icon1),
            contentDescription = "Element 1",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
                .clickable { onIconSelected(icon1) },
            tint = if (icon1 == selectedIcon) Color.Black else Color(0xFFD9D9D9)
        )

        Icon(
            painter = painterResource(id = icon2),
            contentDescription = "Element 2",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
                .clickable { onIconSelected(icon2) },
            tint = if (icon2 == selectedIcon) Color.Black else Color(0xFFD9D9D9)
        )
    }
}
