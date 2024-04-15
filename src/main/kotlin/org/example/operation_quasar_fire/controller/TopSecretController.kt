package org.example.operation_quasar_fire.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
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
        ApiResponse(responseCode = "200", description = "Carrier position and message retrieved",
            content = [Content(mediaType = "application/json",
                examples = [ExampleObject(name = "200", value = "{\n  \"latitude\": 40.7128,\n  \"longitude\": -74.0060,\n  \"message\": \"We are safe\"\n}")])]),
        ApiResponse(responseCode = "400", description = "Invalid data supplied",
            content = [Content(mediaType = "application/json",
                examples = [ExampleObject(name = "400", value = "{\n  \"statusCode\": 400,\n  \"message\": \"Invalid data\"\n}")])]),
        ApiResponse(responseCode = "404", description = "Resource not found",
            content = [Content(mediaType = "application/json",
                examples = [ExampleObject(name = "404", value = "{\n  \"statusCode\": 404,\n  \"message\": \"Resource not found\"\n}")])]),
        ApiResponse(responseCode = "500", description = "Internal server error",
            content = [Content(mediaType = "application/json",
                examples = [ExampleObject(name = "500", value = "{\n  \"statusCode\": 500,\n  \"message\": \"Internal server error\"\n}")])])
    ])
    @PostMapping("/topsecret")
    fun getTopSecretLocation(
        @Parameter(description = "Satellites collection data") @RequestBody satellitesCollection: SatelliteCollectionDTO
    ): ResponseEntity<CarrierDTO> {
        return ResponseEntity.ok(this.getCarrierPositionAndMessage(satellitesCollection))
    }
}
