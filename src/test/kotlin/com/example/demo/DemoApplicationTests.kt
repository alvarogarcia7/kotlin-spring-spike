package com.example.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@Import(DemoApplicationConfiguration::class)
class DemoApplicationTests {

	@Test
    fun `the context is not loaded in this case`() {
	}

}
