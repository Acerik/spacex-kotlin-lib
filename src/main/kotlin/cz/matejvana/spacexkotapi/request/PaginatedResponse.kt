package cz.matejvana.spacexkotapi.request

import com.fasterxml.jackson.annotation.JsonProperty

data class PaginatedResponse<T>(

    @JsonProperty
    val docs: List<T> = emptyList(),

    @JsonProperty("totalDocs")
    val totalDocs: Int,

    @JsonProperty("limit")
    val limit: Int,

    @JsonProperty("totalPages")
    val totalPages: Int,

    @JsonProperty("offset")
    val offset: Int,

    @JsonProperty("page")
    val page: Int,

    @JsonProperty("pagingCounter")
    val pagingCounter: Int,

    @JsonProperty("hasPrevPage")
    val hasPrevPage: Boolean,

    @JsonProperty("hasNextPage")
    val hasNextPage: Boolean,

    @JsonProperty("prevPage")
    val prevPage: Int?,

    @JsonProperty("nextPage")
    val nextPage: Int?
)