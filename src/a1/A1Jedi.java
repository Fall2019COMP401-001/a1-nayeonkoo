package a1;

import java.util.Scanner;

public class A1Jedi {

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
				
				//array to store number of customers who bought an item
				int[] cust = new int[count];
				
				//array to store quantity of item purchased
				int[] quant = new int[count];
				
					//the first name of the customer
					//the last name of the customer
					//integer count of the number of items the customer bought
					//calculate the total spent by each customer
				
				int e = 0;
				int f = 0;
				
				//customer
				for (int i = 0; i < countCust; i++) {
					first[i] = scan.next();
					last[i] = scan.next();
					
					//number of item types purchased
					int j = scan.nextInt();
					String[] d = new String[j];
					for (int a=0; a<j; a++) {
						int b = scan.nextInt();
						d[a] = scan.next();
						if (a==0 && items[a].equals(d[a])) {
							cust[a] += 1;
							quant[a] += b;
						} else if (d[a].equals(d[a-1]) && items[a].equals(d[a])) {
							quant[a] +=b;
						}
					}
					
				}
				
				scan.close();
				
				//report how many different customers bought an item and the total quantity of the item bought by all customers
				//each item should be reported in the same order
				
				//NUMBER customers bought TOTAL ITEM
				//ex: 2 customers bought 5 Banana
				//If no customers bought an item, report should say
				//No customers bought ITEM
				
				for (int i=0; i<items.length; i++) {
					if (quant[i] != 0) {
						System.out.println(cust[i] + " customers bought " + quant[i] + " " + items[i]);
					} else if (quant[i] == 0) {
						System.out.println("No customers bought " + items[i]);
					}
				}
		
	}
}
