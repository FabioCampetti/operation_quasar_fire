package org.example.operation_quasar_fire.model.entitie

/**
 * Represents a carrier entity.
 */
data class Carrier (
    override var position: Position? = null,
    override var message: String? = null
): Ship
