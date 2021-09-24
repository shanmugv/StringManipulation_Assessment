package com.waitrose.stringmanipulation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class StringManipulationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StringManipulationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String str = "100klh564abc365bg";
		System.out.println("The string is: " + str);
		String regex = "\\d+";
		Pattern ptrn = Pattern.compile(regex);
		Matcher match = ptrn.matcher(str);
		int maxNum = 0;
		while(match.find()) {
			int num = Integer.parseInt(match.group());
			if(num > maxNum) {
				maxNum = num;
			}
		}
		System.out.println("The maximum numeric value in above string is: " + maxNum);
	}
}
