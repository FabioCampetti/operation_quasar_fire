package org.example.operation_quasar_fire.controller

import org.example.operation_quasar_fire.dto.CarrierDTO
import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.example.operation_quasar_fire.service.ILocationService
import org.example.operation_quasar_fire.service.IMessageService
import org.springframework.beans.factory.annotation.Autowired

abstract class OperationQuasarFireController : BaseController {
    @Autowired
    private lateinit var locationService: ILocationService
    @Autowired
    private lateinit var messageService: IMessageService

    protected fun getCarrierPositionAndMessage(satellitesCollection: SatelliteCollectionDTO): CarrierDTO {
        val distances = satellitesCollection.satellites.map { it.distance }
        val messages = satellitesCollection.satellites.map { it.message}
        val position = locationService.getLocation(distances)
        val message = messageService.getMessage(messages)
        return CarrierDTO(position, message);
    }
}
