package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing the mission patch information.
 *
 * @property small URL to the small version of the mission patch.
 * @property large URL to the large version of the mission patch.
 */
data class PatchDto(
    @JsonProperty("small")
    val small: String? = null,

    @JsonProperty("large")
    val large: String? = null
)