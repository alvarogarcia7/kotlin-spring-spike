package com.example.demo.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DemoApplicationConfiguration {
    @Bean
    fun property(): Property {
        return Property("PRODUCTION")
    }
}

class Property(val value: String)
