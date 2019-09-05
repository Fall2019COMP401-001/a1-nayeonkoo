//report the customers that were the biggest and smallest spenders 
//report the average bill for all customers

package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//number of items in the store

		int count = scan.nextInt(); 
		
		//for each item in the store...
			//the name of each item (a single word)
			//the price of the item
		
		String[] items = new String[count];
		Double[] price = new Double[count];
		
		for (int i=0; i<count; i++) {
			items[i] = scan.next();
			price[i] = scan.nextDouble();
		}
		
		//an integer count of the number of customers
		
		int countCust = scan.nextInt();
		
		//array to store first names
		String[] first = new String[countCust];
		
		//array to store last names
		String[] last = new String[countCust];
		
		//array to store full names
		String[] fullName = new String[countCust];
		
		//array to store total spent by each customer
		Double[] total = new Double[countCust];
		
			//the first name of the customer
			//the last name of the customer
			//integer count of the number of items the customer bought
			//calculate the total spent by each customer
		
		for (int i = 0; i < countCust; i++) {
			first[i] = scan.next();
			last[i] = scan.next();
			fullName[i] = first[i] + " " + last[i];
			int j = scan.nextInt();
			double x = 0;
			for (int a=0; a<j; a++) {
				int b = scan.nextInt();
				String food = scan.next();
				for (int c=0; c<items.length; c++) {
					if (food.equals(items[c])) {
						x += ((double) price[c] * (double) b);
					}
				}
			}
			total[i] = x;
		}
		
		scan.close();
		
		double sum = calculateSum(total);
		double max = total[findValueMax(total)];
		double min = total[findValueMin(total)];
		
		System.out.println("Biggest: " + fullName[findValueMax(total)] + " (" + String.format("%.2f", max) + ")"); 
		System.out.println("Smallest: " + fullName[findValueMin(total)] + " (" + String.format("%.2f", min) + ")"); 
		System.out.println("Average: " + String.format("%.2f", ((double) sum) / ((double) countCust)));
	}
	
	static int findValueMax(Double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_max = vals[0];
		
		int temp = 0;
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] > cur_max) {
				cur_max = vals[i];
				temp = i;
			}
		}
		
		return temp;
	}
	
	static int findValueMin(Double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_min = vals[0];
		
		int temp = 0;
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] < cur_min) {
				cur_min = vals[i];
				temp = i;
			}
		}
		
		return temp;
	}

	static double calculateSum(Double[] vals) {
		
		double sum = 0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		return sum;
	}
	
}
