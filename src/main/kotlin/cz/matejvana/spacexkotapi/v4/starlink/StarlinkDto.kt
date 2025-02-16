package cz.matejvana.spacexkotapi.v4.starlink

import com.fasterxml.jackson.annotation.JsonProperty

data class StarlinkDto(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("version")
    val version: String? = null,

    @JsonProperty("launch")
    val launch: String? = null,

    @JsonProperty("longitude")
    val longitude: Double? = null,

    @JsonProperty("latitude")
    val latitude: Double? = null,

    @JsonProperty("height_km")
    val heightKm: Double? = null,

    @JsonProperty("velocity_kms")
    val velocityKms: Double? = null,

    @JsonProperty("spaceTrack")
    val spaceTrack: SpaceTrack? = null
) {
    class SpaceTrack(
        @JsonProperty("CCSDS_OMM_VERS")
        val ccsdsOmmVers: String? = null,

        @JsonProperty("COMMENT")
        val comment: String? = null,

        @JsonProperty("CREATION_DATE")
        val creationDate: String? = null,

        @JsonProperty("ORIGINATOR")
        val originator: String? = null,

        @JsonProperty("OBJECT_NAME")
        val objectName: String? = null,

        @JsonProperty("OBJECT_ID")
        val objectId: String? = null,

        @JsonProperty("CENTER_NAME")
        val centerName: String? = null,

        @JsonProperty("REF_FRAME")
        val refFrame: String? = null,

        @JsonProperty("TIME_SYSTEM")
        val timeSystem: String? = null,

        @JsonProperty("MEAN_ELEMENT_THEORY")
        val meanElementTheory: String? = null,

        @JsonProperty("EPOCH")
        val epoch: String? = null,

        @JsonProperty("MEAN_MOTION")
        val meanMotion: Double? = null,

        @JsonProperty("ECCENTRICITY")
        val eccentricity: Double? = null,

        @JsonProperty("INCLINATION")
        val inclination: Double? = null,

        @JsonProperty("RA_OF_ASC_NODE")
        val raOfAscNode: Double? = null,

        @JsonProperty("ARG_OF_PERICENTER")
        val argOfPericenter: Double? = null,

        @JsonProperty("MEAN_ANOMALY")
        val meanAnomaly: Double? = null,

        @JsonProperty("EPHEMERIS_TYPE")
        val ephemerisType: Int? = null,

        @JsonProperty("CLASSIFICATION_TYPE")
        val classificationType: String? = null,

        @JsonProperty("NORAD_CAT_ID")
        val noradCatId: Int? = null,

        @JsonProperty("ELEMENT_SET_NO")
        val elementSetNo: Int? = null,

        @JsonProperty("REV_AT_EPOCH")
        val revAtEpoch: Int? = null,

        @JsonProperty("BSTAR")
        val bstar: Double? = null,

        @JsonProperty("MEAN_MOTION_DOT")
        val meanMotionDot: Double? = null,

        @JsonProperty("MEAN_MOTION_DDOT")
        val meanMotionDdot: Double? = null,

        @JsonProperty("SEMIMAJOR_AXIS")
        val semimajorAxis: Double? = null,

        @JsonProperty("PERIOD")
        val period: Double? = null,

        @JsonProperty("APOAPSIS")
        val apoapsis: Double? = null,

        @JsonProperty("PERIAPSIS")
        val periapsis: Double? = null,

        @JsonProperty("OBJECT_TYPE")
        val objectType: String? = null,

        @JsonProperty("RCS_SIZE")
        val rcsSize: String? = null,

        @JsonProperty("COUNTRY_CODE")
        val countryCode: String? = null,

        @JsonProperty("LAUNCH_DATE")
        val launchDate: String? = null,

        @JsonProperty("SITE")
        val site: String? = null,

        @JsonProperty("DECAY_DATE")
        val decayDate: String? = null,

        @JsonProperty("DECAYED")
        val decayed: Int? = null,

        @JsonProperty("FILE")
        val file: Int? = null,

        @JsonProperty("GP_ID")
        val gpId: Int? = null,

        @JsonProperty("TLE_LINE0")
        val tleLine0: String? = null,

        @JsonProperty("TLE_LINE1")
        val tleLine1: String? = null,

        @JsonProperty("TLE_LINE2")
        val tleLine2: String? = null
    )
}