package system;
import java.util.*;
public class FRANCISCO {
	static Scanner input = new Scanner (System.in);
	public static void main (String [] args) {
		
		int numofFloors = 7;
		int numofRooms = 5;
		
		int hotel [][] = new int [numofFloors][numofRooms];
		
		int choice;
		
		do {
			System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
			System.out.println("[1] View Room \n"
					+ "[2] Check In \n"
					+ "[3] Check out \n"
					+ "[4] Exit");
			
			System.out.print("\nEnter choice: ");
			choice = input.nextInt();
			
			System.out.println();
			
			switch (choice) {
			case 1:
				System.out.println("\n ===== ROOMS AVAILABLE =====");
				System.out.println("| Availble (0) | Occupied (1) |\n");
				 for (int a = numofFloors - 1 ; a >= 0 ; a--) {
					 System.out.print("Room " + (a + 1) + ": " );
					 for (int b = 0; b < hotel[a].length; b++) {
						 
						 System.out.print("[" + hotel[a][b] + "]");
						 
					 }
					 System.out.println();
				 }
				 break;
			case 2:
				System.out.print("Pick Floor Number (1-7): ");
				int floorchoice = input.nextInt();
				
				System.out.print("Pick Room Number (1-5): ");
				int roomchoice = input.nextInt();
				
				int row = floorchoice - 1;
				int column = roomchoice - 1;
				
				if (hotel[row][column] == 0) {
					hotel [row][column] = 1;
					
					System.out.println("Check in Successful!");
					System.out.println();
				} else {
					System.out.println("Room Already Occupied! Pick Another Room!");
				}
				break;
				
			case 3:
				System.out.print("Enter Floor Number: ");
				int checkoutFloor = input.nextInt();
				
				System.out.print("Enter Room Number: ");
				int checkoutRoom = input.nextInt();
				
				int checkoutRow = checkoutFloor - 1;
				int checkoutColumn = checkoutRoom - 1;
				
				if (hotel [checkoutRow][checkoutColumn] == 1) {
					hotel[checkoutRow][checkoutColumn] = 0;
					
					System.out.print("Checkout Successful! See you again soon!");
					System.out.println();
				} else {
					System.out.println("Room already empty!");
				} 
				break;
			case 4:
				
				System.out.println("Exiting program... Thank you!");
				break;
					default:
					System.out.println("Invalid Choice");	
			}
				
			
		} while (choice != 4);
		
		input.close();
	}
		
	}
