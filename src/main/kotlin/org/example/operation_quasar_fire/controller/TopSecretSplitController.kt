package org.example.operation_quasar_fire.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.example.operation_quasar_fire.dto.CarrierDTO
import org.example.operation_quasar_fire.dto.SatelliteDTO
import org.example.operation_quasar_fire.dto.SatelliteSplitDTO
import org.example.operation_quasar_fire.service.ISatelliteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TopSecretSplitController : OperationQuasarFireController() {

    @Autowired
    private lateinit var satelliteService: ISatelliteService

    @Operation(summary = "Add information about a satellite")
    @PostMapping("/topsecret_split/{satelliteName}")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Satellite information added"),
        ApiResponse(responseCode = "400", description = "Invalid data supplied"),
    ])
    fun addSatelliteInfo(
        @Parameter(description = "Name of the satellite", required = true) @PathVariable satelliteName: String,
        @Parameter(description = "Satellite data") @RequestBody satelliteSplitDTO: SatelliteSplitDTO
    ) {
        val satelliteDTO = SatelliteDTO(satelliteName, satelliteSplitDTO.distance, satelliteSplitDTO.message)
        satelliteService.updateSatellite(satelliteDTO)
    }

    @Operation(summary ="Get carrier position and message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Carrier position and message retrieved"),
        ApiResponse(responseCode = "404", description = "No data found"),
    ])
    @GetMapping("/topsecret_split")
    fun getTopSecretSplit(): ResponseEntity<CarrierDTO> {
        val satellitesCollection = satelliteService.getAllSatellites()
        return ResponseEntity.ok(this.getCarrierPositionAndMessage(satellitesCollection))
    }
}
