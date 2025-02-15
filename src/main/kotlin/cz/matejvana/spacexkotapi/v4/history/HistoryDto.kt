package cz.matejvana.spacexkotapi.v4.history

import com.fasterxml.jackson.annotation.JsonProperty

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
    data class Links(
        @JsonProperty("article")
        val article: String? = null
    )
}