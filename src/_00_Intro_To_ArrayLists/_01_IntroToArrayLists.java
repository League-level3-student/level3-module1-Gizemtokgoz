package _00_Intro_To_ArrayLists;

import java.util.ArrayList;
import java.util.Iterator;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList<String> arrayl = new ArrayList<String>();
        // 2. Add five Strings to your list
    	arrayl.add("zero");
    	arrayl.add("one");
    	arrayl.add("two");
    	arrayl.add("three");
    	arrayl.add("four");
        // 3. Print all the Strings using a standard for-loop
    	for (int i = 0; i < arrayl.size(); i++) {
			System.out.println(arrayl.get(i));
		}
        // 4. Print all the Strings using a for-each loop
    	//for each
        // 5. Print only the even numbered elements in the list.
    	for (int i = 0; i < arrayl.size(); i++) {
    		if (i%2==0) {
    			System.out.println(arrayl.get(i));
    		}
		}
        // 6. Print all the Strings in reverse order.
    	for (int i = arrayl.size()-1; i >= 0; i--) {
    		System.out.println(arrayl.get(i));
		}
        // 7. Print only the Strings that have the letter 'e' in them.
        for (int i = 0; i < arrayl.size(); i++) {
			if (arrayl.get(i).contains("e")) {
				System.out.println(arrayl.get(i));
			}
		}
    }
}
