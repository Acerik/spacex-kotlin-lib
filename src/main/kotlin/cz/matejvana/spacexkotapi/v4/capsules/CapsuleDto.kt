package cz.matejvana.spacexkotapi.v4.capsules

import com.fasterxml.jackson.annotation.JsonProperty

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

