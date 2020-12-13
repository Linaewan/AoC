package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day06Part1 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from a file */
		Scanner scanner = new Scanner(new File(
				"C:\\\\Users\\\\Linaewan\\\\Desktop\\\\Documents\\\\Environnements\\\\workspace\\\\adventofcode\\\\src\\\\main\\\\resources\\\\twenty\\\\Day6.txt"));
		scanner.useLocale(Locale.ENGLISH);
		scanner.useDelimiter(Pattern.compile("^\\s*$", Pattern.MULTILINE));

		ArrayList<String> myInputList = new ArrayList<String>();
		while (scanner.hasNext()) {
			myInputList.add(String.valueOf(scanner.next()));
		}
		scanner.close();
		Integer res = 0;
		for (String input : myInputList) {
			res = res + getDistinctChars(input).size();
		}

		System.out.println(res);
	}

	static List<Character> getDistinctChars(String groupInput) {
		List<Character> distinctCharacters = new ArrayList<Character>();
		for(int i=0; i < groupInput.length(); i++) {
			if(Character.isLetterOrDigit(groupInput.charAt(i)) && !distinctCharacters.contains(groupInput.charAt(i))) {
				distinctCharacters.add(groupInput.charAt(i));
			}
		}
		return distinctCharacters;
	}

}