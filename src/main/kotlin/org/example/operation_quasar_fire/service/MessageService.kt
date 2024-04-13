package org.example.operation_quasar_fire.service

import org.example.operation_quasar_fire.exceptions.InvalidDataException
import org.springframework.stereotype.Service

@Service
class MessageService : IMessageService {

    override fun getMessage(messages: List<List<String?>>): String {
        if (messages.any { it.any { it == null } }) {
            throw InvalidDataException("Invalid message from satellite")
        }

        val maxSize = messages.map { it.size }.maxOrNull() ?: throw InvalidDataException("Invalid message size")

        val listMessage = Array<String?>(maxSize) { null }

        for (i in (maxSize - 1) downTo 0) {
            for (message in messages) {
                if (i < message.size && message[i]?.isNotBlank() == true) {
                    listMessage[i] = message[i]
                }
            }
        }

        return listMessage.filterNotNull().joinToString(" ")
    }
}