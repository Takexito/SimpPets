package dev.xaenox.simppets.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.xaenox.simppets.entities.Pet
import dev.xaenox.simppets.ui.utils.getItemWidthForItemCountDp

@Composable
fun PetItem(
    pet: Pet,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val width = getItemWidthForItemCountDp(fixedWidth = 24 * 3 + 8 * 4, itemCount = 3)
    val widthPx = LocalDensity.current.run { width.toPx() }
    val scale = if (isSelected) 1.2f else 1f

    Card(
        modifier = modifier
            .width(width * scale)
            .aspectRatio(0.61f)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(modifier = Modifier) {
            HorizontalGradient(
                listOfColors = listOf(Color(0xFFD0CFFC), Color(0xFFF3F3F3)),
                startX = widthPx * 0f,
                modifier = Modifier.matchParentSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(64.dp)
                        .border(
                            border = BorderStroke(2.dp, Color(0xFFCFCEFB)),
                            shape = CircleShape
                        )
                        .clip(CircleShape),
                    model = pet.photoUrl,
                    contentDescription = null,
                    error = rememberVectorPainter(
                        image = Icons.Filled.Face,
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = pet.name,
                    fontSize = 20.sp,
                    color = Color(0xFF320071),
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                )

                Text(
                    text = pet.type.name,
                    modifier = Modifier,
                    color = Color(0xD6444242),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                )

                if (isSelected) {
                    Text(
                        text = pet.birthDate,
                        modifier = Modifier,
                        color = Color(0xD6444242),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }

                if (isSelected) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.End)
                            .size(24.dp)
                            .background(Color.White, CircleShape),
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Open pet card"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PetItemPreview() {
    PetItem(Pet.mock, true) {}
}

@Preview
@Composable
private fun PetItemNotSelectedPreview() {
    PetItem(Pet.mock, false) {}
}