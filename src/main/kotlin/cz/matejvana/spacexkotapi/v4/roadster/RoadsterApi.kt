package cz.matejvana.spacexkotapi.v4.roadster

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.request.PostRequest

class RoadsterApi(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val objectMapper: ObjectMapper
) {
    fun get(): RoadsterDto {
        val response = GetRequest(client)
            .append(apiVersion)
            .append("roadster")
            .execute()
        return objectMapper.readValue(response.body)
    }

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