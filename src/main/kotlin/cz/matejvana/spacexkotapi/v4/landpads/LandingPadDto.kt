package cz.matejvana.spacexkotapi.v4.landpads

import com.fasterxml.jackson.annotation.JsonProperty
import cz.matejvana.spacexkotapi.v4.Images

/**
 * Data class representing a landing pad in the SpaceX API.
 *
 * @property id The unique identifier of the landing pad.
 * @property name The name of the landing pad.
 * @property fullName The full name of the landing pad.
 * @property status The status of the landing pad.
 * @property type The type of the landing pad.
 * @property locality The locality of the landing pad.
 * @property region The region of the landing pad.
 * @property latitude The latitude of the landing pad.
 * @property longitude The longitude of the landing pad.
 * @property landingAttempts The number of landing attempts at the landing pad.
 * @property landingSuccesses The number of successful landings at the landing pad.
 * @property wikipedia The Wikipedia URL of the landing pad.
 * @property details Additional details about the landing pad.
 * @property launches The list of launches associated with the landing pad.
 * @property images The images related to the landing pad.
 */
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
)