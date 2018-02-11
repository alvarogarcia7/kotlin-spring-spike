package com.example.demo.infrastructure

import org.springframework.stereotype.Component

@Component
class Webdriver {

    constructor() {
        println("Webdriver constructor")
    }

    fun run() {
        for (i in 1..10) println("BAD SIDE EFFECT!")
    }
}