package com.example.demo.application

import com.example.demo.BasePackageScan
import com.example.demo.configuration.DemoApplicationConfiguration
import com.example.demo.infrastructure.Webdriver
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(DemoApplicationConfiguration::class)
@SpringBootApplication(scanBasePackageClasses = [BasePackageScan::class])
class DemoApplication(private val webdriver: Webdriver) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        webdriver.run()
        println("Received args:")
        for (optionName in args?.optionNames!!) {
            println(optionName)
        }
        println("Received non-args:")
        for (arg in args.nonOptionArgs) {
            println(arg)
        }
    }

}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
