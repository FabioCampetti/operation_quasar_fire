package org.example.operation_quasar_fire.model.repository

import org.example.operation_quasar_fire.model.entities.Satellite
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SatelliteRepository : JpaRepository<Satellite, Int> {
    fun findOneByName(name: String?): Satellite?
}
