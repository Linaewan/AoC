package com.adventofcode.twenty;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Day2Part1 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from a file */
		Scanner scanner = new Scanner(new File(
				"C:\\\\Users\\\\Linaewan\\\\Desktop\\\\Documents\\\\Environnements\\\\workspace\\\\adventofcode\\\\src\\\\main\\\\resources\\\\twenty\\\\Day2.txt"));
		scanner.useLocale(Locale.ENGLISH);
		// FIXME : Works only for windows, where lines are separated by \r\n
		scanner.useDelimiter("\\r\\n");
		ArrayList<String> myInputList = new ArrayList<String>();
		while (scanner.hasNext()) {
			myInputList.add(String.valueOf(scanner.next()));
		}
		scanner.close();

		Integer nbValidPwds = 0;
		String colonDelimiter = ":";
		String spaceDelimiter = "[ ]+";
		String dashDelimiter = "-";

		for (String input : myInputList) {
			String pwd = input.split(colonDelimiter)[1];
			String minAllowed = input.split(colonDelimiter)[0].split(spaceDelimiter)[0].split(dashDelimiter)[0];
			String maxAllowed = input.split(colonDelimiter)[0].split(spaceDelimiter)[0].split(dashDelimiter)[1];
			String allowedCharacter = input.split(colonDelimiter)[0].split(spaceDelimiter)[1];

			if (isValidPwd(minAllowed, maxAllowed, allowedCharacter, pwd)) {
				nbValidPwds += 1;
			}
		}

		System.out.println("Number of valid passwords is : " + nbValidPwds);
	}

	static boolean isValidPwd(String minAllowed, String maxAllowed, String allowedCharacter, String pwd) {
		boolean isValid = false;
		int count = StringUtils.countMatches(pwd, StringUtils.deleteWhitespace(allowedCharacter));
		if (count >= Integer.parseInt(minAllowed) && count <= Integer.parseInt(maxAllowed)) {
			isValid = true;
		}
		return isValid;
	}

}
