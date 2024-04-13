package org.example.operation_quasar_fire.model.entities

/**
 * Represents a carrier entity.
 */
data class Carrier (
    val position: Position? = null,
    override var message: String? = null
): Ship
