package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty


data class FairingsDto(
    @JsonProperty("reused")
    val reused: Boolean? = null,

    @JsonProperty("recovery_attempt")
    val recoveryAttempt: Boolean? = null,

    @JsonProperty("recovered")
    val recovered: Boolean? = null,

    @JsonProperty("ships")
    val ships: List<String> = emptyList()
)