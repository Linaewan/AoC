package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.commons.lang3.Range;

public class Day5Part1 {
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
		
		List<Double> seatIdsList = new ArrayList<>();
		
		for (String input : myInputList) {
			seatIdsList.add(decodeBoardingPass(input));
		}

		System.out.println(seatIdsList.stream().max(Comparator.naturalOrder()).get());
	}

	static Double decodeBoardingPass(String boardingPass) {
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
		
		Double seatID = (rowRange.getMaximum() * 8) + columnRange.getMaximum();
		System.out.println(
				"Row : " + rowRange.getMaximum() + " Column ID : " + columnRange.getMaximum() + " Seat ID : " + seatID);

		return seatID;
	}
}