//read in data that represents shopping orders from customers
//and report the total amount spent on a per customer basis

package a1;

import java.util.Scanner;
import java.util.LinkedList;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//read the number of customers
		
		int count = scan.nextInt(); 
		
		//use this array to store the total spent by each customer 
		Double[] Customers = new Double[count];
		
		//store first names
		String[] firstName = new String[count];
		
		//store last names
		String[] lastName = new String[count];
		
		//store number of items bought by each customer
		int[] itemsPerCust = new int[count];
		
		//read in the scanner and calculate the total spent by each customer
		for (int i=0; i<Customers.length; i++) {
			firstName[i] = scan.next();
			lastName[i] = scan.next();
			itemsPerCust[i] = scan.nextInt();
			double m = 0;
			int[] numItem = new int[itemsPerCust[i]];
			String[] item = new String[itemsPerCust[i]];
			double[] cost = new double[itemsPerCust[i]];
			for (int j=0; j<itemsPerCust[i]; j++) {
				numItem[j] = scan.nextInt();
				item[j] = scan.next();
				cost[j] = scan.nextDouble();
				m += numItem[j] * cost[j];
			}
			
			Customers[i] = m;
		}
		
		//done scanning
		scan.close();
		
		//call on firstIni to change the first names to just the first initials
		char[] firstInitials = firstIni(firstName);
		
		//print output
		for (int i=0; i<Customers.length; i++) {
			System.out.println(firstInitials[i] + ". " + lastName[i] + ": " + String.format("%.2f", Customers[i]));
		}
	}
	
	
	//modify an array of names. return an array of first initials 
	static char[] firstIni(String[] firstName) {
		String[] temp = firstName;
		char[] temp1 = new char[temp.length];
		for (int i=0; i<temp.length; i++) {
			temp1[i] = temp[i].charAt(0);
		}
		return temp1;
	}
}
