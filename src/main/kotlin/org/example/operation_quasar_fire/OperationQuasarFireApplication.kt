package org.example.operation_quasar_fire

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("org.example.operation_quasar_fire.model.entities")
@EnableJpaRepositories("org.example.operation_quasar_fire.model.repository")
class OperationQuasarFireApplication

fun main(args: Array<String>) {
	runApplication<OperationQuasarFireApplication>(*args)
}
