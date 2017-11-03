package pl.coderslab.majsna.SymulatorLOTTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SymulatorLOTTO {

	public static void main(String[] args) {
		
		System.out.println("Choose six numbers between 1 and 49.");
		Scanner scan = new Scanner(System.in);
		int[] chosenNumbers = new int[6];
		int choice = 0;
						
		int i = 0;
		
			 while (i<6) {
								
					while(!scan.hasNextInt()) {
						System.out.println("That's not a number!!!");
						scan.next();
					}
					
					choice = scan.nextInt();
					
					if (choice<1 || choice>49) {
						
						System.out.println("Wrong number!\nChoose number beetween 1 and 49.");
						
					} else if(i == 0) {
						
						chosenNumbers[i] = choice;
						i++;
						System.out.println(Arrays.toString(chosenNumbers));
						System.out.println("Choose another number...");


					} else if(chosenNumbers[0]==choice || chosenNumbers[1]==choice || chosenNumbers[2]==choice || chosenNumbers[3]==choice || chosenNumbers[4]==choice || chosenNumbers[5]==choice) {

						System.out.println("You have already chosen this number before.\nChoose another number...");
						

					} else if(chosenNumbers[i] != choice) {
						chosenNumbers[i] = choice;
						i++;
						System.out.println(Arrays.toString(chosenNumbers));
						System.out.println("Choose another number...");

					}
										
			}
		
		Arrays.sort(chosenNumbers);
		System.out.println("Your numbers are: " + Arrays.toString(chosenNumbers));
		
		Integer[] arr = new Integer[49];
		for (int k = 0; k < arr.length; k++) {
			arr[k] = k;
		}		
		Collections.shuffle(Arrays.asList(arr));	
		
		int[] lottoResults = new int[6];
		for (int m=0; m<6; m++) {
			lottoResults[m] = Integer.parseInt("" + arr[m]);
		}
		System.out.println("Winning numbers are: " + Arrays.toString(lottoResults));
		
		int counter = 0;
		
		for (int n=0; n<6 ; n++) {
			for ( int p=0; p<6; p++ ) {
				if(chosenNumbers[n]==lottoResults[p]) {
					counter++;
				}
			}
		}
		
		if(counter==0 || counter==1 || counter==2) {
			System.out.println("I'm sorry. You haven't won anything :(");
		} else {
			System.out.println("You've hit " + counter + " numbers. Congratulations.");
		}
		
	}
}
