package cz.matejvana.spacexkotapi.v4.ships

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing a SpaceX ship.
 *
 * @property id The unique identifier of the ship.
 * @property name The name of the ship.
 * @property legacyId The legacy identifier of the ship.
 * @property model The model of the ship.
 * @property type The type of the ship.
 * @property roles The roles assigned to the ship.
 * @property active Indicates if the ship is active.
 * @property imo The International Maritime Organization number.
 * @property mmsi The Maritime Mobile Service Identity number.
 * @property abs The American Bureau of Shipping number.
 * @property shipClass The class of the ship.
 * @property massKg The mass of the ship in kilograms.
 * @property massLbs The mass of the ship in pounds.
 * @property yearBuilt The year the ship was built.
 * @property homePort The home port of the ship.
 * @property status The current status of the ship.
 * @property speedKn The speed of the ship in knots.
 * @property courseDeg The course of the ship in degrees.
 * @property latitude The latitude of the ship's current position.
 * @property longitude The longitude of the ship's current position.
 * @property lastAisUpdate The last AIS update timestamp.
 * @property link The link to more information about the ship.
 * @property image The image URL of the ship.
 * @property launches The list of launches associated with the ship.
 */
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