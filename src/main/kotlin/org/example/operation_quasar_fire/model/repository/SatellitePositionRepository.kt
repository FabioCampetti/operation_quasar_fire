package org.example.operation_quasar_fire.model.repository

import org.example.operation_quasar_fire.model.entitie.Position
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for interacting with the position entity.
 */
@Repository
interface SatellitePositionRepository : JpaRepository<Position, Int> {
}
