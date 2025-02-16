package cz.matejvana.spacexkotapi.v4.roadster

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.request.PostRequest

/**
 * Class representing the Roadster API.
 *
 * @property client The SpaceX client used for making requests.
 * @property apiVersion The version of the API to use.
 * @property objectMapper The ObjectMapper for JSON serialization/deserialization.
 */
class RoadsterApi(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val objectMapper: ObjectMapper
) {
    /**
     * Retrieves the Roadster data.
     *
     * @return The Roadster data transfer object.
     */
    fun get(): RoadsterDto {
        val response = GetRequest(client)
            .append(apiVersion)
            .append("roadster")
            .execute()
        return objectMapper.readValue(response.body)
    }

    /**
     * Queries the Roadster data with specific parameters.
     *
     * @param query The query parameters as a map.
     * @return The Roadster data transfer object.
     */
    fun query(query: Map<String, Any>): RoadsterDto {
        val response = PostRequest(client)
            .setBody(objectMapper.writeValueAsString(query))
            .append(apiVersion)
            .append("roadster")
            .append("query")
            .execute()
        return objectMapper.readValue(response.body)
    }
}