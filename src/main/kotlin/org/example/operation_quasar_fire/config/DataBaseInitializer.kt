package org.example.operation_quasar_fire.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.example.operation_quasar_fire.model.entities.Satellite
import org.example.operation_quasar_fire.model.repository.SatelliteRepository
import org.springframework.beans.factory.annotation.Autowired

/**
 * Component responsible for initializing the database with default satellite data.
 */
@Component
class DatabaseInitializer : ApplicationRunner {

    /**
     * Repository for accessing satellite data.
     */
    @Autowired
    private lateinit var satelliteRepository: SatelliteRepository

    /**
     * Runs the database initialization process upon application startup.
     *
     * @param args Command-line arguments passed to the application.
     */
    override fun run(args: ApplicationArguments) {
        val satellite1 = Satellite(name = "kenobi", distance = 100.0f, message = "Vader coming")
        val satellite2 = Satellite(name = "skywalker", distance = 150.0f, message = "is coming")
        val satellite3 = Satellite(name = "sato", distance = 200.0f, message = "Vader is")

        satelliteRepository.saveAll(listOf(satellite1, satellite2, satellite3))
    }
}
