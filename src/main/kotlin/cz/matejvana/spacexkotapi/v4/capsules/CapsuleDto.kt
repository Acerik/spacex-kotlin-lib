package cz.matejvana.spacexkotapi.v4.capsules

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data transfer object representing a SpaceX capsule.
 *
 * @property id The unique identifier of the capsule.
 * @property serial The serial number of the capsule.
 * @property status The current status of the capsule.
 * @property type The type of the capsule.
 * @property dragon The dragon associated with the capsule, if any.
 * @property reuseCount The number of times the capsule has been reused.
 * @property waterLandings The number of water landings the capsule has performed.
 * @property landLandings The number of land landings the capsule has performed.
 * @property lastUpdate The last update information of the capsule.
 * @property launches The list of launches the capsule has been involved in.
 */
data class CapsuleDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("serial")
    val serial: String,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("type")
    val type: String,

    @JsonProperty("dragon")
    val dragon: String? = null,

    @JsonProperty("reuse_count")
    val reuseCount: Int,

    @JsonProperty("water_landings")
    val waterLandings: Int,

    @JsonProperty("land_landings")
    val landLandings: Int,

    @JsonProperty("last_update")
    val lastUpdate: String?,

    @JsonProperty("launches")
    val launches: List<String> = emptyList()
)

