package cz.matejvana.spacexkotapi.v4

import com.fasterxml.jackson.databind.ObjectMapper
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.request.PaginatedResponse
import cz.matejvana.spacexkotapi.request.PostRequest

open class UniversalApi<T>(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val prefix: String,
    private val objectMapper: ObjectMapper,
    private val dtoClass: Class<T>
) {
    /**
     * Retrieves all items.
     *
     * @return A list of items.
     */
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

    /**
     * Retrieves an item by its ID.
     *
     * @param id The unique identifier of the item.
     * @return The item.
     */
    fun getById(id: String): T {
        val response = GetRequest(client)
            .append(apiVersion)
            .append(prefix)
            .append(id)
            .execute()
        return objectMapper.readValue(response.body, dtoClass)
    }

    /**
     * Queries items  based on the provided query parameters.
     *
     * @param query A map of query parameters.
     * @return A paginated response containing items.
     */
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