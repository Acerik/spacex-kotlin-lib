package cz.matejvana.spacexkotapi.v4

import com.fasterxml.jackson.databind.ObjectMapper
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.request.PostRequest

class UniversalApi<T>(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val prefix: String,
    private val objectMapper: ObjectMapper,
    private val dtoClass: Class<T>
) {

    fun getAll(): List<T> {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .execute()
        return objectMapper.readValue(
            response.body,
            objectMapper.typeFactory.constructCollectionType(List::class.java, dtoClass)
        )
    }

    fun getById(id: String): T {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append(id)
            .execute()
        return objectMapper.readValue(response.body, dtoClass)
    }

    fun query(query: Map<String, Any>): PaginatedResponse<T> {
        val response = PostRequest(client)
            .setBody(objectMapper.writeValueAsString(query))
            .append(apiVersion)
            .append("$prefix/query")
            .execute()
        return objectMapper.readValue(
            response.body,
            objectMapper.typeFactory.constructParametricType(PaginatedResponse::class.java, dtoClass)
        )
    }
}