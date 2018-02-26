package com.william;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class WilliamSonoma {


	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		WilliamSonoma williamSonoma = new WilliamSonoma();
		williamSonoma.processValuesFromConsole();
		
	}
/**
 *  This method will allow user to enter input in console.
 */
	public void processValuesFromConsole() {

		boolean completed = false;
		List<Integer[]> zipcodes = new ArrayList<Integer[]>();

		do {
			System.out.print("Enter the zipcode start range :  ");
			int startZipcode = Integer.valueOf(getNextValue()).intValue();

			System.out.print("Enter the zipcode end range : ");
			int endZipcode = Integer.valueOf(getNextValue()).intValue();

			if (startZipcode <= endZipcode) {
				zipcodes.add(new Integer[] { startZipcode, endZipcode });
			} else {
				System.out.println("First value should be less than second value. Reneter the values");
			}

			System.out.print("Press 'Enter' to give more inputs (or) Enter  'X' to exit and process the zipcodes");

			if ("X".equalsIgnoreCase(scanner.nextLine())) {
				completed = true;
			}
		} while (!completed);

		scanner.close();

		processZipCodes(zipcodes);
	}

	/**
	 * This method process the zipCodes
	 * @param zipcodes
	 */
	public void processZipCodes(List<Integer[]> zipcodes) {
		
		System.out.println("\n Entered zipcodes : ");
		for (Integer[] arr : zipcodes) {
			System.out.println(Arrays.toString(arr));
		}

		Collections.sort(zipcodes, new Comparator<Integer[]>() {
			public int compare(Integer[] firstRow, Integer[] nextRow) {
				return firstRow[0].compareTo(nextRow[0]);
			}
		});

		int arraySize = zipcodes.size();
		for (int i1 = 0; i1 < arraySize ; i1++) {
			
			if(!validateZipcode(zipcodes.get(i1)[0].toString()) || !validateZipcode(zipcodes.get(i1)[1].toString())) {
				System.out.println("Invalid Zipcode");
				return;
			}
			
			if(zipcodes.get(i1)[0] > zipcodes.get(i1)[1]) {
				System.out.println("First value should be less than second value. Reneter the values");
				return;
			}
			
			if(arraySize == i1+1) {
				break;
			}
			
			if (zipcodes.get(i1)[1] +1 >= zipcodes.get(i1 + 1)[0]) {
				zipcodes.get(i1)[1] = Math.max(zipcodes.get(i1)[1],zipcodes.get(i1 + 1)[1]);
				zipcodes.remove(i1 + 1);
				i1 = i1 - 1;
				arraySize--;
			}
		}
		
		System.out.println("*********** After Processing ************");

		for (Integer[] arr : zipcodes) {
			System.out.println(Arrays.toString(arr));
		}
			

	}
	
	/**
	 * This method validates entered zipCode and forces the user to enter valid zipCode
	 * @return zipCode
	 */
	private String getNextValue() {
		String zipCode = scanner.nextLine();
		if (!validateZipcode(zipCode)) {
			System.out.println("Invalid zipcode, Reenter the zipcode : ");
			zipCode = getNextValue();
		}
		return zipCode;
	}

	/**
	 * This method validates zipCode
	 * @param zipcode
	 * @return zipCode validity
	 */
	
	private boolean validateZipcode(String zipcode) {
		if (zipcode != null && zipcode.matches("[0-9]+") && zipcode.length() == 5) {
			return true;
		}
		return false;
	}

}
