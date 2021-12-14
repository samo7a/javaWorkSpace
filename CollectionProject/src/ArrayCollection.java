import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayCollection {

	public static void main(String[] args) {
		// 1- Auto boxing
		/* Autoboxing is the automatic conversion of primitive types to the corresponding wrapper classes instances.
		 * It is useful as java will do it automatically without any errors and without us have to be concered about it
		 * */
		// auto boxing is like the following...
		Integer x = 42; // it converts the primitive type of 42 to Integer automatically. 0r ......
		int y = 5;
		Integer y2 = y;
		
		// un boxing example....
	
		Integer num1 = new Integer(3);
		int ii = 0;
		if ( ii  > num1) {
			System.out.println("This is an example");
		} // java will un box num1 to a primitive value to compare it to the primitive integer ii.
		
		
		
		
		// 5- equals , compareTo 
		/* In the arrayList we are dealing with Objects and references not with primitive variables.
		 * So comparing values using (==) will create a bug as it will compare the location of memory not the value 
		 * we intended to compare.
		 * Instead we need to use the built in methods like equals() and compareTo() to check if two values are equal
		 * or to compare two values to find the greatest value.
		 * */
		
		// 2- creating an array list, adding names, printing using the enhanced for loop
		ArrayList<String> names = new ArrayList<String>();
		names.add("Bob");
		names.add("Susan");
		names.add("Steven");
		names.add("Leo");
		names.add("Marco");
		names.add("Donald");
		
		System.out.println("Printing the created arrayList using encanced for loop...");
		for (String s: names) {
			System.out.println(s);
		}

		System.out.println();

		// 3- sorting and shuffling the list and printing them to the screen

		Collections.sort(names);
		System.out.println("Printing the sorted arrayList using the encanced for loop...");
		for (String s: names) {
			System.out.println(s);
		}

		System.out.println();

		Collections.shuffle(names);
		System.out.println("Printing the shuffled arrayList using encanced for loop...");
		for (String s: names) {
			System.out.println(s);
		}
		
		System.out.println();

		// 4- Searching for 2 names, one in the list and one is not.
		System.out.println("searching for an item inside the list .... ");
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter a name you want to search: ");
		String input = scnr.next();
		int count = 0;
		for(int i = 0; i <= names.size() - 1; ++i) {
			if (names.get(i).equals(input)) {
				System.out.println(input + " found at index: " + i);
			}
			else {
				count = count +1;
			}
			if (count == names.size()) {
				System.out.println(input + " was not found");
			}
		}
		
		System.out.println();

		//6- converting ArrayList to array and vice versa + printing both.
		
		Object[] names2 =  names.toArray();
		System.out.println("printing the array after converting the Array list... ");
		for(int i = 0; i <= names2.length - 1; ++i) {
			System.out.println(names2[i]);
			
		}
		
		System.out.println();
		
		
		List <Object> names3 =  Arrays.asList(names2);
		System.out.println("printing the array list after converting the array .... ");
		System.out.println(names3);
		
		


		
		
		
	}

}
