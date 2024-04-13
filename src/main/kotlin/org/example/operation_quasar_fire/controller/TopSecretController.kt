package org.example.operation_quasar_fire.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.example.operation_quasar_fire.dto.CarrierDTO
import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["TopSecret"])
@RestController
class TopSecretController : OperationQuasarFireController() {

    @ApiOperation("Get the top secret location from satellites collection")
    @PostMapping("/topsecret")
    fun getTopSecretLocation(
        @ApiParam("Satellites collection data") @RequestBody satellitesCollection: SatelliteCollectionDTO
    ): ResponseEntity<CarrierDTO> {
        return ResponseEntity.ok(this.getCarrierPositionAndMessage(satellitesCollection))
    }
}
