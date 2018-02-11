package com.example.demo

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        for (i in 1..10) println("BAD SIDE EFFECT!")
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

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
