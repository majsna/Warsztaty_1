package pl.coderslab.majsna.GraWzgadywanieLiczb2;

import java.util.Scanner;

public class GraWzgadywanieLiczb2 {

	public static void main(String[] args) {
		
		System.out.println("Imagine a number between 0 and 1000. I will guess it in max 10 shots.");
		int min = 0;
		int max = 1000;
		int guess = ((max - min)/2) + min;
		Scanner scan = new Scanner(System.in);
		System.out.println("I'm guessing: " + guess);
		String ask = "If it's to much type: \"more\". If it's too little type: \"less\". If I've guessed type: \"good\". ";
		System.out.println(ask);
		String answear = scan.next();
		
		boolean haveIguessed = false;
		
		while(!haveIguessed) {			
			
			while (!answear.equals("more") && !answear.equals("less") && !answear.equals("good")) {
				System.out.println("Wrong answear! Type more, less or good.");
				answear = scan.next();
			}			
		
			if(answear.equals("more")) {
				
				min = guess;
				guess = ((max - min)/2) + min;
				System.out.println("I'm guessing: " + guess + "\n more, less or good?");
				
				answear =scan.next(); 
				
			} else if(answear.equals("less")) {
				
				max = guess;
				guess = ((max - min)/2) + min;
				System.out.println("I'm guessing: " + guess + "\n more, less or good?");
				
				answear =scan.next(); 
				
			} else {
				System.out.println("I WON!");
				break;
			}
						
		}
				
	}
	
}
