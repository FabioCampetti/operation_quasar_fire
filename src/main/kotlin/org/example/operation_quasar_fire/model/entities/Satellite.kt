package org.example.operation_quasar_fire.model.entities

data class Satellite (
    val id: Int? = null,
    val name: String? = null,
    val distance: Float? = null,
    override var message: String? = null
): Ship
