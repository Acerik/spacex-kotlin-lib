package cz.matejvana.spacexkotapi.v4

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing a collection of image URLs.
 *
 * @property large A list of large image URLs.
 */
data class Images(
    @JsonProperty("large")
    val large: List<String>? = null
)