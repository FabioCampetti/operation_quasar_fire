package org.example.operation_quasar_fire.model.entitie

import jakarta.persistence.*

/**
 * Represents a position with x and y coordinates.
 */
@Entity
@Table(name = "satellitePosition")
data class Position(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "x")
    val x: Float = 0f,
    @Column(name = "y")
    val y: Float = 0f
)
