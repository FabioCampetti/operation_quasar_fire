package org.example.operation_quasar_fire.dto

/**
 * Data Transfer Object (DTO) for representing satellite data.
 */
data class SatelliteDTO(
    val name: String? = null,
    val distance: Float? = null,
    val message: List<String?>
)
