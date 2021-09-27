package com.waitrose.stringmanipulation.service;

import com.waitrose.stringmanipulation.controller.StringFunctionController;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StringFunctionServiceTest {

    @InjectMocks
    private StringFunctionService stringFunctionService;

    @Mock
    private StringFunctionController stringFunctionController;

    public StringFunctionServiceTest() {
        stringFunctionController = new StringFunctionController();
        stringFunctionService = new StringFunctionService();
    }

    @Test
    public void testStringFunction() throws Exception {
        final BigInteger value = stringFunctionService.stringFunction("100klh564abc365bg");
        assertEquals(BigInteger.valueOf(564), value,
                "Verify the expected result from String Function");
    }

    @Test
    public void testNoNumericValueInStringFunction() throws Exception {
        final BigInteger value = stringFunctionService.stringFunction("klhsgdfbxcbabcbg");
        assertEquals(BigInteger.ZERO, value,
                "Verify the expected result from String Function");
    }

    @Test
    public void testOnlyIntegerInStringFunction() throws Exception {
        String numStr = "187264817241642";
        BigInteger bigInteger = new BigInteger(numStr);
        final BigInteger value = stringFunctionService.stringFunction(numStr);
        assertEquals(bigInteger, value,
                "Verify the expected result from String Function");
    }

    @Test
    public void testOnlyIntegerZeroInStringFunction() throws Exception {

        BigInteger bigIntegerZero = BigInteger.ZERO;
        final BigInteger value = stringFunctionService.stringFunction("0");
        assertEquals(bigIntegerZero, value,
                "Verify the expected result from String Function");
    }

    @Test
    public void testStringFunctionSupportBigNumbers() throws Exception {
        String numStr = "1233243487164814572";
        BigInteger bigInteger = new BigInteger(numStr);
        final BigInteger value = stringFunctionService.stringFunction("100klh564abc365bg1233243487164814572");
        assertEquals(bigInteger, value,
                "Verify the expected result from String Function");
    }


}
