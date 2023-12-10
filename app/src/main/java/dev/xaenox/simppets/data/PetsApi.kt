package dev.xaenox.simppets.data

import dev.xaenox.simppets.entities.Pet
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpMethod

object PetsApi {
    private val client = KtorClient

    suspend fun fetchPets(): List<Pet> {
        val httpRequest = HttpRequestBuilder().apply {
            url("user/pets")
            method = HttpMethod.Get
        }

        return client.performRequest(httpRequest)
    }

    suspend fun createPet(pet: Pet): Pet {
        val httpRequest = HttpRequestBuilder().apply {
            url("user/pets/add")
            method = HttpMethod.Post
            setBody(pet)
        }

        return client.performRequest(httpRequest)
    }

    suspend fun updatePet(pet: Pet): Pet {
        val httpRequest = HttpRequestBuilder().apply {
            url("user/pets/update")
            method = HttpMethod.Put
            setBody(pet)
        }

        return client.performRequest(httpRequest)
    }

    suspend fun analyzeHealthInfo(healthInfo: Pet.HealthInfo): Pet.Status {
        val httpRequest = HttpRequestBuilder().apply {
            url("user/pet/status")
            method = HttpMethod.Post
            setBody(healthInfo)
        }

        return client.performRequest(httpRequest)
    }
}