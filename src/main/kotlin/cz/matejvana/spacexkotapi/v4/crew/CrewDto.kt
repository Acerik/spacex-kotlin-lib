package cz.matejvana.spacexkotapi.v4.crew

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data transfer object representing a SpaceX crew member.
 *
 * @property id The unique identifier of the crew member.
 * @property name The name of the crew member.
 * @property status The current status of the crew member.
 * @property agency The agency the crew member is associated with.
 * @property image The URL of the crew member's image.
 * @property wikipedia The URL of the crew member's Wikipedia page.
 * @property launches The list of launches the crew member has been involved in.
 */
data class CrewDto(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("agency")
    val agency: String? = null,

    @JsonProperty("image")
    val image: String? = null,

    @JsonProperty("wikipedia")
    val wikipedia: String? = null,

    @JsonProperty("launches")
    val launches: List<String>
)