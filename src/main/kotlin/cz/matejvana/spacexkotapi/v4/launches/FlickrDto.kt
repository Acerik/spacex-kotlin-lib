package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

data class FlickrDto(
    @JsonProperty("small")
    val small: List<String> = emptyList(),

    @JsonProperty("original")
    val original: List<String> = emptyList()
)