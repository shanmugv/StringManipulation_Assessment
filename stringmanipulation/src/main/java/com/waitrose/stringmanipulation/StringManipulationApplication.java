package com.waitrose.stringmanipulation;

import com.waitrose.exception.NoNumericValueException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class StringManipulationApplication  {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StringManipulationApplication.class, args);
		StringManipulationApplication stringManipulationApplication = new StringManipulationApplication();
		stringManipulationApplication.stringFunction("1002543dgfhfgh6635252");
	}


	public BigInteger stringFunction(String value) throws Exception {
		if(StringUtils.isNotBlank(value)){
			System.out.println("The string is: " + value);
			boolean flag = false;
			String regex = "\\d+";
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(value);

			BigInteger maxNum = BigInteger.ZERO;

			while(match.find()) {
				flag=true;
				BigInteger num = new BigInteger(match.group());
				if(num.compareTo(maxNum) >0) {
					maxNum = num;
				}
			}
			if(flag){
				System.out.println("The maximum numeric value in above string is: " + maxNum);
				return maxNum;
			} else{
				throw new NoNumericValueException("No numeric value is present in string");
			}
		}else {
			throw new NoNumericValueException("the given String is empty");
		}

	}
}