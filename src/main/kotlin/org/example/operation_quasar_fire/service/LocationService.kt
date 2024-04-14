package org.example.operation_quasar_fire.service

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver
import com.lemmingapex.trilateration.TrilaterationFunction
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer
import org.example.operation_quasar_fire.dto.PositionDTO
import org.example.operation_quasar_fire.exception.InvalidDataException
import org.example.operation_quasar_fire.model.repository.SatellitePositionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Service for calculating the location of the spaceship.
 */
@Service
class LocationService : ILocationService {

    /**
     * Repository for accessing satellite data.
     */
    @Autowired
    private lateinit var positionRepository: SatellitePositionRepository

    /**
     * Calculates the location of the spaceship based on distances from satellites.
     *
     * @param distances Distances from satellites.
     * @return Position of the spaceship.
     * @throws InvalidDataException If the distances are invalid or insufficient.
     */
    override fun getLocation(distances: List<Float?>): PositionDTO {
        val distancesDoubleArray = distances.map { it?.toDouble() ?: 0.0 }.toDoubleArray()

        val positionsArray = positionRepository.findAll().filterNotNull().map { doubleArrayOf(it.x.toDouble(), it.y.toDouble()) }

        val trilaterationFunction = positionsArray.let {
            TrilaterationFunction(
                it.toTypedArray(),
                distancesDoubleArray
            )
        }

        val nSolver = trilaterationFunction.let { NonLinearLeastSquaresSolver(it, LevenbergMarquardtOptimizer()) }
        val optimum = nSolver.solve()

        val locationArray = optimum?.point?.toArray()

        return locationArray?.let { PositionDTO(it[0].toFloat(), it[1].toFloat()) } ?: PositionDTO(0f, 0f)
    }
}
