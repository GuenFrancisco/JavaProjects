package practise;

import java.util.*;
import java.io.*;

public class FranciscoExamPrac {

	public static void main (String [] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Enter the number of products: ");
		int numofProducts = input.nextInt();
		input.nextLine();
		System.out.println();
		
		String [] productNames = new String [numofProducts];
		int [] quantity = new int[numofProducts];	
		
		
		for (int i = 0; i < numofProducts; i++) {
			System.out.print("Enter name of product " + (i + 1) + ": ");
			productNames[i] = input.nextLine();
			
			
			System.out.print("Enter quantity of " + productNames[i] + ": ");
			quantity [i] = input.nextInt();
			input.nextLine();
			System.out.println();
		}
		
		int total = totalItems(quantity);
		int available = countAvailable (quantity);
		int unavailable = countUnavailable(quantity);
		int highest = findHighest(quantity);
		int lowest = findLowest (quantity);
	
		displayProducts(productNames, quantity);
		
		System.out.println("\nTotal Items: " + total);
		System.out.println("Available: " + available);
		System.out.println("Unavailable: " + unavailable);
		System.out.println("Highest Quantity: " + highest);
		System.out.println("Lowest Quantity: " + lowest);
		
		try {
			FileWriter fw = new FileWriter ("WarehouseReport.txt");
		
			fw.write("=== Warehouse Report ===\n");
			displayProductsToFile(quantity, productNames, fw);
			
			
			fw.write("\nTotal Items: " + total + "\n");
			fw.write("Available: " + available + "\n");
			fw.write("Unavailable: " + unavailable + "\n");
			fw.write("Highest Quantity: " + highest + "\n");
			fw.write("Lowest Quantity: " + lowest + "\n" );
			
			fw.close();
			System.out.println("\nFile saved Succesfully!");
		
		} catch (IOException e) {
			System.out.println("Error! Something happened!");
		}
		
		
		
	}
	public static void displayProducts(String [] productNames, int [] quantity) {
		System.out.println("\n=== Products and Quantities ===\n");
		for (int i = 0; i < productNames.length; i++) {
		System.out.println(productNames[i] + " - " + quantity[i]);
	
		}
		}
		public static int totalItems (int [] quantity ) {
			int totalSum = 0;
			for (int i = 0; i < quantity.length; i++) {
				totalSum += quantity[i];
				
			
			}
		return totalSum;
		}
		public static int countUnavailable (int [] quantity) {
			int unavailableproducts = 0;
			for (int i = 0; i < quantity.length; i++) {
				if (quantity [i] == 0) {
					unavailableproducts++;
				}
			}
				return unavailableproducts;
			}
		public static int countAvailable (int [] quantity) {
			int availableproducts = 0;
			for (int i = 0; i < quantity.length; i++ ) {
				if (quantity[i] > 0) {
					availableproducts++;
				}
				
			}
			return availableproducts;
			
		}
			
		public static int findHighest (int [] quantity) {
			
			int highestquantity = quantity[0];
			for (int i = 0; i < quantity.length; i++) {
				if(quantity[i] > highestquantity) {
					highestquantity = quantity[i];
				}
			}
			return highestquantity;
		}
		
		public static int findLowest (int [] quantity) {
			int lowestquantity = quantity[0];
			
			for (int i = 0; i < quantity.length; i++) {
				if (quantity[i] < lowestquantity) {
					lowestquantity = quantity[i];
				}
			}
			return lowestquantity;
		}
		
		public static void displayProductsToFile(int [] quantity, String [] productNames, FileWriter fw) throws IOException {
			for (int i = 0; i < productNames.length; i++) {
				fw.write(productNames[i] + " - " + quantity [i] + "\n");
		
			}
						
		}
		}

