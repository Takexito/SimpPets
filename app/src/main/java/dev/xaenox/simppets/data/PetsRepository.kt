package dev.xaenox.simppets.data

import dev.xaenox.simppets.entities.Pet
import kotlinx.coroutines.flow.MutableStateFlow

object PetsRepository {
    val pets = MutableStateFlow<List<Pet>>(emptyList())

    suspend fun fetchPets() {
        val pets = PetsApi.fetchPets()
        this.pets.value = pets
    }

    suspend fun createPet(pet: Pet) {
        PetsApi.createPet(pet)
        fetchPets()
    }

    suspend fun updatePet(pet: Pet) {
        PetsApi.updatePet(pet)
        fetchPets()
    }

    suspend fun analyzeHealthInfo(healthInfo: Pet.HealthInfo): Pet.Status {
        return PetsApi.analyzeHealthInfo(healthInfo)
    }
}