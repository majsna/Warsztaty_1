package pl.coderslab.majsna.grawzgadywanieliczb;

import java.util.Random;
import java.util.Scanner;

public class GraWzgadywanieLiczb {

	public static void main(String[] args) {
		
		System.out.println("Guess a number: ");
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		int rand = generator.nextInt(100);
		int	input = 0;
		
		while (true) {
			
			while(!scan.hasNextInt()) {
				System.out.println("That's not a number!!!");
				scan.next();
			}
			
			input = scan.nextInt();
			
			if ( input > rand) {
				System.out.println("To much! Try again...");
			} else if (input < rand ) {
				System.out.println("To little! Try again...");
			} else {
				System.out.println("YOU WON!!! Congratulations!");
				break;
			}
		}
	
	}

}
