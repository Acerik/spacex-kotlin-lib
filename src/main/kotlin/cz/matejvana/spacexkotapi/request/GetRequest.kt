package cz.matejvana.spacexkotapi.request

import cz.matejvana.spacexkotapi.SpaceXClient
import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GetRequest(client: SpaceXClient) : GeneralRequest(client) {

    override fun execute(): GetResponse {
        val url = getEntireUrl()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build()
        val response = client.httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return GetResponse(response.statusCode(), response.body())
    }
}