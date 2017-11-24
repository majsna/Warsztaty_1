package pl.coderslab.majsna.KostkaDoGry;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KostkaDoGry {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Let's play a game...\n");
		System.out.println("Enter type of a throw according to given pattern:\n"
				+ "xDy+z where:\n"
				+ " x - number of throws\n"
				+ " y - type of the dice (choose from: 3,4,6,8,10,12,20 or 100)\n"
				+ " z - value added to the throws\n"
				+ "Type 'quit' to exit the game.");
		
		while(true) {
			
			String input = scan.nextLine();
			System.out.println(input);
			
			if(input.equals("quit")) {
				System.out.println("Bye");
				System.exit(0);
			}else {
				throwDice(input);
			}

		}

		
	}

	public static void throwDice (String xDyz) {
		
		Pattern pattern = Pattern.compile("\\d*D(3|4|6|8|10|12|20|100)(\\+|-)?\\d*");				
		Matcher matcher = pattern.matcher(xDyz);
		Random rand = new Random();
		
				
		if(matcher.matches() == true) {
			
					int result = 0;
					String[]parts = xDyz.split("[D\\+-]");
					
					if(parts.length == 3) {
						
								if(!parts[0].equals("")) {
									
										if(xDyz.contains("+")) {
											int counterOfThrows = Integer.parseInt(parts[0]);
											int throwResult = 0;
											int nrOfTheThrow = 0;
											for(int i=0; i<counterOfThrows; i++) {	
												throwResult = rand.nextInt(Integer.parseInt(parts[1]))+1;
												result += throwResult;
												nrOfTheThrow = i+1;
												System.out.println("Throw nr "+nrOfTheThrow+": "+throwResult);
											}
											result += Integer.parseInt(parts[2]);
											printResult(result);
										}else if (xDyz.contains("-")) {
											int counterOfThrows = Integer.parseInt(parts[0]);
											int throwResult = 0;
											int nrOfTheThrow = 0;
											for(int i=0; i<counterOfThrows; i++) {	
												throwResult = rand.nextInt(Integer.parseInt(parts[1]))+1;
												result += throwResult;
												nrOfTheThrow = i+1;
												System.out.println("Throw nr "+nrOfTheThrow+": "+throwResult);
											}
											result -= Integer.parseInt(parts[2]);
											printResult(result);
										}
									
								}else {
									
										if(xDyz.contains("+")) {
											int throwResult = rand.nextInt(Integer.parseInt(parts[1]))+1;
											System.out.println("Throw result: "+throwResult);
											result = throwResult + Integer.parseInt(parts[2]);
											printResult(result);
										}else if (xDyz.contains("-")) {
											int throwResult = rand.nextInt(Integer.parseInt(parts[1]))+1;
											System.out.println("Throw result: "+throwResult);
											result = throwResult - Integer.parseInt(parts[2]);
											printResult(result);
										}
									
								}
							
						
					}else if(parts.length == 2) {
						
								if(!parts[0].equals("")) {				
									int counterOfThrows = Integer.parseInt(parts[0]);
									int throwResult = 0;
									int nrOfTheThrow = 0;
									for(int i=0; i<counterOfThrows; i++) {	
										throwResult = rand.nextInt(Integer.parseInt(parts[1]))+1;
										result += throwResult;
										System.out.println("Throw nr "+nrOfTheThrow+": "+throwResult);
									}
									printResult(result);				
								}else {
									int throwResult = rand.nextInt(Integer.parseInt(parts[1]))+1;
									System.out.println("Throw result: "+throwResult);
									result = throwResult;
									printResult(result);
								}
										
					}	

					
		} else {
			System.out.println("Something went wrong. Try again!");
			System.out.println("Enter type of a throw according to given pattern:\n"
					+ "xDy+z where:\n"
					+ " x - number of throws\n"
					+ " y - type of the dice (choose from: 3,4,6,8,10,12,20 or 100)\n"
					+ " z - value added to the throws\n"
					+ "Type 'quit' to exit the game.");
		}
				
	}
	
	public static void printResult(int result) {
		
		System.out.println("Your result is: "+result+" Wanna try again? Enter type of a throw again, else type 'quit'");
		
	}
	
	
}
