package org.example.entities

data class Satelite (
    var id: Int? = null,

    var name: String? = null,

    var distance: Float? = null,

    var message: String? = null,

    var poisiton: Pair<Float, Float>
)

data class SateliteRequest (
    var satellites: List<Satelite>? = null
)
