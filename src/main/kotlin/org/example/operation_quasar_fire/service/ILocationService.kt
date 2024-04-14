package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.dto.PositionDTO
import org.example.operation_quasar_fire.exceptions.InvalidDataException

/**
* Interface for calculating the location of the spaceship.
*/
interface ILocationService {

    /**
     * Calculates the location of the spaceship based on distances from satellites.
     *
     * @param distances Distances from satellites.
     * @return Position of the spaceship.
     * @throws InvalidDataException If the distances are invalid or insufficient.
     */
    fun getLocation(distances: List<Float?>): PositionDTO
}