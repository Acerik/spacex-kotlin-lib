package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing the links related to a SpaceX launch.
 *
 * @property patch Information about the mission patch.
 * @property reddit Links to Reddit discussions about the launch.
 * @property flickr Links to Flickr albums with photos of the launch.
 * @property presskit URL to the press kit for the launch.
 * @property webcast URL to the webcast of the launch.
 * @property youtubeId YouTube ID of the launch webcast.
 * @property article URL to an article about the launch.
 * @property wikipedia URL to the Wikipedia page about the launch.
 */
data class LinksDto(
    @JsonProperty("patch")
    val patch: PatchDto? = null,

    @JsonProperty("reddit")
    val reddit: RedditDto? = null,

    @JsonProperty("flickr")
    val flickr: FlickrDto? = null,

    @JsonProperty("presskit")
    val presskit: String? = null,

    @JsonProperty("webcast")
    val webcast: String? = null,

    @JsonProperty("youtube_id")
    val youtubeId: String? = null,

    @JsonProperty("article")
    val article: String? = null,

    @JsonProperty("wikipedia")
    val wikipedia: String? = null
)