package dev.xaenox.simppets.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.xaenox.simppets.data.PetsRepository
import dev.xaenox.simppets.data.UserRepository
import dev.xaenox.simppets.entities.Email
import dev.xaenox.simppets.entities.Password
import dev.xaenox.simppets.ui.add_pet.AddPetScreen
import dev.xaenox.simppets.ui.calendar.CalendarScreen
import dev.xaenox.simppets.ui.health.HealthInfoScreen
import dev.xaenox.simppets.ui.main.MainScreen
import dev.xaenox.simppets.ui.maps.MapsUI
import kotlinx.coroutines.launch

@Composable
fun NavHost(currentScreen: Navigation, presentScreen: Navigation?, modifier: Modifier = Modifier) {
    LaunchedEffect(key1 = Unit) {
        UserRepository.auth(Email("lol"), Password("123"))
    }

    NavHost(modifier = Modifier.fillMaxSize(), currentScreen = currentScreen)

    if (presentScreen != null) {
        Box(
            modifier = modifier.background(Color.Black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            NavHost(
                currentScreen = presentScreen,
                modifier = Modifier
                    .padding(vertical = 32.dp)
                    .matchParentSize()
            )
        }
    }
}

@Composable
fun NavHost(currentScreen: Navigation, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    when (currentScreen) {
        Navigation.Calendar -> CalendarScreen()

        Navigation.Health -> HealthInfoScreen(modifier)

        Navigation.Home -> MainScreen()
        Navigation.Map -> MapsUI(modifier)

        Navigation.Settings -> Box(
            modifier = modifier
                .background(Color.Gray)
        )

        Navigation.AddPet -> AddPetScreen(modifier, { Navigator.navigateBack() }) {
            scope.launch {
                try {
                    PetsRepository.createPet(it)
                    Navigator.navigateTo(Navigation.PetDetails(it.id))
                } catch (e: Exception) {
                    println(e)
                }
            }
        }

        is Navigation.PetDetails -> Box(
            modifier = modifier
                .background(Color.Blue)
        )
    }
}
