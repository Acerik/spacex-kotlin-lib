package cz.matejvana.spacexkotapi.request

import cz.matejvana.spacexkotapi.SpaceXClient

abstract class GeneralRequest(protected val client: SpaceXClient) {

    protected var requestUrl : String = client.url
    protected val parameters: MutableMap<String, String> = mutableMapOf()

    fun append(part: String): GeneralRequest {
        val normalizedPart = part.trimStart('/').trimEnd('/')
        requestUrl = "${requestUrl.trimEnd('/')}/$normalizedPart"
        return this
    }

    fun addParameter(name: String, value: String): GeneralRequest {
        parameters[name] = value
        return this
    }

    protected fun getEntireUrl(): String {
        if(parameters.isEmpty()) return requestUrl
        val params = parameters.map { "${it.key}=${it.value}" }.joinToString("&")
        return "$requestUrl?$params"
    }

    abstract fun execute(): GetResponse
}