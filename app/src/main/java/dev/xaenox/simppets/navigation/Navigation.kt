package dev.xaenox.simppets.navigation

import dev.xaenox.simppets.entities.Id

sealed interface Navigation {
    data object Home : Navigation
    data object Calendar : Navigation
    data object Health : Navigation
    data object Settings : Navigation
    data object Map : Navigation
    data class PetDetails(val id: Id) : Navigation
    data object AddPet : Navigation
}