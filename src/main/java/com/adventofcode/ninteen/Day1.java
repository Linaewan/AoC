package com.adventofcode.ninteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day1 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from a file */
		Scanner scanner = new Scanner(new File("C:\\\\Users\\\\Linaewan\\\\Desktop\\\\Documents\\\\Environnements\\\\workspace\\\\adventofcode\\\\src\\\\main\\\\resources\\\\ninteen\\\\Day1.txt"));
		ArrayList<Integer> myInputList = new ArrayList<Integer>();
		while (scanner.hasNext()) {
			myInputList.add(Integer.valueOf(scanner.next()));
		}
		scanner.close();

		Integer totalFuelNeeded = 0;
		for (Integer mass : myInputList) {
			Integer fuelNeeded = 0;
			while (getFuelNeeded(mass) > 0) {
				fuelNeeded = getFuelNeeded(mass);
				mass = fuelNeeded;
				totalFuelNeeded = totalFuelNeeded + fuelNeeded;
			}
		}
		System.out.println(totalFuelNeeded);
	}
	
	static Integer getFuelNeeded(Integer mass) {
		return ((int) (mass / 3) - 2);
	}
}
