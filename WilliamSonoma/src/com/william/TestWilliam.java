package com.william;

import java.util.ArrayList;
import java.util.List;



public class TestWilliam {

	WilliamSonoma william = new WilliamSonoma();
	
	public void continuousZipcodes() {
		 List<Integer[]> zipcodes = new ArrayList<Integer[]>();
		 
		 zipcodes.add(new Integer[] {12345,12346});
		 zipcodes.add(new Integer[] {12346,12349});
		 zipcodes.add(new Integer[] {12341,12343});
		 zipcodes.add(new Integer[] {12351,12354});
		 
		 zipcodes.add(new Integer[] {12356,12358}); 
		 zipcodes.add(new Integer[] {12359,12368});
		 
         william.processZipCodes(zipcodes);
	}
	
	
	public void invalidzipCode() {
		 List<Integer[]> zipcodes = new ArrayList<Integer[]>();
		 zipcodes.add(new Integer[] {12345,12347});
		 zipcodes.add(new Integer[] {12346,12349});
		 zipcodes.add(new Integer[] {12341,12343});
		 zipcodes.add(new Integer[] {12351,12354});
		 
		 zipcodes.add(new Integer[] {12351,123545});
		 
		william.processZipCodes(zipcodes);
	}
	
	public void invalidzipCodeOrder() {
		 List<Integer[]> zipcodes = new ArrayList<Integer[]>();
		 zipcodes.add(new Integer[] {12345,12347});
		 zipcodes.add(new Integer[] {12346,12349});
		 zipcodes.add(new Integer[] {12341,12343});
		 zipcodes.add(new Integer[] {12351,12354});
		 
		 zipcodes.add(new Integer[] {12351,12347});
		 
		william.processZipCodes(zipcodes);
	}
	
	public void testFromConsoleZipcodes() {
		william.processValuesFromConsole();
	}

	public static void main(String[] args) {
		TestWilliam test = new TestWilliam();
		test.continuousZipcodes();
		test.invalidzipCode();
		test.invalidzipCodeOrder();
		System.out.println("###### Enter the values from Console ###### ");
		test.testFromConsoleZipcodes();
	}
}
