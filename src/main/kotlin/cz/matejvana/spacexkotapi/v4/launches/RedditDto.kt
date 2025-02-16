package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

data class RedditDto(
    @JsonProperty("campaign")
    val campaign: String? = null,

    @JsonProperty("launch")
    val launch: String? = null,

    @JsonProperty("media")
    val media: String? = null,

    @JsonProperty("recovery")
    val recovery: String? = null
)