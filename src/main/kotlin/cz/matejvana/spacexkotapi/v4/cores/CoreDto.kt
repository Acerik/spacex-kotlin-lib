package cz.matejvana.spacexkotapi.v4.cores

import com.fasterxml.jackson.annotation.JsonProperty

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