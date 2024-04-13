package org.example.operation_quasar_fire.dto

/**
 * Data Transfer Object (DTO) representing data sent to the /topsecret_split endpoint.
 */
data class SatelliteSplitDTO(
    val distance: Float,
    val message: List<String>
)
