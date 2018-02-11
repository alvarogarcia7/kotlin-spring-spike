package com.example.demo

import com.example.demo.application.DemoApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [DemoApplication::class])
class EndToEndTests {

    @Autowired
    lateinit var demoApplication: DemoApplication

    @Test
    fun `the application is executed`() {
        assertThat(demoApplication).isNotNull()
        runApplication<DemoApplication>("/tmp/file1", "/tmp/file3")
    }

}
