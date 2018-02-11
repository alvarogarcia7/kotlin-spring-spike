package com.example.demo

import com.example.demo.application.DemoApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.DefaultApplicationArguments
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [DemoApplication::class])
class FullContextTests {

    @Autowired
    lateinit var demoApplication: DemoApplication

    @Test
    fun `the application is executed, but needs to be started manually`() {
        assertThat(demoApplication).isNotNull()
        val args = arrayOf("/tmp/file1", "/tmp/file3")
        demoApplication.run(DefaultApplicationArguments(args))
    }

}
