package org.example.operation_quasar_fire.config

import org.example.operation_quasar_fire.model.entities.Position
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.example.operation_quasar_fire.model.entities.Satellite
import org.example.operation_quasar_fire.model.repository.SatellitePositionRepository
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
     * Repository for accessing satellite position.
     */
    @Autowired
    private lateinit var positionRepository: SatellitePositionRepository

    /**
     * Runs the database initialization process upon application startup.
     *
     * @param args Command-line arguments passed to the application.
     */
    override fun run(args: ApplicationArguments) {

        val position1 = positionRepository.save(Position(x = -500f, y = -200f))
        val position2 = positionRepository.save(Position(x = 100f, y = -100f))
        val position3 = positionRepository.save(Position(x = 500f, y = 100f))

        //positionRepository.saveAll(listOf(position1, position2, position3))

        val satellite1 = Satellite(name = "kenobi", distance = 100.0f, message = "Vader coming", position = position1)
        val satellite2 = Satellite(name = "skywalker", distance = 150.0f, message = "is coming", position = position2)
        val satellite3 = Satellite(name = "sato", distance = 200.0f, message = "Vader is", position = position3)

        satelliteRepository.saveAll(listOf(satellite1, satellite2, satellite3))
    }
}
