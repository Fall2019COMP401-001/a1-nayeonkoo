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
		String[] Customers = new String[count];
		String[] firstName = new String[count];
		String[] lastName = new String[count];
		int[] itemsPerCust = new int[count];
		LinkedList<Integer> numItem = new LinkedList<Integer>();
		LinkedList<String> item = new LinkedList<String>();
		LinkedList<Double> cost = new LinkedList<Double>();
		
		for (int i=0; i<Customers.length; i++) {
			firstName[i] = scan.next();
			lastName[i] = scan.next();
			itemsPerCust[i] = scan.nextInt();
			for (int j=0; j<itemsPerCust[i]; j++) {
				numItem.add(scan.nextInt());
				item.add(scan.next());
				cost.add(scan.nextDouble());
			}
		}
		
		scan.close();
		
		int[] numItem2 = new int[numItem.size()];
		String[] item2 = new String[item.size()];
		double[] cost2 = new double[cost.size()];
		
		char[] firstInitials = firstIni(firstName);
		
		Customers = totalCalc(itemsPerCust, numItem2, cost2);
		
		for (int i=0; i<Customers.length; i++) {
			System.out.println(firstInitials[i] + ". " + lastName[i] + ": " + Customers[i]);
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
	
	static String[] totalCalc(int[] x, int[] y, double[] z) {
		double[] temp = new double[x.length];
		for (int t = 0; t<temp.length; t++) {
			temp[t] = 0;
		}
		int m = 0;
		for (int j = 0; j<x.length; j++) {
			for (int i = 0; i<x[j]; i++) {
				temp[j] += y[m + i] * y[m + i];
			}
			m += x[j];
		}
		String[] temp2 = new String[x.length];
		for (int i = 0; i<temp2.length; i++) {
			temp2[i] = String.format("%.2f", temp[i]);
		}
		return temp2;
	}
}
