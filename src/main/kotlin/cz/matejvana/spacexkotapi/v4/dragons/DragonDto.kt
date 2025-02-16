package cz.matejvana.spacexkotapi.v4.dragons

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data transfer object representing a SpaceX Dragon.
 *
 * @property id The unique identifier of the Dragon.
 * @property name The name of the Dragon.
 * @property type The type of the Dragon.
 * @property active Whether the Dragon is active.
 * @property crewCapacity The crew capacity of the Dragon.
 * @property sidewallAngleDeg The sidewall angle in degrees.
 * @property orbitDurationYr The orbit duration in years.
 * @property dryMassKg The dry mass of the Dragon in kilograms.
 * @property dryMassLb The dry mass of the Dragon in pounds.
 * @property firstFlight The date of the first flight of the Dragon.
 * @property heatShield The heat shield information of the Dragon.
 * @property thrusters The list of thrusters of the Dragon.
 * @property launchPayloadMass The launch payload mass of the Dragon.
 * @property launchPayloadVol The launch payload volume of the Dragon.
 * @property returnPayloadMass The return payload mass of the Dragon.
 * @property returnPayloadVol The return payload volume of the Dragon.
 * @property pressurizedCapsule The pressurized capsule information of the Dragon.
 * @property trunk The trunk information of the Dragon.
 * @property heightWTrunk The height of the Dragon with trunk.
 * @property diameter The diameter of the Dragon.
 * @property flickrImages The list of Flickr images of the Dragon.
 * @property wikipedia The URL of the Dragon's Wikipedia page.
 * @property description The description of the Dragon.
 */
data class DragonDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("type")
    val type: String,

    @JsonProperty("active")
    val active: Boolean,

    @JsonProperty("crew_capacity")
    val crewCapacity: Int,

    @JsonProperty("sidewall_angle_deg")
    val sidewallAngleDeg: Int,

    @JsonProperty("orbit_duration_yr")
    val orbitDurationYr: Int,

    @JsonProperty("dry_mass_kg")
    val dryMassKg: Int,

    @JsonProperty("dry_mass_lb")
    val dryMassLb: Int,

    @JsonProperty("first_flight")
    val firstFlight: String? = null,

    @JsonProperty("heat_shield")
    val heatShield: HeatShield,

    @JsonProperty("thrusters")
    val thrusters: List<Thruster>,

    @JsonProperty("launch_payload_mass")
    val launchPayloadMass: PayloadMass,

    @JsonProperty("launch_payload_vol")
    val launchPayloadVol: PayloadVolume,

    @JsonProperty("return_payload_mass")
    val returnPayloadMass: PayloadMass,

    @JsonProperty("return_payload_vol")
    val returnPayloadVol: PayloadVolume,

    @JsonProperty("pressurized_capsule")
    val pressurizedCapsule: PressurizedCapsule,

    @JsonProperty("trunk")
    val trunk: Trunk,

    @JsonProperty("height_w_trunk")
    val heightWTrunk: Dimension,

    @JsonProperty("diameter")
    val diameter: Dimension,

    @JsonProperty("flickr_images")
    val flickrImages: List<String>,

    @JsonProperty("wikipedia")
    val wikipedia: String,

    @JsonProperty("description")
    val description: String
) {
    /**
     * Data class representing the heat shield of the Dragon.
     *
     * @property material The material of the heat shield.
     * @property sizeMeters The size of the heat shield in meters.
     * @property tempDegrees The temperature the heat shield can withstand in degrees.
     * @property devPartner The development partner of the heat shield.
     */
    data class HeatShield(
        @JsonProperty("material")
        val material: String,

        @JsonProperty("size_meters")
        val sizeMeters: Double,

        @JsonProperty("temp_degrees")
        val tempDegrees: Int? = null,

        @JsonProperty("dev_partner")
        val devPartner: String? = null
    )

    /**
     * Data class representing the payload mass.
     *
     * @property kg The payload mass in kilograms.
     * @property lb The payload mass in pounds.
     */
    data class PayloadMass(
        @JsonProperty("kg")
        val kg: Int? = null,

        @JsonProperty("lb")
        val lb: Int? = null
    )

    /**
     * Data class representing the payload volume.
     *
     * @property cubicMeters The payload volume in cubic meters.
     * @property cubicFeet The payload volume in cubic feet.
     */
    data class PayloadVolume(
        @JsonProperty("cubic_meters")
        val cubicMeters: Int? = null,

        @JsonProperty("cubic_feet")
        val cubicFeet: Int? = null
    )

    /**
     * Data class representing the pressurized capsule of the Dragon.
     *
     * @property payloadVolume The payload volume of the pressurized capsule.
     */
    data class PressurizedCapsule(
        @JsonProperty("payload_volume")
        val payloadVolume: PayloadVolume
    )

    /**
     * Data class representing the trunk of the Dragon.
     *
     * @property trunkVolume The volume of the trunk.
     * @property cargo The cargo information of the trunk.
     */
    data class Trunk(
        @JsonProperty("trunk_volume")
        val trunkVolume: PayloadVolume,

        @JsonProperty("cargo")
        val cargo: Cargo
    ) {
        /**
         * Data class representing the cargo of the trunk.
         *
         * @property solarArray The number of solar arrays.
         * @property unpressurizedCargo Whether the cargo is unpressurized.
         */
        data class Cargo(
            @JsonProperty("solar_array")
            val solarArray: Int? = null,

            @JsonProperty("unpressurized_cargo")
            val unpressurizedCargo: Boolean? = null
        )
    }

    /**
     * Data class representing the dimensions of the Dragon.
     *
     * @property meters The dimension in meters.
     * @property feet The dimension in feet.
     */
    data class Dimension(
        @JsonProperty("meters")
        val meters: Double? = null,

        @JsonProperty("feet")
        val feet: Int? = null
    )

    /**
     * Data class representing a thruster of the Dragon.
     *
     * @property type The type of the thruster.
     * @property amount The amount of thrusters.
     * @property pods The number of pods.
     * @property fuel1 The first type of fuel used by the thruster.
     * @property fuel2 The second type of fuel used by the thruster.
     * @property isp The specific impulse of the thruster.
     * @property thrust The thrust information of the thruster.
     */
    data class Thruster(
        @JsonProperty("type")
        val type: String,

        @JsonProperty("amount")
        val amount: Int,

        @JsonProperty("pods")
        val pods: Int,

        @JsonProperty("fuel_1")
        val fuel1: String,

        @JsonProperty("fuel_2")
        val fuel2: String,

        @JsonProperty("isp")
        val isp: Int,

        @JsonProperty("thrust")
        val thrust: Thrust
    ) {
        /**
         * Data class representing the thrust of the thruster.
         *
         * @property kN The thrust in kilonewtons.
         * @property lbf The thrust in pounds-force.
         */
        data class Thrust(
            @JsonProperty("kN")
            val kN: Double,

            @JsonProperty("lbf")
            val lbf: Double
        )
    }
}
