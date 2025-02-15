package cz.matejvana.spacexkotapi.request

import cz.matejvana.spacexkotapi.SpaceXClient
import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class PostRequest(client: SpaceXClient) : GeneralRequest(client) {

    private var body: String = ""

    fun setBody(body: String): PostRequest {
        this.body = body
        return this
    }

    override fun execute(): GetResponse {
        val url = getEntireUrl()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .header("Content-Type", "application/json")
            .build()
        val response = client.httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        return GetResponse(response.statusCode(), response.body())
    }
}