package cz.matejvana.spacexkotapi.v4.company

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data transfer object representing company information.
 *
 * @property id The unique identifier of the company.
 * @property name The name of the company.
 * @property founder The founder of the company.
 * @property founded The year the company was founded.
 * @property employees The number of employees in the company.
 * @property vehicles The number of vehicles the company has.
 * @property launchSites The number of launch sites the company has.
 * @property testSites The number of test sites the company has.
 * @property ceo The CEO of the company.
 * @property cto The CTO of the company.
 * @property coo The COO of the company.
 * @property ctoPropulsion The CTO of propulsion of the company.
 * @property valuation The valuation of the company.
 * @property headquarters The headquarters information of the company.
 * @property links The links related to the company.
 * @property summary A summary of the company.
 */
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
    /**
     * Data transfer object representing the headquarters information.
     *
     * @property address The address of the headquarters.
     * @property city The city where the headquarters is located.
     * @property state The state where the headquarters is located.
     */
    data class Headquarters(
        @JsonProperty("address")
        val address: String,

        @JsonProperty("city")
        val city: String,

        @JsonProperty("state")
        val state: String
    )

    /**
     * Data transfer object representing the links related to the company.
     *
     * @property website The website link of the company.
     * @property flickr The Flickr link of the company.
     * @property twitter The Twitter link of the company.
     * @property elonTwitter The Twitter link of Elon Musk.
     */
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