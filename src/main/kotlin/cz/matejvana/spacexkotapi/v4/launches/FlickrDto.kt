package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing Flickr images in the SpaceX API.
 *
 * @property small List of URLs for small-sized images.
 * @property original List of URLs for original-sized images.
 */
data class FlickrDto(
    @JsonProperty("small")
    val small: List<String> = emptyList(),

    @JsonProperty("original")
    val original: List<String> = emptyList()
)