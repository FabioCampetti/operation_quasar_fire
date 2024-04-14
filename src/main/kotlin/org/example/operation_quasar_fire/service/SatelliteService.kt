package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.exceptions.ResourceNotFoundException
import org.example.operation_quasar_fire.model.entities.Satellite
import org.example.operation_quasar_fire.model.repository.SatelliteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Service class responsible for managing satellite data.
 */
@Service
class SatelliteService : ISatelliteService {

    /**
     * Repository for accessing satellite data.
     */
    @Autowired
    private lateinit var  satelliteRepository: SatelliteRepository

    /**
     * Retrieves information about all satellites.
     *
     * @return Collection of satellite data.
     */
    override fun getAllSatellites(): SatelliteCollectionDTO {
        val satellites = this.satelliteRepository.findAll()
        val satelliteDTOs = satellites.map { satelliteToDto(it) }
        return SatelliteCollectionDTO(satellites = satelliteDTOs)
    }

    /**
     * Updates information for a satellite.
     *
     * @param satelliteDTO The data of the satellite to be updated.
     * @throws ResourceNotFoundException If the satellite with the specified name is not found.
     */
    override fun updateSatellite(satelliteDTO: SatelliteDTO) {
        val satelliteName = satelliteDTO.name;
        val satellite = this.satelliteRepository?.findOneByName(satelliteName)
        if (satellite != null) {
            satellite.message = satelliteDTO.message.joinToString(separator = " ")
            satellite.distance = satelliteDTO.distance
            satellite.position = satellite.position
            this.satelliteRepository?.save(satellite)
        } else {
            throw ResourceNotFoundException("Satellite with name: $satelliteName  not found")
        }
    }

    /**
     * Converts a Satellite entity to a SatelliteDTO.
     *
     * @param satellite The satellite entity to be converted.
     * @return The corresponding SatelliteDTO.
     */
    private fun satelliteToDto(satellite: Satellite): SatelliteDTO {
        return SatelliteDTO(
            name = satellite.name,
            distance = satellite.distance,
            message = satellite.message?.split(" ") ?: emptyList()
        )
    }
}