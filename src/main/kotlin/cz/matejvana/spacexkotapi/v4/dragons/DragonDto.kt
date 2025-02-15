package cz.matejvana.spacexkotapi.v4.dragons

import com.fasterxml.jackson.annotation.JsonProperty

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

    data class PayloadMass(
        @JsonProperty("kg")
        val kg: Int? = null,

        @JsonProperty("lb")
        val lb: Int? = null
    )

    data class PayloadVolume(
        @JsonProperty("cubic_meters")
        val cubicMeters: Int? = null,

        @JsonProperty("cubic_feet")
        val cubicFeet: Int? = null
    )

    data class PressurizedCapsule(
        @JsonProperty("payload_volume")
        val payloadVolume: PayloadVolume
    )

    data class Trunk(
        @JsonProperty("trunk_volume")
        val trunkVolume: PayloadVolume,

        @JsonProperty("cargo")
        val cargo: Cargo
    ) {
        data class Cargo(
            @JsonProperty("solar_array")
            val solarArray: Int? = null,

            @JsonProperty("unpressurized_cargo")
            val unpressurizedCargo: Boolean? = null
        )
    }

    data class Dimension(
        @JsonProperty("meters")
        val meters: Double? = null,

        @JsonProperty("feet")
        val feet: Int? = null
    )

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
        data class Thrust(
            @JsonProperty("kN")
            val kN: Double,

            @JsonProperty("lbf")
            val lbf: Double
        )
    }
}
