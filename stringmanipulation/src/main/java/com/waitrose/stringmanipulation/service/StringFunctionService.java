package com.waitrose.stringmanipulation.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringFunctionService {

    private final Logger log = LoggerFactory.getLogger(StringFunctionService.class);

    public BigInteger stringFunction(String value) throws Exception {

        log.info("The string is: {}", value);
        String regex = "//d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(value);

        BigInteger maxNum = BigInteger.ZERO;

        while(match.find()) {

            BigInteger num = new BigInteger(match.group());
            if(num.compareTo(maxNum) >0) {
                maxNum = num;
            }
        }
        log.info("The maximum numeric value in above string is: {}", maxNum);
        return maxNum;
    }


}
