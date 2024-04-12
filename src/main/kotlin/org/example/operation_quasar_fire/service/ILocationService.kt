package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.model.entities.Position

interface ILocationService {
    fun getLocation(distances: List<Float>): Position
}
