package cz.matejvana.spacexkotapi.v4.company

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest

class CompanyApi(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val objectMapper: ObjectMapper
) {

    fun getAllInfo(): CompanyDto {
        val response = GetRequest(client)
            .append(apiVersion)
            .append("company")
            .execute()
        return objectMapper.readValue(response.body)
    }
}