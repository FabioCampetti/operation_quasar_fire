package org.example.operation_quasar_fire.controller

import org.example.operation_quasar_fire.dto.CarrierDTO
import org.example.operation_quasar_fire.dto.PositionDTO
import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.service.ILocationService
import org.example.operation_quasar_fire.service.IMessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topsecret")
abstract class OperationQuasarFireController : BaseController {
    @Autowired
    private lateinit var locationService: ILocationService
    @Autowired
    private lateinit var messageService: IMessageService

    protected fun getCarrierPositionAndMessage(satellitesCollection: SatelliteCollectionDTO): CarrierDTO {
        val distances = satellitesCollection.satellites.map { it.distance }
        val position = locationService.getLocation(distances)
        val message = messageService.getMessage(satellitesCollection.satellites.map { it.message })
        return CarrierDTO(PositionDTO(position.x, position.y), message);
    }
}
