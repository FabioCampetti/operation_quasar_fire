package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.model.entities.Position

class LocationService {
    fun getLocation(distances: List<Float>): Position {
        val calculatedPosition = trilaterate(distances.toFloatArray(),  floatArrayOf())
        return Position(calculatedPosition[0], calculatedPosition[1])
    }

    private fun trilaterate(distances: FloatArray, positions: FloatArray): FloatArray {
        var sumX = 0.0f
        var sumY = 0.0f
        var sumWeights = 0.0f

        for (i in positions.indices step 2) {
            val weight = 1.0f / distances[i / 2]
            sumX += positions[i] * weight
            sumY += positions[i + 1] * weight
            sumWeights += weight
        }

        return floatArrayOf(sumX / sumWeights, sumY / sumWeights)
    }
}
