package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing the Reddit links related to a SpaceX launch.
 *
 * @property campaign URL to the Reddit campaign discussion.
 * @property launch URL to the Reddit launch discussion.
 * @property media URL to the Reddit media discussion.
 * @property recovery URL to the Reddit recovery discussion.
 */
data class RedditDto(
    @JsonProperty("campaign")
    val campaign: String? = null,

    @JsonProperty("launch")
    val launch: String? = null,

    @JsonProperty("media")
    val media: String? = null,

    @JsonProperty("recovery")
    val recovery: String? = null
)