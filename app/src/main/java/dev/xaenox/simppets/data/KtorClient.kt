package dev.xaenox.simppets.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

object KtorClient {
    val client = HttpClient(Android) {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
        install(Auth) {
            bearer {
                loadTokens {
                    val token = UserRepository.currentToken.value ?: return@loadTokens null
                    BearerTokens(token.value, "refresh:${token.value}")
                }

                refreshTokens {
                    null
                    //BearerTokens("token", "refresh")
                }
            }
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
        }
    }

    suspend inline fun <reified T> performRequest(requestBuilder: HttpRequestBuilder): T {
        val response = client.request(requestBuilder)

        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body()
            }

            else -> {
                throw Exception("${response.status}: ${response.body<String>()}")
            }
        }
    }
}