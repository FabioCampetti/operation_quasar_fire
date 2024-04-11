package org.example.operation_quasar_fire.entities

data class Satellite (
    var id: Int? = null,

    var name: String? = null,

    var distance: Float? = null,

    var message: String? = null,

    var poisiton: Position
)

data class SatelliteRequest (
    var satellites: List<Satellite>? = null
)