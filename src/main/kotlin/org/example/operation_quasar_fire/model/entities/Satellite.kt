package org.example.operation_quasar_fire.model.entities

import jakarta.persistence.*

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
    var message: String? = null
){
    constructor() : this(null, null, null, null)
}