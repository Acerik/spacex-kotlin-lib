package cz.matejvana.spacexkotapi

import cz.matejvana.spacexkotapi.v4.SpaceXClientV4
import java.net.http.HttpClient


open class SpaceXClient(val httpClient: HttpClient) {

    var url: String = "https://api.spacexdata.com"
        private set

    companion object {
        fun createV4(): SpaceXClientV4 = SpaceXClientV4()
    }
}