package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing a failure event in the SpaceX API.
 *
 * @property time The time of the failure event.
 * @property altitude The altitude at which the failure occurred.
 * @property reason The reason for the failure.
 */
data class FailureDto(
    @JsonProperty("time")
    val time: Int,

    @JsonProperty("altitude")
    val altitude: Int,

    @JsonProperty("reason")
    val reason: String
)