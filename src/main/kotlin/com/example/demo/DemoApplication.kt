package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DemoApplicationConfiguration::class)
class DemoApplication : ApplicationRunner {
    @Autowired
    lateinit var webdriver: Webdriver;

    override fun run(args: ApplicationArguments?) {
        webdriver.run()
        println("Received args:")
        for (optionName in args?.optionNames!!) {
            println(optionName)
        }
        println("Received non-args:")
        for (arg in args?.nonOptionArgs) {
            println(arg)
        }
    }

}

@Configuration
class DemoApplicationConfiguration {

    @Bean
    fun webdriver(): Webdriver {
        return Webdriver()
    }
}

class Webdriver {
    constructor() {
        println("Webdriver constructor")
    }

    fun run() {
        for (i in 1..10) println("BAD SIDE EFFECT!")
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
