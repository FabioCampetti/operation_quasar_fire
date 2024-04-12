package org.example.operation_quasar_fire.controller

import org.example.operation_quasar_fire.dto.CarrierDTO
import org.example.operation_quasar_fire.dto.PositionDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.dto.SatelliteSplitDTO
import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.model.entities.Position
import org.example.operation_quasar_fire.service.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType

@RestController
@RequestMapping("/topsecret")
class OperationQuasarFireController {
    @Autowired
    private lateinit var locationService: ILocationService
    @Autowired
    private lateinit var messageService: IMessageService
    @Autowired
    private lateinit var satelliteService: ISatelliteService


    @GetMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getLocation(@RequestBody satellitesCollection: SatelliteCollectionDTO): ResponseEntity<Position> {
        val distances = satellitesCollection.satellites.map { it.distance }
        val result = locationService.getLocation(distances)
        return ResponseEntity.ok(result)
    }

    @GetMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getMessage(@RequestBody satellitesCollection: SatelliteCollectionDTO): ResponseEntity<String> {
        val messages = satellitesCollection.satellites.map { it.message }
        val result = messageService.getMessage(messages)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/topsecret")
    fun getTopSecretLocation(@RequestBody satellitesCollection: SatelliteCollectionDTO): ResponseEntity<CarrierDTO> {
        return ResponseEntity.ok(this.getCarrierPositionAndMessage(satellitesCollection))
    }

    @PostMapping("/topsecret_split/{satelliteName}")
    fun addSatelliteInfo(@PathVariable satelliteName: String, @RequestBody satelliteSplitDTO: SatelliteSplitDTO) {
        val satelliteDTO = SatelliteDTO(satelliteName, satelliteSplitDTO.distance, satelliteSplitDTO.message)
        satelliteService.updateSatellite(satelliteDTO)
    }

    @GetMapping("/topsecret_split")
    fun getTopSecretSplit(): ResponseEntity<CarrierDTO> {
        val satellitesCollection = satelliteService.getAllSatellites()
        return ResponseEntity.ok(this.getCarrierPositionAndMessage(satellitesCollection))
    }

    private fun getCarrierPositionAndMessage(satellitesCollection: SatelliteCollectionDTO): CarrierDTO {
        val distances = satellitesCollection.satellites.map { it.distance }
        val position = locationService.getLocation(distances)
        val message = messageService.getMessage(satellitesCollection.satellites.map { it.message })
        return CarrierDTO(PositionDTO(position.x, position.y), message);
    }
}