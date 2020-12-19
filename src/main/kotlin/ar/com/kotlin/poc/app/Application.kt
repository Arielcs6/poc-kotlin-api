package ar.com.kotlin.poc.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["ar.com.kotlin.poc"])
class Application

    fun main(args: Array<String>) {
        SpringApplication.run(Application::class.java, *args)
    }


