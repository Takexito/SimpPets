package dev.xaenox.simppets.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.xaenox.simppets.entities.Id
import dev.xaenox.simppets.entities.Pet
import dev.xaenox.simppets.ui.utils.getItemWidthForItemCountDp

@Composable
fun PetsList(
    pets: List<Pet>,
    modifier: Modifier = Modifier,
    onItemClick: (Id) -> Unit,
    onAddPetItemClick: () -> Unit
) {
    val lazyListState = rememberLazyListState()

    Column(modifier = modifier) {
        Text(
            "Мои питомцы",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF320071)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            LazyRow(
                state = lazyListState,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                itemsIndexed(pets) { index, pet ->
                    PetItem(pet, index == 0) {
                        onItemClick(pet.id)
                    }
                }

                item {
                    AddPetItem(Modifier.alpha(0f)) {}
                }
            }

            AddPetItem(Modifier.align(Alignment.CenterEnd), onAddPetItemClick)
        }
    }
}

@Composable
fun AddPetItem(modifier: Modifier = Modifier, onAddPetItemClick: () -> Unit) {
    val width = getItemWidthForItemCountDp(fixedWidth = 24 * 3 + 8 * 4, itemCount = 3)
    val widthPx = LocalDensity.current.run { width.toPx() }

    Card(
        modifier = modifier
            .width(width)
            .aspectRatio(0.61f)
            .clickable { onAddPetItemClick() },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            HorizontalGradient(
                listOfColors = listOf(Color(0xFFD0CFFC), Color(0xFFF3F3F3)),
                startX = widthPx * 0f,
                modifier = Modifier.matchParentSize()
            )
            Icon(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                imageVector = Icons.Filled.AddCircle,
                tint = Color.White,
                contentDescription = "Pet Image"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PetsListPreview() {
    PetsList(listOf(Pet.mock, Pet.mock), Modifier, {}) {}
}