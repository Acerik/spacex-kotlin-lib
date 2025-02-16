package cz.matejvana.spacexkotapi.v4.ships

import com.fasterxml.jackson.annotation.JsonProperty

data class ShipDto(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("legacy_id")
    val legacyId: String? = null,

    @JsonProperty("model")
    val model: String? = null,

    @JsonProperty("type")
    val type: String? = null,

    @JsonProperty("roles")
    val roles: List<String>,

    @JsonProperty("active")
    val active: Boolean,

    @JsonProperty("imo")
    val imo: Int? = null,

    @JsonProperty("mmsi")
    val mmsi: Int? = null,

    @JsonProperty("abs")
    val abs: Int? = null,

    @JsonProperty("class")
    val shipClass: Int? = null,

    @JsonProperty("mass_kg")
    val massKg: Int? = null,

    @JsonProperty("mass_lbs")
    val massLbs: Int? = null,

    @JsonProperty("year_built")
    val yearBuilt: Int? = null,

    @JsonProperty("home_port")
    val homePort: String? = null,

    @JsonProperty("status")
    val status: String? = null,

    @JsonProperty("speed_kn")
    val speedKn: Int? = null,

    @JsonProperty("course_deg")
    val courseDeg: Int? = null,

    @JsonProperty("latitude")
    val latitude: Double? = null,

    @JsonProperty("longitude")
    val longitude: Double? = null,

    @JsonProperty("last_ais_update")
    val lastAisUpdate: String? = null,

    @JsonProperty("link")
    val link: String? = null,

    @JsonProperty("image")
    val image: String? = null,

    @JsonProperty("launches")
    val launches: List<String>
)