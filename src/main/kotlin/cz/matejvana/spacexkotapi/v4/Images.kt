package cz.matejvana.spacexkotapi.v4

import com.fasterxml.jackson.annotation.JsonProperty

data class Images(
    @JsonProperty("large")
    val large: List<String>? = null
)