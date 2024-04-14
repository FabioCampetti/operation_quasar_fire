package org.example.operation_quasar_fire.model.entities

import jakarta.persistence.*

/**
 * Represents a satellite entity.
 */
@Entity
@Table(name = "satellite")
data class Satellite (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "name")
    val name: String? = null,
    @Column(name = "distance")
    var distance: Float? = null,
    @Column(name = "message")
    override var message: String? = null,
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    override var position: Position? = null
): Ship
