package com.example.demo

import com.example.demo.configuration.Property
import com.example.demo.infrastructure.Webdriver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FakeConfiguration {
    @Bean
    fun fakeWebdriver(): Webdriver {
        return FakeWebdriver()
    }

    @Bean
    fun property(): Property {
        return Property("TEST")
    }
}

class FakeWebdriver : Webdriver {
    constructor() {
        //this will also execute the parent constructor
        println("in fakewebdriver constructor")
    }

    override fun run() {
        //this will override the parent `run` function, thus removing the BAD SIDE EFFECT!
        println("FakeWebdriver running")
    }
}