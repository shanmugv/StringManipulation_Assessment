package com.waitrose.stringmanipulation;

import com.waitrose.exception.NoNumericValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	public void testStringFunction() throws Exception {
		final BigInteger value = stringManipulationApplication.stringFunction("100klh564abc365bg");
		assertEquals(BigInteger.valueOf(564), value,
				"Verify the expected result from String Function");
	}

	@Test
	public void testNoNumericValueInStringFunction() throws Exception {
		Throwable exception = assertThrows(NoNumericValueException.class, () -> stringManipulationApplication.stringFunction("klhgjycxvkhkhjabbg"));
		assertEquals("No numeric value is present in string", exception.getMessage());
	}

	@Test
	public void testNoValuesPresentFunction() {
		Throwable exception = assertThrows(NoNumericValueException.class, () -> stringManipulationApplication.stringFunction(""));
		assertEquals("the given String is empty", exception.getMessage());
	}

	@Test
	public void testOnlyIntegerInStringFunction() throws Exception {
		String numStr = "187264817241642";
		BigInteger bigInteger = new BigInteger(numStr);
		final BigInteger value = stringManipulationApplication.stringFunction(numStr);
		assertEquals(bigInteger, value,
				"Verify the expected result from String Function");
	}

	@Test
	public void testOnlyIntegerZeroInStringFunction() throws Exception {

		BigInteger bigIntegerZero = BigInteger.ZERO;
		final BigInteger value = stringManipulationApplication.stringFunction("0");
		assertEquals(bigIntegerZero, value,
				"Verify the expected result from String Function");
	}

}
