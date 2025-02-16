package cz.matejvana.spacexkotapi.v4.payloads

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing a payload in the SpaceX API.
 *
 * @property id The unique identifier of the payload.
 * @property name The name of the payload.
 * @property type The type of the payload.
 * @property reused Indicates if the payload is reused.
 * @property launch The launch identifier associated with the payload.
 * @property customers The list of customers for the payload.
 * @property noradIds The list of NORAD IDs associated with the payload.
 * @property nationalities The list of nationalities associated with the payload.
 * @property manufacturers The list of manufacturers of the payload.
 * @property massKg The mass of the payload in kilograms.
 * @property massLbs The mass of the payload in pounds.
 * @property orbit The orbit of the payload.
 * @property referenceSystem The reference system of the payload's orbit.
 * @property regime The regime of the payload's orbit.
 * @property longitude The longitude of the payload's orbit.
 * @property semiMajorAxisKm The semi-major axis of the payload's orbit in kilometers.
 * @property eccentricity The eccentricity of the payload's orbit.
 * @property periapsisKm The periapsis of the payload's orbit in kilometers.
 * @property apoapsisKm The apoapsis of the payload's orbit in kilometers.
 * @property inclinationDeg The inclination of the payload's orbit in degrees.
 * @property periodMin The period of the payload's orbit in minutes.
 * @property lifespanYears The expected lifespan of the payload in years.
 * @property epoch The epoch of the payload's orbit.
 * @property meanMotion The mean motion of the payload's orbit.
 * @property raan The right ascension of the ascending node of the payload's orbit.
 * @property argOfPericenter The argument of pericenter of the payload's orbit.
 * @property meanAnomaly The mean anomaly of the payload's orbit.
 * @property dragon The Dragon-specific details of the payload.
 */
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
    /**
     * Data class representing Dragon-specific details of the payload.
     *
     * @property capsule The capsule identifier.
     * @property massReturnedKg The mass returned by the Dragon capsule in kilograms.
     * @property massReturnedLbs The mass returned by the Dragon capsule in pounds.
     * @property flightTimeSec The flight time of the Dragon capsule in seconds.
     * @property manifest The manifest of the Dragon capsule.
     * @property waterLanding Indicates if the Dragon capsule landed in water.
     * @property landLanding Indicates if the Dragon capsule landed on land.
     */
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