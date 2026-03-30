package LabAct1;
import java.util.*;
public class FRANCISCO {
	
	static Scanner input = new Scanner (System.in);
	public static void main (String [] args) {
		
		 System.out.println("=== HOTEL RESERVATION ===");
		 System.out.print("Enter name: ");
		 String name = input.next();

		 System.out.print("Enter Age: ");
		 int age = input.nextInt();

		 input.nextLine();

		 System.out.print("Enter Gender: ");
		 String gender = input.next();
		 

		 System.out.println("\nROOM SELECTION");
		 System.out.println("[1] Small Room: ₱500 per night ");
		 System.out.println("[2] Medium Room: ₱700 per night");
		 System.out.println("[3] Large Room: ₱1,000 per night\n");

		 System.out.println("Choose what room: (1 - 3)");
		 int roomchoice = input.nextInt();

		 
		 
		 double roomPrice = 0;
		 String typeofRoom = "";

		 
		 switch (roomchoice) {

		 case 1:
		 typeofRoom = "Small Room";
		 roomPrice = 500;
		 break;

		 case 2:
		 typeofRoom = "Medium Room";
		 roomPrice = 700;
		 break;

		 case 3:
		 typeofRoom = "Large Room";
		 roomPrice = 1000;
		 break;

		 default:

		 System.out.println("Invalid choice");
		 return;

		 }
		 
		 System.out.println("Number of nights:");
		 int numofNights = input.nextInt();
		 
		 double roomCost = roomPrice + numofNights;


		 System.out.println("\n\n--- Food & Drinks ----");
		 System.out.println("Coke - ₱50.00 \n"
		 + "Rice - ₱5.00 \n"
		 + "Chicken Adobo - ₱100.00 \n"
		 + "Beef Steak - ₱175.00 \n"
		 + "Halo-Halo - ₱250.00\n\n ");


		 System.out.print("Coke Quantity: ");
		 int coke = input.nextInt();

		 System.out.print("Rice Quantity: ");
		 int rice = input.nextInt();

		 System.out.print("Chicken Adobo Quantity: ");
		 int adobo = input.nextInt();

		 System.out.print("Beef Steak Quantity: ");
		 int beef = input.nextInt();

		 System.out.print("Halo-Halo Quantity: \n\n");
		 int halohalo = input.nextInt();


		 double foodTotal =
		 (coke * 50) +
		 (rice * 5) +
		 (adobo * 100) +
		 (beef * 175) +
		 (halohalo * 250);

		 

		 double totalBill = roomPrice + foodTotal;
		 
		 System.out.println("===== SUMMARY ======");
		 System.out.println("Name: " + name +"\n"
				 + "Room Type: " + roomchoice +"\n"
				 + "Number of Nights: " + numofNights + "\n"
				 + "Food and Drinks: " + foodTotal + "\n"
				 + "Room Cost: " + roomCost + "\n" 
				 + "Total Bill: " + totalBill);
		 
		 System.out.print("\nEnter Cash: ");
	        double cash = input.nextDouble();

	        if (cash >= totalBill) {
	            double change = cash - totalBill;
	            System.out.println("Change: ₱" + change);
	        } else {
	            double insu = totalBill - cash;
	            System.out.println("Insufficient payment! Need ₱" + insu + " more.");
	        }

	    
	        System.out.println("\nTHANK YOU FOR BOOKING WITH US!");

	        input.close();
	}
}
