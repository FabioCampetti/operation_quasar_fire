package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.model.entities.Position
import org.springframework.stereotype.Service

@Service
interface ILocationService {
    fun getLocation(distances: List<Float>): Position
}
