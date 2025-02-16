package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing the core launch details in the SpaceX API.
 *
 * @property core The unique identifier of the core.
 * @property flight The flight number of the core.
 * @property gridfins Whether the core has grid fins.
 * @property legs Whether the core has landing legs.
 * @property reused Whether the core is reused.
 * @property landingAttempt Whether there was a landing attempt.
 * @property landingSuccess Whether the landing was successful.
 * @property landingType The type of landing.
 * @property landpad The identifier of the landing pad.
 */
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