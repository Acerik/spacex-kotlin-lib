package cz.matejvana.spacexkotapi.v4.crew

import com.fasterxml.jackson.annotation.JsonProperty

data class CrewDto(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("agency")
    val agency: String? = null,

    @JsonProperty("image")
    val image: String? = null,

    @JsonProperty("wikipedia")
    val wikipedia: String? = null,

    @JsonProperty("launches")
    val launches: List<String>
) {
}