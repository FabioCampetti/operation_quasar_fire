package org.example.operation_quasar_fire.service

/**
 * Service for processing and constructing the final message from satellite transmissions.
 */
interface IMessageService {

    /**
     * Constructs the final message from satellite transmissions.
     *
     * @param messages List of messages received from each satellite.
     * @return Constructed message.
     */
    fun getMessage(messages: List<List<String?>>): String
}