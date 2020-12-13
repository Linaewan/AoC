package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Part1 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from a file */
		Scanner scanner = new Scanner(new File(
				"C:\\\\Users\\\\Linaewan\\\\Desktop\\\\Documents\\\\Environnements\\\\workspace\\\\adventofcode\\\\src\\\\main\\\\resources\\\\twenty\\\\Day4.txt"));
		scanner.useLocale(Locale.ENGLISH);

		scanner.useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));
		ArrayList<String> myInputList = new ArrayList<String>();
		while (scanner.hasNext()) {
			myInputList.add(String.valueOf(scanner.next()));
		}
		scanner.close();

		Integer nbValidPassports = 0;

		for (String input : myInputList) {
			if (input.contains("byr") && input.contains("iyr") && input.contains("eyr") && input.contains("hgt")
					&& input.contains("hcl") && input.contains("ecl") && input.contains("pid")) {
				nbValidPassports += 1;
			}
		}
		System.out.println(nbValidPassports);
	}
}