package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.exceptions.InvalidDataException
import org.example.operation_quasar_fire.model.entities.Position
import org.springframework.stereotype.Service

/**
 * Service for calculating the location of the spaceship.
 */
@Service
class LocationService : ILocationService {

    /**
     * Calculates the location of the spaceship based on distances from satellites.
     *
     * @param distances Distances from satellites.
     * @return Position of the spaceship.
     * @throws InvalidDataException If the distances are invalid or insufficient.
     */
    override fun getLocation(distances: List<Float?>): Position {
        val satellitesDistances = distances.filterNotNull()
        if (satellitesDistances.size < distances.size  || distances.size < 3) {
            throw InvalidDataException("Invalid distances from satellites")
        }
        val calculatedPosition = trilaterate(satellitesDistances.toFloatArray(),  floatArrayOf())
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
