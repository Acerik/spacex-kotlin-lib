package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

data class PatchDto(
    @JsonProperty("small")
    val small: String? = null,

    @JsonProperty("large")
    val large: String? = null
)