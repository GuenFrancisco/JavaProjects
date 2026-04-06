package prajik;
import java.util.*;
public class francisco {
	static Scanner input = new Scanner (System.in);
	public static void main (String [] args) {
		
		int numbers [][] = {{120,250,789,7},{58,79,31,87},{8,1,2,3},{99,98,97,96}};
		
		
		for (int x = 0; x < numbers.length ; x++) {
			for (int y = 0; y < numbers[x].length; y++) {
				System.out.print(numbers[x][y] + " ");
			}
			System.out.println(" ");
		}
		for (int x = 0; x < numbers.length; x++) {
            for (int y = 0; y < numbers[x].length; y++) {
                if (numbers[x][y] == 1) {
                    System.out.println("\nNumber 1 is found at indices " + x + " and " + y + "\n");
                    numbers[x][y] = 50;
                }
            }
        }

        
        for (int x = 0; x < numbers.length; x++) {
            for (int y = 0; y < numbers[x].length; y++) {
                System.out.print(numbers[x][y] + "\t");
            }
            System.out.println();
        }
    
        for (int y = 0; y < numbers[2].length; y++) {
            numbers[2][y] = 0;
        }

      
        System.out.println();
        for (int x = 0; x < numbers.length; x++) {
            for (int y = 0; y < numbers[x].length; y++) {
                System.out.print(numbers[x][y] + "\t");
            }
            System.out.println();
        }
        
	}
}
