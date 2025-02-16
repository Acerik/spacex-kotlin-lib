package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing a launch in the SpaceX API (version 5).
 *
 * @property id The unique identifier of the launch.
 * @property flightNumber The flight number of the launch.
 * @property name The name of the launch.
 * @property dateUtc The date of the launch in UTC format.
 * @property dateUnix The date of the launch in Unix timestamp format.
 * @property dateLocal The local date of the launch.
 * @property datePrecision The precision of the launch date.
 * @property staticFireDateUtc The date of the static fire test in UTC format.
 * @property staticFireDateUnix The date of the static fire test in Unix timestamp format.
 * @property tbd Indicates if the launch date is to be determined.
 * @property net Indicates if the launch is a no earlier than (NET) date.
 * @property window The launch window duration in seconds.
 * @property launchLibraryId The ID of the launch in the Launch Library.
 * @property rocket The ID of the rocket used in the launch.
 * @property success Indicates if the launch was successful.
 * @property failures A list of failures that occurred during the launch.
 * @property upcoming Indicates if the launch is upcoming.
 * @property details Additional details about the launch.
 * @property fairings Information about the fairings used in the launch.
 * @property crew A list of crew members involved in the launch.
 * @property ships A list of ships involved in the launch.
 * @property capsules A list of capsules involved in the launch.
 * @property payloads A list of payloads involved in the launch.
 * @property launchpad The ID of the launchpad used for the launch.
 * @property cores A list of cores used in the launch.
 * @property links Links related to the launch.
 * @property autoUpdate Indicates if the launch data is automatically updated.
 */
data class LaunchV5Dto(

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
    val crew: List<LaunchCrewDto> = emptyList(),

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
) {
    /**
     * Data class representing a crew member involved in the launch.
     *
     * @property crew The ID of the crew member.
     * @property role The role of the crew member in the launch.
     */
    data class LaunchCrewDto(
        @JsonProperty("crew")
        val crew: String? = null,

        @JsonProperty("role")
        val role: String? = null
    )
}