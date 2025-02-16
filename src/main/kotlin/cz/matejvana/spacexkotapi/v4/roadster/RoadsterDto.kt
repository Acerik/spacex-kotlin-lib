package cz.matejvana.spacexkotapi.v4.roadster

import com.fasterxml.jackson.annotation.JsonProperty

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