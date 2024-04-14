package org.example.operation_quasar_fire.controller

import org.example.operation_quasar_fire.dto.ResponseDTO
import org.example.operation_quasar_fire.exception.InvalidDataException
import org.example.operation_quasar_fire.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerController : BaseController {

    @ExceptionHandler(InvalidDataException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidDataException(ex: InvalidDataException): ResponseEntity<ResponseDTO> {
        val response = ResponseDTO(HttpStatus.BAD_REQUEST.value(), ex.message ?: "Invalid data")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<ResponseDTO> {
        val response = ResponseDTO(HttpStatus.NOT_FOUND.value(), ex.message ?: "Resource not found")
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
    }
}
