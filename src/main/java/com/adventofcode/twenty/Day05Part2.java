package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Day05Part2 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from a file */
		Scanner scanner = new Scanner(new File(
				"C:\\\\Users\\\\Linaewan\\\\Desktop\\\\Documents\\\\Environnements\\\\workspace\\\\adventofcode\\\\src\\\\main\\\\resources\\\\twenty\\\\Day5.txt"));
		scanner.useLocale(Locale.ENGLISH);
		// FIXME : Works only for windows, where lines are separated by \r\n
		scanner.useDelimiter("\\r\\n");
		ArrayList<String> myInputList = new ArrayList<String>();
		while (scanner.hasNext()) {
			myInputList.add(String.valueOf(scanner.next()));
		}
		scanner.close();

		Map<Double, List<Double>> seatsMap = new TreeMap<>();

		for (String input : myInputList) {
			Pair<Double, Double> seatCoordinate = decodeBoardingPass(input);
			seatsMap.computeIfAbsent(seatCoordinate.getKey(), k -> new ArrayList<>()).add(seatCoordinate.getValue());
		}

		seatsMap.entrySet().stream().forEach(System.out::println);
	}

	static Pair<Double, Double> decodeBoardingPass(String boardingPass) {
		Range<Double> rowRange = Range.between(0D, 127D);
		Range<Double> columnRange = Range.between(0D, 7D);
		for (int i = 0; i <= 6; i++) {
			if (boardingPass.charAt(i) == 'F') {
				rowRange = Range.between(rowRange.getMinimum(),
						rowRange.getMinimum() + Math.floor((rowRange.getMaximum() - rowRange.getMinimum()) / 2));
			} else if (boardingPass.charAt(i) == 'B') {
				rowRange = Range.between(
						rowRange.getMinimum() + Math.ceil((rowRange.getMaximum() - rowRange.getMinimum()) / 2),
						rowRange.getMaximum());
			}
		}

		for (int i = 7; i <= 9; i++) {
			if (boardingPass.charAt(i) == 'L') {
				columnRange = Range.between(columnRange.getMinimum(), columnRange.getMinimum()
						+ Math.floor((columnRange.getMaximum() - columnRange.getMinimum()) / 2));
			} else if (boardingPass.charAt(i) == 'R') {
				columnRange = Range.between(
						columnRange.getMinimum() + Math.ceil((columnRange.getMaximum() - columnRange.getMinimum()) / 2),
						columnRange.getMaximum());
			}
		}

		return new ImmutablePair<Double, Double>(rowRange.getMaximum(), columnRange.getMaximum());

	}
}