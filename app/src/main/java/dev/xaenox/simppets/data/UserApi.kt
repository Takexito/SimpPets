package dev.xaenox.simppets.data

import dev.xaenox.simppets.entities.Email
import dev.xaenox.simppets.entities.Password
import dev.xaenox.simppets.entities.Token
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpMethod

object UserApi {
    private val client = KtorClient

    suspend fun auth(email: Email, password: Password): Token {
        val httpRequest = HttpRequestBuilder().apply {
            url("/auth")
            setBody(Pair(email.value, password.value))
            method = HttpMethod.Post
        }

        return client.performRequest(httpRequest)
    }
}