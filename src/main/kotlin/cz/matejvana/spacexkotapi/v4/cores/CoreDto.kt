package cz.matejvana.spacexkotapi.v4.cores

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data transfer object representing a SpaceX core.
 *
 * @property id The unique identifier of the core.
 * @property serial The serial number of the core.
 * @property block The block number of the core, if any.
 * @property status The current status of the core.
 * @property reuseCount The number of times the core has been reused.
 * @property rtlsAttempts The number of RTLS (Return to Launch Site) attempts.
 * @property rtlsLandings The number of successful RTLS landings.
 * @property asdsAttempts The number of ASDS (Autonomous Spaceport Drone Ship) attempts.
 * @property asdsLandings The number of successful ASDS landings.
 * @property lastUpdate The last update information of the core.
 * @property launches The list of launches the core has been involved in.
 */
data class CoreDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("serial")
    val serial: String,

    @JsonProperty("block")
    val block: Int? = null,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("reuse_count")
    val reuseCount: Int = 0,

    @JsonProperty("rtls_attempts")
    val rtlsAttempts: Int = 0,

    @JsonProperty("rtls_landings")
    val rtlsLandings: Int = 0,

    @JsonProperty("asds_attempts")
    val asdsAttempts: Int = 0,

    @JsonProperty("asds_landings")
    val asdsLandings: Int = 0,

    @JsonProperty("last_update")
    val lastUpdate: String? = null,

    @JsonProperty("launches")
    val launches: List<String>
)