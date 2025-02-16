package cz.matejvana.spacexkotapi.v4

import LaunchPadDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import cz.matejvana.spacexkotapi.SpaceXClient
import cz.matejvana.spacexkotapi.request.GetRequest
import cz.matejvana.spacexkotapi.v4.capsules.CapsuleDto
import cz.matejvana.spacexkotapi.v4.company.CompanyApi
import cz.matejvana.spacexkotapi.v4.cores.CoreDto
import cz.matejvana.spacexkotapi.v4.crew.CrewDto
import cz.matejvana.spacexkotapi.v4.dragons.DragonDto
import cz.matejvana.spacexkotapi.v4.history.HistoryDto
import cz.matejvana.spacexkotapi.v4.landpads.LandingPadDto
import cz.matejvana.spacexkotapi.v4.payloads.PayloadDto
import cz.matejvana.spacexkotapi.v4.roadster.RoadsterApi
import java.net.http.HttpClient

class ClientV4(httpClient: HttpClient = HttpClient.newHttpClient()) : SpaceXClient(httpClient) {


    private val objectMapper = jacksonObjectMapper()
    private val prefix = "v4"

    val capsules = UniversalApi(this, prefix, "capsules", objectMapper, CapsuleDto::class.java)
    val company = CompanyApi(this, prefix, objectMapper)
    val cores = UniversalApi(this, prefix, "cores", objectMapper, CoreDto::class.java)
    val crew = UniversalApi(this, prefix, "crew", objectMapper, CrewDto::class.java)
    val dragons = UniversalApi(this, prefix, "dragons", objectMapper, DragonDto::class.java)
    val history = UniversalApi(this, prefix, "history", objectMapper, HistoryDto::class.java)
    val landPads = UniversalApi(this, prefix, "landpads", objectMapper, LandingPadDto::class.java)
    val launchPads = UniversalApi(this, prefix, "launchpads", objectMapper, LaunchPadDto::class.java)
    val payloads = UniversalApi(this, prefix, "payloads", objectMapper, PayloadDto::class.java)
    val roadster = RoadsterApi(this, prefix, objectMapper)
    //todo launches

    fun check(): Boolean {
        val response = GetRequest(this).execute()
        return response.code == 200
    }
}