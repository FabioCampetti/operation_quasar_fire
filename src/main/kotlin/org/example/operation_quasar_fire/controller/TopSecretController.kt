package org.example.operation_quasar_fire.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.example.operation_quasar_fire.dto.CarrierDTO
import org.example.operation_quasar_fire.dto.SatelliteCollectionDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TopSecretController : OperationQuasarFireController() {

    @Operation(summary = "Get the carrier top secret location from satellite collection")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Carrier position and message retrieved"),
        ApiResponse(responseCode = "400", description = "Invalid data supplied"),
    ])
    @PostMapping("/topsecret")
    fun getTopSecretLocation(
        @Parameter(description = "Satellites collection data") @RequestBody satellitesCollection: SatelliteCollectionDTO
    ): ResponseEntity<CarrierDTO> {
        return ResponseEntity.ok(this.getCarrierPositionAndMessage(satellitesCollection))
    }
}
