package org.example.operation_quasar_fire.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception to indicate that a requested resource was not found.
 *
 * @param message A description of the resource not found.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidDataException (message: String) : RuntimeException(message)