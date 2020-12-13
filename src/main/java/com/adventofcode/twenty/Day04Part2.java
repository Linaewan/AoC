package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Day04Part2 {
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

		String spaceOrNewLineDelimiter = "[ ]+|\\r\\n";
		String commaDelimiter = ":";
		Integer nbValidPassports = 0;
//		List eyeColorsList = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

		for (String input : myInputList) {
			input = input.replace("\n", " ").replace("\r", " ");
			if (input.contains("byr") && input.contains("iyr") && input.contains("eyr") && input.contains("hgt")
					&& input.contains("hcl") && input.contains("ecl") && input.contains("pid")) {
				String[] passportFields = input.split(spaceOrNewLineDelimiter);
				boolean isByrValid = false;
				boolean isIyrValid = false;
				boolean isEyrValid = false;
				boolean isHgtValid = false;
				boolean isHclValid = false;
				boolean isEclValid = false;
				boolean isPidValid = false;
				for (String field : passportFields) {
					if (field != null && !field.isEmpty()) {
						String value = field.split(commaDelimiter)[1];
						if (field.contains("byr") && value.length() == 4 && Integer.parseInt(value) >= 1920
								&& Integer.parseInt(value) <= 2002) {
							isByrValid = true;
						} else if (field.contains("iyr") && value.length() == 4 && Integer.parseInt(value) >= 2010
								&& Integer.parseInt(value) <= 2020) {
							isIyrValid = true;
						} else if (field.contains("eyr") && value.length() == 4 && Integer.parseInt(value) >= 2020
								&& Integer.parseInt(value) <= 2030) {
							isEyrValid = true;
						} else if (field.contains("hgt") && (value.contains("cm") || value.contains("in"))) {
							if (value.contains("cm")) {
								value = value.replace("cm", StringUtils.EMPTY);
								if (Integer.parseInt(value) >= 150 && Integer.parseInt(value) <= 193) {
									isHgtValid = true;
								}
							} else if (value.contains("in")) {
								value = value.replace("in", StringUtils.EMPTY);
								if (Integer.parseInt(value) >= 59 && Integer.parseInt(value) <= 76) {
									isHgtValid = true;
								}
							}
						} else if (field.contains("hcl") && value.startsWith("#")
								&& Pattern.matches("[a-f0-9]+{7}", value.substring(1))) {
							isHclValid = true;
						} else if (field.contains("ecl") && (value.equals("amb") || value.equals("blu")
								|| value.equals("brn") || value.equals("gry") || value.equals("hzl")
								|| value.equals("grn") || value.equals("oth"))) {
							isEclValid = true;
						} else if (field.contains("pid") && Pattern.matches("\\d{9}$", value)) {
							isPidValid = true;
						}

					}

				}
				if (isByrValid && isIyrValid && isEyrValid && isHgtValid && isHclValid && isEclValid && isPidValid) {
					nbValidPassports += 1;
				}
			}
		}
		System.out.println(nbValidPassports);
	}
}