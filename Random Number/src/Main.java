import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
	public static void main(String [] args){
		System.out.printf("\tWelcome to the guess a number game.\nPlease type in ''One'' to guess a number rolled by a single die between 1-6\nor type ''Two'' to guess a number rolled between 1-12.\n");		
		Scanner input = new Scanner(System.in);
		Dice dice = new Dice();
		DoubleDice doubledice = new DoubleDice();
		String usergamechoice = input.nextLine();
		boolean continuingLoop = true;
		int win = 0;
		int loss = 0;
		//Game SingleDie
		if (usergamechoice.equalsIgnoreCase("One") ){
			do {
				int comp = dice.GetValue(6);
				System.out.printf("Please type in an integer number between 1 and 6 to guess. To quit type in ''0''.\n");	
				int user = input.nextInt();	
				if (user == comp && user > 0){
					System.out.printf("Congratulations, the number %d is the correct choice. You have won the game.\n", user);		
					win++;
					}		
				else if (user < comp && user > 0){			
					System.out.printf("Sorry but the number %d is too low, the correct number is %d\n", user , comp);
					loss++;
					}		
				else if (user > comp && user > 0){			
					System.out.printf("Sorry but the number %d is too high, the correct number is %d\n", user , comp);
					loss++;
					}
				else if (user == 0) {
					System.out.printf("Ending Game\n");
					continuingLoop = false;
				}
			} while (continuingLoop);
			System.out.printf("You have won %d times and lost %d times.", win , loss);
		}		
		
		//Game DoubleDice
		else if (usergamechoice.equalsIgnoreCase("Two")){	
			do {
				int comp = doubledice.GetValue(12);
				System.out.printf("Please type in an integer number between 1 and 12 to guess. To quit type in ''0''.\n");	
				int user = input.nextInt();	
				
				if (user == comp && user > 0){
					System.out.printf("Congratulations, the number %d is the correct choice. You have won the game.\n", user);
					win++;
				}		
				
				else if (user < comp && user > 0){			
					System.out.printf("Sorry but the number %d is too low, the correct number is %d\n", user , comp);
					loss++;
				}		
				
				else if (user > comp && user > 0){			
					System.out.printf("Sorry but the number %d is too high, the correct number is %d\n", user , comp);	
					loss++;
				}
			
				else if (user == 0) {
					System.out.printf("Ending Game\n");
					continuingLoop = false;
				}
			}	while (continuingLoop);
			
			System.out.printf("You have won %d times and lost %d times.", win , loss);
		}
	}
}