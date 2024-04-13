package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.exceptions.ResourceNotFoundException

/**
 * Interface for managing satellite data.
 */
interface ISatelliteService {

    /**
     * Retrieves information about all satellites.
     *
     * @return Collection of satellite data.
     */
    fun getAllSatellites(): SatelliteCollectionDTO

    /**
     * Updates information for a satellite.
     *
     * @param satelliteDTO The data of the satellite to be updated.
     * @throws ResourceNotFoundException If the satellite with the specified name is not found.
     */
    fun updateSatellite(satelliteDTO: SatelliteDTO)
}