package cz.matejvana.spacexkotapi.v4.company

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("founder")
    val founder: String,

    @JsonProperty("founded")
    val founded: Int,

    @JsonProperty("employees")
    val employees: Int,

    @JsonProperty("vehicles")
    val vehicles: Int,

    @JsonProperty("launch_sites")
    val launchSites: Int,

    @JsonProperty("test_sites")
    val testSites: Int,

    @JsonProperty("ceo")
    val ceo: String,

    @JsonProperty("cto")
    val cto: String,

    @JsonProperty("coo")
    val coo: String,

    @JsonProperty("cto_propulsion")
    val ctoPropulsion: String,

    @JsonProperty("valuation")
    val valuation: Long,

    @JsonProperty("headquarters")
    val headquarters: Headquarters,

    @JsonProperty("links")
    val links: Links,

    @JsonProperty("summary")
    val summary: String
) {
    data class Headquarters(
        @JsonProperty("address")
        val address: String,

        @JsonProperty("city")
        val city: String,

        @JsonProperty("state")
        val state: String
    )

    data class Links(
        @JsonProperty("website")
        val website: String,

        @JsonProperty("flickr")
        val flickr: String,

        @JsonProperty("twitter")
        val twitter: String,

        @JsonProperty("elon_twitter")
        val elonTwitter: String
    )
}