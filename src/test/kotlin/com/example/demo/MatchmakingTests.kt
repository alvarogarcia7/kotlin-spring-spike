package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
//the order of the Configuration classes does not matter
@ContextConfiguration(classes = [FakeConfiguration::class, DemoApplicationConfiguration::class])
@SpringBootTest
class MatchmakingTests {

    @Autowired
    private lateinit var webdriver: Webdriver

    @Test
    fun `the application is executed but the fake objects are in place`() {
        assertThat(webdriver.javaClass.simpleName).contains("FakeWebdriver")
    }

}

@Configuration
class FakeConfiguration {
    @Bean
    fun fakeWebdriver(): Webdriver {
        return FakeWebdriver()
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