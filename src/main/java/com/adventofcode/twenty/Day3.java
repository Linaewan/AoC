package com.adventofcode.twenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Day3 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from a file */
		Scanner scanner = new Scanner(new File(
				"C:\\\\Users\\\\Linaewan\\\\Desktop\\\\Documents\\\\Environnements\\\\workspace\\\\adventofcode\\\\src\\\\main\\\\resources\\\\twenty\\\\Day3.txt"));
		scanner.useLocale(Locale.ENGLISH);
		// FIXME : Works only for windows, where lines are separated by \r\n
		scanner.useDelimiter("\\r\\n");
		ArrayList<String> myInputList = new ArrayList<String>();
		while (scanner.hasNext()) {
			myInputList.add(String.valueOf(scanner.next()));
		}
		scanner.close();

		Double nbTrees1 = 0D;
		Integer x1 = 0;
		for (int i = 1; i < myInputList.size(); i++) {
			x1 = (x1 + 1) % (myInputList.get(0).length());
			if (isTree(myInputList.get(i).charAt(x1))) {
				nbTrees1 += 1;
			}
		}
		System.out.println("Number of trees for slope 1 : " + nbTrees1);
		
		Double nbTrees2 = 0D;
		Integer x2 = 0;
		for (int i = 1; i < myInputList.size(); i++) {
			x2 = (x2 + 3) % (myInputList.get(0).length());
			if (isTree(myInputList.get(i).charAt(x2))) {
				nbTrees2 += 1;
			}
		}
		System.out.println("Number of trees for slope 2: " + nbTrees2);
		
		Double nbTrees3 = 0D;
		Integer x3 = 0;
		for (int i = 1; i < myInputList.size(); i++) {
			x3 = (x3 + 5) % (myInputList.get(0).length());
			if (isTree(myInputList.get(i).charAt(x3))) {
				nbTrees3 += 1;
			}
		}
		System.out.println("Number of trees for slope 3: " + nbTrees3);
		
		Double nbTrees4 = 0D;
		Integer x4 = 0;
		for (int i = 1; i < myInputList.size(); i++) {
			x4 = (x4 + 7) % (myInputList.get(0).length());
			if (isTree(myInputList.get(i).charAt(x4))) {
				nbTrees4 += 1;
			}
		}
		System.out.println("Number of trees for slope 4: " + nbTrees4);
		
		Double nbTrees5 = 0D;
		Integer x5 = 0;
		for (int i = 2; i < myInputList.size(); i=i+2) {
			x5 = (x5 + 1) % (myInputList.get(0).length());
			if (isTree(myInputList.get(i).charAt(x5))) {
				nbTrees5 += 1;
			}
		}
		System.out.println("Number of trees for slope 5: " + nbTrees5);
		
		Double res = nbTrees1*nbTrees2*nbTrees3*nbTrees4*nbTrees5;
		System.out.println("Final result is: " + res);
	}

	static boolean isTree(char square) {
		if (square == '#') {
			return true;
		} else {
			return false;
		}

	}
}
