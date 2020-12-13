package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from a file */
		Scanner scanner = new Scanner(new File(
				"C:\\\\Users\\\\Linaewan\\\\Desktop\\\\Documents\\\\Environnements\\\\workspace\\\\adventofcode\\\\src\\\\main\\\\resources\\\\twenty\\\\Day1.txt"));
		ArrayList<Integer> myInputList = new ArrayList<Integer>();
		while (scanner.hasNext()) {
			myInputList.add(Integer.valueOf(scanner.next()));
		}
		scanner.close();

		Integer res = 0;

		outerloop: for (int i = 0; i < myInputList.size(); i++) {
			for (int j = i + 1; j < myInputList.size(); j++) {
				for (int k = j + 1; k < myInputList.size(); k++) {
					res = myInputList.get(i) + myInputList.get(j) + myInputList.get(k);
					System.out.println(res);
					if (res.equals(2020)) {
						System.out.println("Solutions : " + myInputList.get(i) + "," + myInputList.get(j) + ","
								+ myInputList.get(k));
						System.out.println(
								"Resultat final : " + myInputList.get(i) * myInputList.get(j) * myInputList.get(k));
						break outerloop;
					}
				}

			}
		}
	}
}
