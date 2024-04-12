package org.example.operation_quasar_fire.service

import org.springframework.stereotype.Service

@Service
class MessageService {
    fun getMessage(messages: List<List<String>>): String {
        val maxSize = messages.map { it.size }.maxOrNull() ?: throw Exception("Message size invalid.")

        val listMessage = Array<String?>(maxSize) { null }

        for (i in (maxSize - 1) downTo 0) {
            for (message in messages) {
                if (i < message.size && message[i].isNotBlank()) {
                    listMessage[i] = message[i]
                }
            }
        }

        return listMessage.filterNotNull().joinToString(" ")
    }
}