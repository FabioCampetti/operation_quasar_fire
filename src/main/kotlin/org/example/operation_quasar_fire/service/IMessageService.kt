package org.example.operation_quasar_fire.service

import org.springframework.stereotype.Service

@Service
interface IMessageService {
    fun getMessage(messages: List<List<String?>>): String
}
