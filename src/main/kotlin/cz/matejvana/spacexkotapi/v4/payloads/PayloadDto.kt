package cz.matejvana.spacexkotapi.v4.payloads

import com.fasterxml.jackson.annotation.JsonProperty

data class PayloadDto(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("type")
    val type: String? = null,

    @JsonProperty("reused")
    val reused: Boolean = false,

    @JsonProperty("launch")
    val launch: String? = null,

    @JsonProperty("customers")
    val customers: List<String> = emptyList(),

    @JsonProperty("norad_ids")
    val noradIds: List<Int> = emptyList(),

    @JsonProperty("nationalities")
    val nationalities: List<String> = emptyList(),

    @JsonProperty("manufacturers")
    val manufacturers: List<String> = emptyList(),

    @JsonProperty("mass_kg")
    val massKg: Double? = null,

    @JsonProperty("mass_lbs")
    val massLbs: Double? = null,

    @JsonProperty("orbit")
    val orbit: String? = null,

    @JsonProperty("reference_system")
    val referenceSystem: String? = null,

    @JsonProperty("regime")
    val regime: String? = null,

    @JsonProperty("longitude")
    val longitude: Double? = null,

    @JsonProperty("semi_major_axis_km")
    val semiMajorAxisKm: Double? = null,

    @JsonProperty("eccentricity")
    val eccentricity: Double? = null,

    @JsonProperty("periapsis_km")
    val periapsisKm: Double? = null,

    @JsonProperty("apoapsis_km")
    val apoapsisKm: Double? = null,

    @JsonProperty("inclination_deg")
    val inclinationDeg: Double? = null,

    @JsonProperty("period_min")
    val periodMin: Double? = null,

    @JsonProperty("lifespan_years")
    val lifespanYears: Double? = null,

    @JsonProperty("epoch")
    val epoch: String? = null,

    @JsonProperty("mean_motion")
    val meanMotion: Double? = null,

    @JsonProperty("raan")
    val raan: Double? = null,

    @JsonProperty("arg_of_pericenter")
    val argOfPericenter: Double? = null,

    @JsonProperty("mean_anomaly")
    val meanAnomaly: Double? = null,

    @JsonProperty("dragon")
    val dragon: Dragon? = null
) {
    data class Dragon(

        @JsonProperty("capsule")
        val capsule: String? = null,

        @JsonProperty("mass_returned_kg")
        val massReturnedKg: Double? = null,

        @JsonProperty("mass_returned_lbs")
        val massReturnedLbs: Double? = null,

        @JsonProperty("flight_time_sec")
        val flightTimeSec: Double? = null,

        @JsonProperty("manifest")
        val manifest: String? = null,

        @JsonProperty("water_landing")
        val waterLanding: Boolean? = null,

        @JsonProperty("land_landing")
        val landLanding: Boolean? = null
    )
}