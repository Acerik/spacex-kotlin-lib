package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

data class FailureDto(
    @JsonProperty("time")
    val time: Int,

    @JsonProperty("altitude")
    val altitude: Int,

    @JsonProperty("reason")
    val reason: String
)