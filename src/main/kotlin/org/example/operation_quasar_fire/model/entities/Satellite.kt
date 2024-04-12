package org.example.operation_quasar_fire.model.entities

data class Satellite (
    val id: Int? = null,
    val name: String,
    var distance: Float,
    override var message: String
): Ship
