package org.example.operation_quasar_fire.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception to indicate invalid data received or processed by the application.
 *
 * @param message A description of the invalid data.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(message: String) : RuntimeException(message)