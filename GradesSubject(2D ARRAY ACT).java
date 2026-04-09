package reviewpack;

import java.util.Scanner;
 import java.io.*;
 
public class rev {
	static Scanner input = new Scanner (System.in);
	public static void main (String [] args ) {
	
		int subject = 3;
		int student = 3;
		double grades[][] = new double[student][subject];
		
		String []subjectNames = {"Math" , "Science" , "English "};
		
		System.out.println("- - - INPUT GRADES - - - ");
		
		for (int i = 0; i < student; i++) {
			System.out.println("Enter grades for Student " + (i + 1) + ": ");
			for (int j = 0; j < subject; j++) {
				System.out.print(subjectNames[j] + ": ");
				grades[i][j] = input.nextDouble();
				
			}
			System.out.println();
		}
		System.out.println("- - - - - Grade Report - - - - -");
		System.out.printf("%-10s %-7s %-10s %-8s\n" , "Student" , "Math" , "Science" , "English");
		
		for (int i = 0; i < student; i++) {
			System.out.printf("%-12s","Student " + (i + 1) );
			for (int j = 0; j < subject; j++) {
				System.out.printf("%-9.2f",grades[i][j]);
			}
			System.out.println();
			
		}
		System.out.println("\n-----------------------------------------\n");
		System.out.println("- - - Average per Student (Row) - - -");
		for (int i = 0; i < student; i++) {
			double totalgrade= 0;
			
			for (int j = 0; j < subject; j++) {
			totalgrade += grades[i][j];
			
			}
			double average = totalgrade / subject;
			System.out.printf("Student %d Average: %.2f\n" , (i + 1) , average);
	
		}
		
		System.out.println("\n- - - Average per Subject (Column) - - -");
		for (int i = 0; i < subject; i++) {
			double totalgrade= 0;
			
			for (int j = 0; j < student; j++) {
			totalgrade += grades[i][j];
			
		}
			double average = totalgrade / student;
			System.out.printf("%s Average: %.2f\n", subjectNames[i], average);
		}
		input.close();
		
	}
}
