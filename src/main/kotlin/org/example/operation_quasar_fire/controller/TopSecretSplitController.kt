package org.example.operation_quasar_fire.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.example.operation_quasar_fire.dto.CarrierDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.dto.SatelliteSplitDTO
import org.example.operation_quasar_fire.service.ISatelliteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(tags = ["TopSecretSplit"])
@RestController
class TopSecretSplitController : OperationQuasarFireController() {

    @Autowired
    private lateinit var satelliteService: ISatelliteService

    @ApiOperation("Add information about a satellite")
    @PostMapping("/topsecret_split/{satelliteName}")
    fun addSatelliteInfo(
        @ApiParam(value = "Name of the satellite", required = true) @PathVariable satelliteName: String,
        @ApiParam("Satellite data") @RequestBody satelliteSplitDTO: SatelliteSplitDTO
    ) {
        val satelliteDTO = SatelliteDTO(satelliteName, satelliteSplitDTO.distance, satelliteSplitDTO.message)
        satelliteService.updateSatellite(satelliteDTO)
    }

    @ApiOperation("Get the carrier position and message")
    @GetMapping("/topsecret_split")
    fun getTopSecretSplit(): ResponseEntity<CarrierDTO> {
        val satellitesCollection = satelliteService.getAllSatellites()
        return ResponseEntity.ok(this.getCarrierPositionAndMessage(satellitesCollection))
    }
}
