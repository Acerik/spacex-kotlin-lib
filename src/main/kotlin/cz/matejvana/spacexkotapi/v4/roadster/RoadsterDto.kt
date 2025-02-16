package cz.matejvana.spacexkotapi.v4.roadster

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing the details of the SpaceX Roadster.
 *
 * @property id The unique identifier of the roadster.
 * @property name The name of the roadster.
 * @property launchDateUtc The UTC date of the roadster's launch.
 * @property launchDateUnix The Unix timestamp of the roadster's launch.
 * @property launchMassKg The launch mass of the roadster in kilograms.
 * @property launchMassLbs The launch mass of the roadster in pounds.
 * @property noradId The NORAD identifier of the roadster.
 * @property epochJd The Julian Date of the roadster's epoch.
 * @property orbitType The type of orbit the roadster is in.
 * @property apoapsisAu The apoapsis distance of the roadster in astronomical units.
 * @property periapsisAu The periapsis distance of the roadster in astronomical units.
 * @property semiMajorAxisAu The semi-major axis of the roadster's orbit in astronomical units.
 * @property eccentricity The eccentricity of the roadster's orbit.
 * @property inclination The inclination of the roadster's orbit in degrees.
 * @property longitude The longitude of the roadster's orbit in degrees.
 * @property periapsisArg The argument of periapsis of the roadster's orbit in degrees.
 * @property periodDays The orbital period of the roadster in days.
 * @property speedKph The speed of the roadster in kilometers per hour.
 * @property speedMph The speed of the roadster in miles per hour.
 * @property earthDistanceKm The distance of the roadster from Earth in kilometers.
 * @property earthDistanceMi The distance of the roadster from Earth in miles.
 * @property marsDistanceKm The distance of the roadster from Mars in kilometers.
 * @property marsDistanceMi The distance of the roadster from Mars in miles.
 * @property flickrImages The list of Flickr image URLs of the roadster.
 * @property wikipedia The Wikipedia URL of the roadster.
 * @property video The video URL of the roadster.
 * @property details Additional details about the roadster.
 */
data class RoadsterDto(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("launch_date_utc")
    val launchDateUtc: String,

    @JsonProperty("launch_date_unix")
    val launchDateUnix: Double,

    @JsonProperty("launch_mass_kg")
    val launchMassKg: Int,

    @JsonProperty("launch_mass_lbs")
    val launchMassLbs: Int,

    @JsonProperty("norad_id")
    val noradId: Int,

    @JsonProperty("epoch_jd")
    val epochJd: Double,

    @JsonProperty("orbit_type")
    val orbitType: String,

    @JsonProperty("apoapsis_au")
    val apoapsisAu: Double,

    @JsonProperty("periapsis_au")
    val periapsisAu: Double,

    @JsonProperty("semi_major_axis_au")
    val semiMajorAxisAu: Double,

    @JsonProperty("eccentricity")
    val eccentricity: Double,

    @JsonProperty("inclination")
    val inclination: Double,

    @JsonProperty("longitude")
    val longitude: Double,

    @JsonProperty("periapsis_arg")
    val periapsisArg: Double,

    @JsonProperty("period_days")
    val periodDays: Double,

    @JsonProperty("speed_kph")
    val speedKph: Double,

    @JsonProperty("speed_mph")
    val speedMph: Double,

    @JsonProperty("earth_distance_km")
    val earthDistanceKm: Double,

    @JsonProperty("earth_distance_mi")
    val earthDistanceMi: Double,

    @JsonProperty("mars_distance_km")
    val marsDistanceKm: Double,

    @JsonProperty("mars_distance_mi")
    val marsDistanceMi: Double,

    @JsonProperty("flickr_images")
    val flickrImages: List<String>,

    @JsonProperty("wikipedia")
    val wikipedia: String,

    @JsonProperty("video")
    val video: String,

    @JsonProperty("details")
    val details: String
)