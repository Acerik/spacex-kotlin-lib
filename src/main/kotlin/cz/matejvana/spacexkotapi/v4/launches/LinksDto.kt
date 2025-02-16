package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

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
