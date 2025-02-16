package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.databind.ObjectMapper
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.v4.UniversalApi

class LaunchesApi<T>(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val prefix: String,
    private val objectMapper: ObjectMapper,
    private val dtoClass: Class<T>
) : UniversalApi<T>(client, apiVersion, prefix, objectMapper, dtoClass) {

    fun latest(): T {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append("latest")
            .execute()
        return objectMapper.readValue(response.body, dtoClass)
    }

    fun next(): T {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append("next")
            .execute()
        return objectMapper.readValue(response.body, dtoClass)
    }

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