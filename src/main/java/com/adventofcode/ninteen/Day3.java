package com.adventofcode.ninteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.adventofcode.beans.Coordinates;

public class Day3 {

	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from an external file */
		Scanner scanner = new Scanner(new File(
				"C:\\Users\\Linaewan\\Desktop\\Documents\\Environnements\\workspace\\adventofcode\\src\\main\\resources\\ninteen\\Day3.txt"));
		scanner.useLocale(Locale.ENGLISH);
		scanner.useDelimiter("\\r\\n");
		List<String> myInputList = new ArrayList<String>();
		while (scanner.hasNext()) {
			myInputList.add(scanner.next());
		}
		scanner.close();
		/** END of Read */

	}

	static List<Coordinates> getIntersectionList(List<String> wireList) {
		List<Coordinates> intersectionList = new ArrayList<Coordinates>();
		for (String wire : wireList) {
			List<Coordinates> wirePath = new ArrayList<Coordinates>();
			
		}

		Coordinates coords = new Coordinates(0, 0);
		intersectionList.add(coords);
		return intersectionList;
	}

}
