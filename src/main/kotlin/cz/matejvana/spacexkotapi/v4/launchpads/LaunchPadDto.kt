package cz.matejvana.spacexkotapi.v4.launchpads

import com.fasterxml.jackson.annotation.JsonProperty
import cz.matejvana.spacexkotapi.v4.Images

/**
 * Data class representing a SpaceX launch pad.
 *
 * @property id The unique identifier of the launch pad.
 * @property name The name of the launch pad.
 * @property fullName The full name of the launch pad.
 * @property status The status of the launch pad.
 * @property locality The locality of the launch pad.
 * @property region The region where the launch pad is located.
 * @property timezone The timezone of the launch pad.
 * @property latitude The latitude coordinate of the launch pad.
 * @property longitude The longitude coordinate of the launch pad.
 * @property launchAttempts The number of launch attempts from the launch pad.
 * @property launchSuccesses The number of successful launches from the launch pad.
 * @property rockets The list of rockets associated with the launch pad.
 * @property launches The list of launches associated with the launch pad.
 * @property images The images related to the launch pad.
 * @property details Additional details about the launch pad.
 */
data class LaunchPadDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("full_name")
    val fullName: String? = null,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("locality")
    val locality: String? = null,

    @JsonProperty("region")
    val region: String? = null,

    @JsonProperty("timezone")
    val timezone: String? = null,

    @JsonProperty("latitude")
    val latitude: Double? = null,

    @JsonProperty("longitude")
    val longitude: Double? = null,

    @JsonProperty("launch_attempts")
    val launchAttempts: Int = 0,

    @JsonProperty("launch_successes")
    val launchSuccesses: Int = 0,

    @JsonProperty("rockets")
    val rockets: List<String> = emptyList(),

    @JsonProperty("launches")
    val launches: List<String> = emptyList(),

    @JsonProperty("images")
    val images: Images? = null,

    @JsonProperty("details")
    val details: String? = null
)