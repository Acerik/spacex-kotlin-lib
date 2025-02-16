package cz.matejvana.spacexkotapi.v4.rockets

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing the details of a SpaceX rocket.
 *
 * @property id The unique identifier of the rocket.
 * @property name The name of the rocket.
 * @property type The type of the rocket.
 * @property active Indicates if the rocket is currently active.
 * @property stages The number of stages in the rocket.
 * @property boosters The number of boosters in the rocket.
 * @property costPerLaunch The cost per launch in USD.
 * @property successRatePct The success rate percentage of the rocket.
 * @property firstFlight The date of the rocket's first flight.
 * @property country The country of origin of the rocket.
 * @property company The company that manufactured the rocket.
 * @property height The height of the rocket.
 * @property diameter The diameter of the rocket.
 * @property mass The mass of the rocket.
 * @property payloadWeights The payload weights the rocket can carry.
 * @property firstStage The details of the rocket's first stage.
 * @property secondStage The details of the rocket's second stage.
 * @property engines The details of the rocket's engines.
 * @property landingLegs The details of the rocket's landing legs.
 * @property flickrImages The list of Flickr image URLs of the rocket.
 * @property wikipedia The Wikipedia URL of the rocket.
 * @property description Additional details about the rocket.
 */
data class RocketDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("type")
    val type: String,

    @JsonProperty("active")
    val active: Boolean,

    @JsonProperty("stages")
    val stages: Int,

    @JsonProperty("boosters")
    val boosters: Int,

    @JsonProperty("cost_per_launch")
    val costPerLaunch: Int,

    @JsonProperty("success_rate_pct")
    val successRatePct: Int,

    @JsonProperty("first_flight")
    val firstFlight: String,

    @JsonProperty("country")
    val country: String,

    @JsonProperty("company")
    val company: String,

    @JsonProperty("height")
    val height: Dimension,

    @JsonProperty("diameter")
    val diameter: Dimension,

    @JsonProperty("mass")
    val mass: Mass,

    @JsonProperty("payload_weights")
    val payloadWeights: List<PayloadWeight>,

    @JsonProperty("first_stage")
    val firstStage: FirstStage,

    @JsonProperty("second_stage")
    val secondStage: SecondStage,

    @JsonProperty("engines")
    val engines: Engines,

    @JsonProperty("landing_legs")
    val landingLegs: LandingLegs,

    @JsonProperty("flickr_images")
    val flickrImages: List<String>,

    @JsonProperty("wikipedia")
    val wikipedia: String,

    @JsonProperty("description")
    val description: String
) {

    /**
     * Data class representing the dimensions of a rocket.
     *
     * @property meters The height or diameter in meters.
     * @property feet The height or diameter in feet.
     */
    data class Dimension(
        @JsonProperty("meters")
        val meters: Double,

        @JsonProperty("feet")
        val feet: Double
    )

    /**
     * Data class representing the mass of a rocket.
     *
     * @property kg The mass in kilograms.
     * @property lb The mass in pounds.
     */
    data class Mass(

        @JsonProperty("kg")
        val kg: Int,

        @JsonProperty("lb")
        val lb: Int
    )

    /**
     * Data class representing the payload weight of a rocket.
     *
     * @property id The unique identifier of the payload.
     * @property name The name of the payload.
     * @property kg The weight of the payload in kilograms.
     * @property lb The weight of the payload in pounds.
     */
    data class PayloadWeight(

        @JsonProperty("id")
        val id: String,

        @JsonProperty("name")
        val name: String,

        @JsonProperty("kg")
        val kg: Int,

        @JsonProperty("lb")
        val lb: Int
    )

    /**
     * Data class representing the first stage of a rocket.
     *
     * @property reusable Indicates if the first stage is reusable.
     * @property engines The number of engines in the first stage.
     * @property fuelAmountTons The amount of fuel in tons.
     * @property burnTimeSec The burn time in seconds.
     * @property thrustSeaLevel The thrust at sea level.
     * @property thrustVacuum The thrust in vacuum.
     */
    data class FirstStage(

        @JsonProperty("reusable")
        val reusable: Boolean,

        @JsonProperty("engines")
        val engines: Int,

        @JsonProperty("fuel_amount_tons")
        val fuelAmountTons: Double,

        @JsonProperty("burn_time_sec")
        val burnTimeSec: Int,

        @JsonProperty("thrust_sea_level")
        val thrustSeaLevel: Thrust,

        @JsonProperty("thrust_vacuum")
        val thrustVacuum: Thrust
    )

    /**
     * Data class representing the second stage of a rocket.
     *
     * @property reusable Indicates if the second stage is reusable.
     * @property engines The number of engines in the second stage.
     * @property fuelAmountTons The amount of fuel in tons.
     * @property burnTimeSec The burn time in seconds.
     * @property thrust The thrust of the second stage.
     * @property payloads The payloads carried by the second stage.
     */
    data class SecondStage(

        @JsonProperty("reusable")
        val reusable: Boolean,

        @JsonProperty("engines")
        val engines: Int,

        @JsonProperty("fuel_amount_tons")
        val fuelAmountTons: Double,

        @JsonProperty("burn_time_sec")
        val burnTimeSec: Int,

        @JsonProperty("thrust")
        val thrust: Thrust,

        @JsonProperty("payloads")
        val payloads: Payloads
    )

    /**
     * Data class representing the thrust of a rocket stage.
     *
     * @property kN The thrust in kilonewtons.
     * @property lbf The thrust in pounds-force.
     */
    data class Thrust(

        @JsonProperty("kN")
        val kN: Int,

        @JsonProperty("lbf")
        val lbf: Int
    )

    /**
     * Data class representing the payloads of a rocket stage.
     *
     * @property option1 The first payload option.
     * @property compositeFairing The composite fairing details.
     */
    data class Payloads(

        @JsonProperty("option_1")
        val option1: String,

        @JsonProperty("composite_fairing")
        val compositeFairing: CompositeFairing
    )

    /**
     * Data class representing the composite fairing of a rocket.
     *
     * @property height The height of the fairing.
     * @property diameter The diameter of the fairing.
     */
    data class CompositeFairing(

        @JsonProperty("height")
        val height: Dimension,

        @JsonProperty("diameter")
        val diameter: Dimension
    )

    /**
     * Data class representing the engines of a rocket.
     *
     * @property number The number of engines.
     * @property type The type of engines.
     * @property version The version of the engines.
     * @property layout The layout of the engines.
     * @property isp The specific impulse of the engines.
     * @property engineLossMax The maximum engine loss.
     * @property propellant1 The first propellant type.
     * @property propellant2 The second propellant type.
     * @property thrustSeaLevel The thrust at sea level.
     * @property thrustVacuum The thrust in vacuum.
     * @property thrustToWeight The thrust-to-weight ratio.
     */
    data class Engines(

        @JsonProperty("number")
        val number: Int,

        @JsonProperty("type")
        val type: String,

        @JsonProperty("version")
        val version: String,

        @JsonProperty("layout")
        val layout: String?,

        @JsonProperty("isp")
        val isp: ISP,

        @JsonProperty("engine_loss_max")
        val engineLossMax: Int,

        @JsonProperty("propellant_1")
        val propellant1: String,

        @JsonProperty("propellant_2")
        val propellant2: String,

        @JsonProperty("thrust_sea_level")
        val thrustSeaLevel: Thrust,

        @JsonProperty("thrust_vacuum")
        val thrustVacuum: Thrust,

        @JsonProperty("thrust_to_weight")
        val thrustToWeight: Double
    )

    /**
     * Data class representing the ISP (Specific Impulse) of the rocket engines.
     *
     * @property seaLevel The ISP at sea level.
     * @property vacuum The ISP in vacuum.
     */
    data class ISP(
        @JsonProperty("sea_level")
        val seaLevel: Int,

        @JsonProperty("vacuum")
        val vacuum: Int
    )

    /**
     * Data class representing the landing legs of the rocket.
     *
     * @property number The number of landing legs.
     * @property material The material of the landing legs.
     */
    data class LandingLegs(
        @JsonProperty("number")
        val number: Int,

        @JsonProperty("material")
        val material: String?
    )
}