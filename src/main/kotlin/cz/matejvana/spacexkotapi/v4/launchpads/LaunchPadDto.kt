import com.fasterxml.jackson.annotation.JsonProperty
import cz.matejvana.spacexkotapi.v4.Images

data class LaunchPadDto(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("full_name")
    val fullName: String? = null,

    @JsonProperty("status")
    val status: String,

    @JsonProperty("locality")
    val locality: String? = null,

    @JsonProperty("region")
    val region: String? = null,

    @JsonProperty("timezone")
    val timezone: String? = null,

    @JsonProperty("latitude")
    val latitude: Double? = null,

    @JsonProperty("longitude")
    val longitude: Double? = null,

    @JsonProperty("launch_attempts")
    val launchAttempts: Int = 0,

    @JsonProperty("launch_successes")
    val launchSuccesses: Int = 0,

    @JsonProperty("rockets")
    val rockets: List<String> = emptyList(),

    @JsonProperty("launches")
    val launches: List<String> = emptyList(),

    @JsonProperty("images")
    val images: Images? = null,

    @JsonProperty("details")
    val details: String? = null
)