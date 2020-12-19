package ar.com.kotlin.poc.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["ar.com.kotlin.poc"])
@EnableJpaRepositories("ar.com.kotlin.poc.repository")
@EntityScan("ar.com.kotlin.poc.domain")
class Application

    fun main(args: Array<String>) {
        SpringApplication.run(Application::class.java, *args)
    }


