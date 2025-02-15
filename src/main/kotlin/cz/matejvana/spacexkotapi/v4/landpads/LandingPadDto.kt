package cz.matejvana.spacexkotapi.v4.landpads

import com.fasterxml.jackson.annotation.JsonProperty

data class LandingPadDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("full_name")
    val fullName: String? = null,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("type")
    val type: String? = null,

    @JsonProperty("locality")
    val locality: String? = null,

    @JsonProperty("region")
    val region: String? = null,

    @JsonProperty("latitude")
    val latitude: Double? = null,

    @JsonProperty("longitude")
    val longitude: Double? = null,

    @JsonProperty("landing_attempts")
    val landingAttempts: Int = 0,

    @JsonProperty("landing_successes")
    val landingSuccesses: Int = 0,

    @JsonProperty("wikipedia")
    val wikipedia: String? = null,

    @JsonProperty("details")
    val details: String? = null,

    @JsonProperty("launches")
    val launches: List<String> = emptyList(),

    @JsonProperty("images")
    val images: Images? = null
) {
    data class Images(
        @JsonProperty("large")
        val large: List<String>? = null
    )
}