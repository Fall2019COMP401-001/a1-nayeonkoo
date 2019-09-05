//read in data that represents shopping orders from customers
//and report the total amount spent on a per customer basis

package a1;

import java.util.Scanner;
import java.util.LinkedList;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//for each item bought, the input will contain
			//an integer quantity of the item bought
			//the name of the item (assume single word)
			//price of the item as a double
		//for each customer, program should print one line of output 
		//F. LAST: TOTAL
		
		//read in count of number of customers to process
		
		int count = scan.nextInt(); 
		Double[] Customers = new Double[count];
		String[] firstName = new String[count];
		String[] lastName = new String[count];
		int[] itemsPerCust = new int[count];
		
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
		
		scan.close();
		
		char[] firstInitials = firstIni(firstName);
				
		for (int i=0; i<Customers.length; i++) {
			System.out.println(firstInitials[i] + ". " + lastName[i] + ": " + String.format("%.2f", Customers[i]));
		}
	}
	
	static char[] firstIni(String[] firstName) {
		String[] temp = firstName;
		char[] temp1 = new char[temp.length];
		for (int i=0; i<temp.length; i++) {
			temp1[i] = temp[i].charAt(0);
		}
		return temp1;
	}
}
