package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.model.entities.Satellite
import org.example.operation_quasar_fire.model.repository.SatelliteRepository
import org.springframework.stereotype.Service

@Service
class SatelliteService : ISatelliteService {

    private val sateliteRepository: SatelliteRepository? = null

    override fun getAllSatellites(): SatelliteCollectionDTO {
        val satellites = this.sateliteRepository?.findAll()
        val satelliteDTOs = satellites?.map { satelliteToDto(it) } ?: emptyList()
        return SatelliteCollectionDTO(satellites = satelliteDTOs)
    }

    override fun updateSatellite(satelliteDTO: SatelliteDTO) {
        val satellite = this.sateliteRepository?.findOneByName(satelliteDTO.name)
        if (satellite != null) {
            satellite.message = satelliteDTO.message.toString()
            satellite.distance = satelliteDTO.distance
            this.sateliteRepository?.save(satellite)
        }
    }

    private fun satelliteToDto(satellite: Satellite): SatelliteDTO {
        return SatelliteDTO(
            name = satellite.name,
            distance = satellite.distance,
            message = listOf( satellite.message)
        )
    }
}