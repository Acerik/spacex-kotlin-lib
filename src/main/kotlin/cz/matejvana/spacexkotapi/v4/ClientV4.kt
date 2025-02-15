package cz.matejvana.spacexkotapi.v4

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.v4.capsules.CapsuleDto
import java.net.http.HttpClient

class ClientV4(httpClient: HttpClient = HttpClient.newHttpClient()) : SpaceXClient(httpClient) {


    private val objectMapper = jacksonObjectMapper()
    private val prefix = "v4"

    val capsules = UniversalApi(this, prefix, "capsules", objectMapper, CapsuleDto::class.java)

    fun check(): Boolean {
        val response = GetRequest(this).execute()
        return response.code == 200
    }
}