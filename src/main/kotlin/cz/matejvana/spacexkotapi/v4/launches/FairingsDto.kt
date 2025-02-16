package cz.matejvana.spacexkotapi.v4.launches

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data class representing the fairings information in the SpaceX API.
 *
 * @property reused Indicates if the fairings were reused.
 * @property recoveryAttempt Indicates if there was an attempt to recover the fairings.
 * @property recovered Indicates if the fairings were recovered.
 * @property ships The list of ship IDs involved in the recovery.
 */
data class FairingsDto(
    @JsonProperty("reused")
    val reused: Boolean? = null,

    @JsonProperty("recovery_attempt")
    val recoveryAttempt: Boolean? = null,

    @JsonProperty("recovered")
    val recovered: Boolean? = null,

    @JsonProperty("ships")
    val ships: List<String> = emptyList()
)