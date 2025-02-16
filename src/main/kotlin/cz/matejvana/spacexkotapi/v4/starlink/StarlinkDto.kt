package cz.matejvana.spacexkotapi.v4.starlink

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing a Starlink satellite.
 *
 * @property id The unique identifier of the satellite.
 * @property version The version of the satellite.
 * @property launch The launch identifier associated with the satellite.
 * @property longitude The longitude of the satellite's current position.
 * @property latitude The latitude of the satellite's current position.
 * @property heightKm The height of the satellite in kilometers.
 * @property velocityKms The velocity of the satellite in kilometers per second.
 * @property spaceTrack The SpaceTrack data associated with the satellite.
 */
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
    /**
     * Data class representing the SpaceTrack data of a Starlink satellite.
     *
     * @property ccsdsOmmVers The CCSDS OMM version.
     * @property comment Additional comments.
     * @property creationDate The creation date of the data.
     * @property originator The originator of the data.
     * @property objectName The name of the object.
     * @property objectId The identifier of the object.
     * @property centerName The name of the center.
     * @property refFrame The reference frame.
     * @property timeSystem The time system used.
     * @property meanElementTheory The mean element theory.
     * @property epoch The epoch of the data.
     * @property meanMotion The mean motion of the object.
     * @property eccentricity The eccentricity of the orbit.
     * @property inclination The inclination of the orbit.
     * @property raOfAscNode The right ascension of the ascending node.
     * @property argOfPericenter The argument of pericenter.
     * @property meanAnomaly The mean anomaly.
     * @property ephemerisType The ephemeris type.
     * @property classificationType The classification type.
     * @property noradCatId The NORAD catalog identifier.
     * @property elementSetNo The element set number.
     * @property revAtEpoch The revolution number at epoch.
     * @property bstar The BSTAR drag term.
     * @property meanMotionDot The first time derivative of the mean motion.
     * @property meanMotionDdot The second time derivative of the mean motion.
     * @property semimajorAxis The semi-major axis.
     * @property period The orbital period.
     * @property apoapsis The apoapsis distance.
     * @property periapsis The periapsis distance.
     * @property objectType The type of the object.
     * @property rcsSize The radar cross-section size.
     * @property countryCode The country code.
     * @property launchDate The launch date.
     * @property site The launch site.
     * @property decayDate The decay date.
     * @property decayed Indicates if the object has decayed.
     * @property file The file number.
     * @property gpId The GP identifier.
     * @property tleLine0 The TLE line 0.
     * @property tleLine1 The TLE line 1.
     * @property tleLine2 The TLE line 2.
     */
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