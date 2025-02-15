package cz.matejvana.spacexkotapi

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import cz.matejvana.spacexkotapi.v4.ClientV4
import java.net.http.HttpClient


open class SpaceXClient(val httpClient: HttpClient){

    var url: String = "https://api.spacexdata.com"
        private set

    companion object{
        fun createV4(): ClientV4 = ClientV4()
    }
}