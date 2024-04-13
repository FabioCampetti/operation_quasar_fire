package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.springframework.stereotype.Service

@Service
interface ISatelliteService {

    fun getAllSatellites(): SatelliteCollectionDTO

    fun updateSatellite(satelliteDTO: SatelliteDTO)
}