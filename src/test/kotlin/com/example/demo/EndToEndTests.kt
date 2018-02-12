package com.example.demo

import com.example.demo.application.DemoApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [DemoApplication::class])
class EndToEndTests {

    @Test
    fun `the application is executed, as in production`() {
        //does not have any arguments
    }

}
