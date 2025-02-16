package cz.matejvana.spacexkotapi.v4.rockets

import com.fasterxml.jackson.annotation.JsonProperty

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

    data class Dimension(
        @JsonProperty("meters")
        val meters: Double,

        @JsonProperty("feet")
        val feet: Double
    )

    data class Mass(

        @JsonProperty("kg")
        val kg: Int,

        @JsonProperty("lb")
        val lb: Int
    )

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

    data class Thrust(

        @JsonProperty("kN")
        val kN: Int,

        @JsonProperty("lbf")
        val lbf: Int
    )

    data class Payloads(

        @JsonProperty("option_1")
        val option1: String,

        @JsonProperty("composite_fairing")
        val compositeFairing: CompositeFairing
    )

    data class CompositeFairing(

        @JsonProperty("height")
        val height: Dimension,

        @JsonProperty("diameter")
        val diameter: Dimension
    )

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

    data class ISP(

        @JsonProperty("sea_level")
        val seaLevel: Int,

        @JsonProperty("vacuum")
        val vacuum: Int
    )

    data class LandingLegs(

        @JsonProperty("number")
        val number: Int,

        @JsonProperty("material")
        val material: String?
    )
}