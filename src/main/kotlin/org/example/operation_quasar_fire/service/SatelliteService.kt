package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.model.entities.Satellite
import org.example.operation_quasar_fire.model.repository.SatelliteRepository

class SatelliteService {
    private val sateliteRepository: SatelliteRepository? = null

    fun getSatellite(): SatelliteDTO {
        return SatelliteDTO(toString(), 0.0f, listOf(toString()))
    }

    fun saveSatellite(satelliteDTO: SatelliteDTO) {
        this.sateliteRepository?.save(dtoToSatellite(satelliteDTO))
    }

    private fun dtoToSatellite(satelliteDTO: SatelliteDTO): Satellite {
        return Satellite(
            name = satelliteDTO.name,
            distance = satelliteDTO.distance,
            message = satelliteDTO.message.toString()
        )
    }
}