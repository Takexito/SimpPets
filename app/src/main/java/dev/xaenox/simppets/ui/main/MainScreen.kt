package dev.xaenox.simppets.ui.main

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.xaenox.simppets.entities.Pet
import dev.xaenox.simppets.navigation.Navigation
import dev.xaenox.simppets.navigation.Navigator

@Composable
fun MainScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.White)
    ) {
        Toolbar(
            name = "Name",
            profileImageUri = Uri.EMPTY,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.217f)
        ) {
            Navigator.navigateTo(Navigation.Settings)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PetsList(
                pets = listOf(Pet.mock, Pet.mock, Pet.mock),
                modifier = Modifier
                    .fillMaxWidth(),
                onItemClick = { Navigator.navigateTo(Navigation.PetDetails(it)) },
                onAddPetItemClick = { Navigator.present(Navigation.AddPet)}
            )

            NavigationItems(
                modifier = Modifier.fillMaxWidth(),
                list = NavigationItem.list,
                onClick = {
                    when (it.name) {
                        "Календарь" -> {
                            Navigator.navigateTo(Navigation.Calendar)
                        }

                        "Карты" -> {
                            Navigator.navigateTo(Navigation.Map)
                        }

                        "Здоровье" -> {
                            Navigator.navigateTo(Navigation.Health)
                        }
                    }
                }
            )

            EventsBlock(
                event = Event("Event 1", "2022-01-01", "12:00", "Dog"),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
