package cz.matejvana.spacexkotapi.v4.history

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing a historical event in the SpaceX API.
 *
 * @property id The unique identifier of the historical event.
 * @property title The title of the historical event.
 * @property eventDateUtc The date of the event in UTC format.
 * @property eventDateUnix The date of the event in Unix timestamp format.
 * @property details The details of the historical event.
 * @property links The links related to the historical event.
 */
data class HistoryDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("title")
    val title: String? = null,

    @JsonProperty("event_date_utc")
    val eventDateUtc: String? = null,

    @JsonProperty("event_date_unix")
    val eventDateUnix: Long? = null,

    @JsonProperty("details")
    val details: String? = null,

    @JsonProperty("links")
    val links: Links? = null
) {
    /**
     * Data class representing the links related to the historical event.
     *
     * @property article The URL of the article related to the historical event.
     */
    data class Links(
        @JsonProperty("article")
        val article: String? = null
    )
}