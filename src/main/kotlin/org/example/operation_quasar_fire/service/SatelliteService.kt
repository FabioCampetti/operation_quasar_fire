package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.exceptions.ResourceNotFoundException
import org.example.operation_quasar_fire.model.entities.Satellite
import org.example.operation_quasar_fire.model.repository.SatelliteRepository
import org.springframework.stereotype.Service

@Service
class SatelliteService : ISatelliteService {

    private val satelliteRepository: SatelliteRepository? = null

    override fun getAllSatellites(): SatelliteCollectionDTO {
        val satellites = this.satelliteRepository?.findAll()
        val satelliteDTOs = satellites?.map { satelliteToDto(it) } ?: emptyList()
        return SatelliteCollectionDTO(satellites = satelliteDTOs)
    }

    override fun updateSatellite(satelliteDTO: SatelliteDTO) {
        val satelliteName = satelliteDTO.name;
        val satellite = this.satelliteRepository?.findOneByName(satelliteName)
        if (satellite != null) {
            satellite.message = satelliteDTO.message.joinToString(separator = " ")
            satellite.distance = satelliteDTO.distance
            this.satelliteRepository?.save(satellite)
        } else {
            throw ResourceNotFoundException("Satellite with name: $satelliteName  not found")
        }
    }

    private fun satelliteToDto(satellite: Satellite): SatelliteDTO {
        return SatelliteDTO(
            name = satellite.name,
            distance = satellite.distance,
            message = satellite.message?.split(" ") ?: emptyList()
        )
    }
}