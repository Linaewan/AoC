package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Day6Part2 {
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
			res = res + getCommunChars(input).size();
		}
		System.out.println(res);
	}

	static Set<Character> getCommunChars(String groupInput) {
		List<String> personInputList = new ArrayList<String>(Arrays.asList(groupInput.split("\\r?\\n")));
		personInputList.removeAll(Arrays.asList("", null));
		Set<Character> commonChars = convertStringToSetOfChars(personInputList.get(0));
		personInputList.stream().skip(1).forEach(s -> commonChars.retainAll(convertStringToSetOfChars(s)));

		return commonChars;
	}
	

    private static Set<Character> convertStringToSetOfChars(String string) {
        Set<Character> set = new HashSet<>(string.length() + 10);
        for (char c : string.toCharArray()) {
            set.add(c);
        }

        return set;
    }

}