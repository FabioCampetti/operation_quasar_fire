package org.example.operation_quasar_fire.model.repository

import org.example.operation_quasar_fire.model.entities.Satellite
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for interacting with the satellite entity.
 */
@Repository
interface SatelliteRepository : JpaRepository<Satellite, Int> {
    /**
     * Finds a satellite by its name.
     *
     * @param name The name of the satellite.
     * @return The satellite with the given name, if found.
     */
    fun findOneByName(name: String?): Satellite?
}
