package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

data class LaunchV4Dto(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("flight_number")
    val flightNumber: Int,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("date_utc")
    val dateUtc: String,

    @JsonProperty("date_unix")
    val dateUnix: Int,

    @JsonProperty("date_local")
    val dateLocal: String,

    @JsonProperty("date_precision")
    val datePrecision: String,

    @JsonProperty("static_fire_date_utc")
    val staticFireDateUtc: String? = null,

    @JsonProperty("static_fire_date_unix")
    val staticFireDateUnix: Int? = null,

    @JsonProperty("tbd")
    val tbd: Boolean = false,

    @JsonProperty("net")
    val net: Boolean = false,

    @JsonProperty("window")
    val window: Int? = null,

    @JsonProperty("launch_library_id")
    val launchLibraryId: String? = null,

    @JsonProperty("rocket")
    val rocket: String? = null,

    @JsonProperty("success")
    val success: Boolean? = null,

    @JsonProperty("failures")
    val failures: List<FailureDto> = emptyList(),

    @JsonProperty("upcoming")
    val upcoming: Boolean,

    @JsonProperty("details")
    val details: String? = null,

    @JsonProperty("fairings")
    val fairings: FairingsDto? = null,

    @JsonProperty("crew")
    val crew: List<String> = emptyList(),

    @JsonProperty("ships")
    val ships: List<String> = emptyList(),

    @JsonProperty("capsules")
    val capsules: List<String> = emptyList(),

    @JsonProperty("payloads")
    val payloads: List<String> = emptyList(),

    @JsonProperty("launchpad")
    val launchpad: String? = null,

    @JsonProperty("cores")
    val cores: List<CoreLaunchDto> = emptyList(),

    @JsonProperty("links")
    val links: LinksDto? = null,

    @JsonProperty("auto_update")
    val autoUpdate: Boolean = true
)