package org.example.operation_quasar_fire.model.entities

data class Carrier (
    val position: Position? = null,
    override var message: String? = null
): Ship
