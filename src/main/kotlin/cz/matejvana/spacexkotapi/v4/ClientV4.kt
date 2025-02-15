package cz.matejvana.spacexkotapi.v4

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.v4.dto.response.capsules.CapsuleDto
import java.net.http.HttpClient

class ClientV4(httpClient: HttpClient = HttpClient.newHttpClient()) : SpaceXClient(httpClient) {


    fun check(): Boolean {
        val response = GetRequest(this).execute()
        return response.code == 200
    }
}