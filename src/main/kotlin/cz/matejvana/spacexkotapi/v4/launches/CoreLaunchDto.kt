package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

data class CoreLaunchDto(
    @JsonProperty("core")
    val core: String? = null,

    @JsonProperty("flight")
    val flight: Int? = null,

    @JsonProperty("gridfins")
    val gridfins: Boolean? = null,

    @JsonProperty("legs")
    val legs: Boolean? = null,

    @JsonProperty("reused")
    val reused: Boolean? = null,

    @JsonProperty("landing_attempt")
    val landingAttempt: Boolean? = null,

    @JsonProperty("landing_success")
    val landingSuccess: Boolean? = null,

    @JsonProperty("landing_type")
    val landingType: String? = null,

    @JsonProperty("landpad")
    val landpad: String? = null
)