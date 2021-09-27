package com.waitrose.stringmanipulation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StringManipulationApplicationTests {

	private static final String[] ARGS = {};

	@InjectMocks
	private StringManipulationApplication stringManipulationApplication;

	@Test
	@DisplayName("verifying application starts")
	void applicationStarts() throws Exception {
		StringManipulationApplication.main(ARGS);
	}
}