package cz.matejvana.spacexkotapi.v4.company

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest

/**
 * API class for retrieving company information from the SpaceX API.
 *
 * @property client The SpaceX client used to make requests.
 * @property apiVersion The version of the API to use.
 * @property objectMapper The ObjectMapper used for JSON serialization/deserialization.
 */
class CompanyApi(
    private val client: SpaceXClient,
    private val apiVersion: String,
    private val objectMapper: ObjectMapper
) {

    /**
     * Retrieves all company information.
     *
     * @return A cz.matejvana.spacexkotapi.v4.company.CompanyDto object containing the company information.
     */
    fun getAllInfo(): CompanyDto {
        val response = GetRequest(client)
            .append(apiVersion)
            .append("company")
            .execute()
        return objectMapper.readValue(response.body)
    }
}