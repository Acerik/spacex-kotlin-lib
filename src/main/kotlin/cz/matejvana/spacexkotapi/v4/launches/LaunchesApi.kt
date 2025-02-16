package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.databind.ObjectMapper
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.v4.UniversalApi

/**
 * API class for accessing SpaceX launch data.
 *
 * @param T The type of the DTO class.
 * @property client The SpaceX client used for making requests.
 * @property apiVersion The version of the API to use.
 * @property prefix The prefix for the API endpoints.
 * @property objectMapper The ObjectMapper for JSON deserialization.
 * @property dtoClass The class of the DTO to deserialize the response into.
 */
class LaunchesApi<T>(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val prefix: String,
    private val objectMapper: ObjectMapper,
    private val dtoClass: Class<T>
) : UniversalApi<T>(client, apiVersion, prefix, objectMapper, dtoClass) {
    /**
     * Fetches the latest launch data.
     *
     * @return The latest launch data.
     */
    fun latest(): T {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append("latest")
            .execute()
        return objectMapper.readValue(response.body, dtoClass)
    }

    /**
     * Fetches the next launch data.
     *
     * @return The next launch data.
     */
    fun next(): T {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append("next")
            .execute()
        return objectMapper.readValue(response.body, dtoClass)
    }

    /**
     * Fetches the past launches data.
     *
     * @return A list of past launches data.
     */
    fun past(): List<T> {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append("past")
            .execute()
        return objectMapper.readValue(
            response.body,
            objectMapper.typeFactory.constructCollectionType(List::class.java, dtoClass)
        )
    }

    /**
     * Fetches the upcoming launches data.
     *
     * @return A list of upcoming launches data.
     */
    fun upcoming(): List<T> {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append("upcoming")
            .execute()
        return objectMapper.readValue(
            response.body,
            objectMapper.typeFactory.constructCollectionType(List::class.java, dtoClass)
        )
    }
}