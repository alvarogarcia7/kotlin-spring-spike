package com.example.demo

import com.example.demo.configuration.DemoApplicationConfiguration
import com.example.demo.configuration.Property
import com.example.demo.infrastructure.Webdriver
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
//the order of the Configuration classes DOES matter: the latter override the earlier
@ContextConfiguration(classes = [FakeConfiguration::class, DemoApplicationConfiguration::class])
@SpringBootTest
class MatchmakingTests {

    @Autowired
    private lateinit var webdriver: Webdriver

    @Autowired
    private lateinit var property: Property

    @Test
    fun `the application is executed but the fake objects are in place`() {
        assertThat(webdriver.javaClass.simpleName).contains("FakeWebdriver")
        assertThat(property.value).isEqualToIgnoringCase("PRODUCTION")
    }

}

@RunWith(SpringRunner::class)
//the order of the Configuration classes DOES matter: the latter override the earlier
@ContextConfiguration(classes = [DemoApplicationConfiguration::class, FakeConfiguration::class])
@SpringBootTest
class MatchmakingTestsWithOverridenBeans {

    @Autowired
    private lateinit var webdriver: Webdriver

    @Autowired
    private lateinit var property: Property

    @Test
    fun `the application is executed but the fake objects are in place`() {
        assertThat(webdriver.javaClass.simpleName).contains("FakeWebdriver")
        assertThat(property.value).isEqualToIgnoringCase("TEST")
    }

}

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