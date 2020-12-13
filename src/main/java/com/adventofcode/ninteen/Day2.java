package com.adventofcode.ninteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Day2 {
	public static void main(String[] args) throws FileNotFoundException {

		/** Reading the input from an external file */
		Scanner scanner = new Scanner(new File(
				"C:\\Users\\Linaewan\\Desktop\\Documents\\Environnements\\workspace\\adventofcode\\src\\main\\resources\\ninteen\\Day2.txt"));
		scanner.useLocale(Locale.ENGLISH);
		scanner.useDelimiter(",");

		List<Integer> myInputList = new ArrayList<Integer>();
		while (scanner.hasNext()) {
			myInputList.add(Integer.valueOf(scanner.next()));
		}
		scanner.close();
		/** END OF Read */

		/** Part I */
//		List<Integer> intcodeList = applyOpcodeFormula(myInputList);
		/** END OF Part I */

		/** Part II */
		Integer result = 0;
		outerloop: for (int i = 0; i < 100; i++) {
			myInputList.set(1, i);
			for (int j = 0; j < 100; j++) {
				myInputList.set(2, j);
				List<Integer> intcodeList = applyOpcodeFormula(myInputList);
				result = intcodeList.get(0);
				if (result.equals(19690720) || (i == 99 && j == 99)) {
					System.out.println(result + "," + i + "," + j);
					break outerloop;
				}
			}
		}
		/** ENDOF Part II */
	}

	static Integer getOpcodes(List<Integer> myInputList, Integer position) {
		return myInputList.get(position);
	}

	static List<Integer> applyOpcodeFormula(List<Integer> myInputList) {
		List<Integer> updatedList = new ArrayList<Integer>();
		updatedList.addAll(myInputList);
		for (int i = 0; i <= (int) updatedList.size() / 4; i++) {
			Integer opcode = getOpcodes(updatedList, i * 4);
			Integer index = i * 4;
			if (!opcode.equals(99)) {
				switch (opcode) {
				case 1:
					updatedList.set(updatedList.get(index + 3),
							updatedList.get(updatedList.get(index + 1)) + updatedList.get(updatedList.get(index + 2)));
					break;
				case 2:
					updatedList.set(updatedList.get(index + 3),
							updatedList.get(updatedList.get(index + 1)) * updatedList.get(updatedList.get(index + 2)));
					break;
				default:
					break;
				}
			} else {
				break;
			}
		}
		return updatedList;
	}

}
