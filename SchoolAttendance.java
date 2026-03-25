package reviewpack;
 import java.util.Scanner;
 import java.io.*;
 
 
public class rev {
	static Scanner input = new Scanner (System.in);
	
	public static void main (String [] args) {
		
		 int days [] = inputAttendance();
		 
		 String report = "";
		 
		 for (int i = 0; i < days.length; i++) {
			 String status = checkAttendance(days [i]);
			 
			 String output ="Student " + (i + 1) + " : " + days [i] + " days - " + status;
			 report = report + output + "\n";
			 
			 
			 
		 }
		 saveReport(report);
		 
		
		
		}
		public static int [] inputAttendance () {
			
			System.out.print("How many students? " );
			int numofStudents = input.nextInt();
			
			System.out.println("Enter attendance for " + numofStudents + " students:");
			
			int days [] = new int [numofStudents];
			
			for (int i = 0; i < numofStudents; i++) {
				
				System.out.print("Student " + (i + 1) + ": ");
				days [i] = input.nextInt();
				
			}
			return days;
			
			
		}
		public static String checkAttendance (int days) {
			 
			if (days > 25) {
				return " Perfect Attence";
				
			} else if ( days >= 15 && 25 >= days) {
				return " Regular Attendance";
				
			} else {
				return " Poor Attendance";
						
			}
			
			
		}
		public static void saveReport (String report) {
			try {
				
			
			FileWriter writer = new FileWriter ("Attendance_form.txt");
			writer.write(report);
			writer.close();
			
			System.out.println("\nSaved at Attendance_form.txt");
			
			
			} catch (IOException e) {
				System.out.println("Error saving file");
			}
		}
		
	}


