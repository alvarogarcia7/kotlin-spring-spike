package com.example.demo

import com.example.demo.configuration.DemoApplicationConfiguration
import com.example.demo.configuration.Property
import com.example.demo.infrastructure.Webdriver
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
//the order of the Configuration classes DOES matter: the latter override the earlier
@ContextConfiguration(classes = [DemoApplicationConfiguration::class, FakeConfiguration::class])
@SpringBootTest
class RealCollaboratorsWithOverridenBeansTest {

    @Autowired
    private lateinit var webdriver: Webdriver

    @Autowired
    private lateinit var property: Property

    @Test
    fun `the application is executed but the fake objects are in place`() {
        Assertions.assertThat(webdriver.javaClass.simpleName).contains("FakeWebdriver")
        Assertions.assertThat(property.value).isEqualToIgnoringCase("TEST")
    }

}