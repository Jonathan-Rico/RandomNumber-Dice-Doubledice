import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
	public static void main(String [] args){
		System.out.printf("\tWelcome to the guess a number game.\nPlease type in ''One'' to guess a number rolled by a single die between 1-6\nType in ''Two'' to guess a number rolled between 1-12.\nType in ''Three'' for Blackjack\n");		
		Scanner input = new Scanner(System.in);
		Dice dice = new Dice();
		DoubleDice doubledice = new DoubleDice();
		Card card = new Card();
		String usergamechoice = input.nextLine();
		boolean drawing = true;
		boolean continuingLoop = true;
		int win = 0;
		int tie = 0;
		int loss = 0;
		//Game SingleDie
		if (usergamechoice.equalsIgnoreCase("One") ){
			System.out.printf("You have chosen the single die game\n");	
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
			System.out.printf("You have chosen the double die game\n");	
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
		//Game Blackjack
		else if (usergamechoice.equalsIgnoreCase("Three")){	
			System.out.printf("You have chosen the blackjack game\n");	
			do {
					int user = 1 + card.GetValue(10);
					int user2 = 1 + card.GetValue(10);
					int total = user +user2;
					System.out.printf("Your cards are %d and %d. For a total of %d.\n", user , user2, total);
					int comp = 1 + card.GetValue(10);
					int comp2 = 1 + card.GetValue(10);
					int comptotal = comp+comp2;
					System.out.printf("%d pc total\n", comptotal);
					do {
						System.out.printf("Would you like to draw another card to be able to get 21? Draw / Pass\n", user);
						String draw = input.nextLine();
						if (draw.equalsIgnoreCase("Pass")) {
							drawing =false;
						}
						if(draw.equalsIgnoreCase("Draw")) {
							int s = 1+card.GetValue(10);
							total = total + s;
							System.out.printf("You drew a %d. Your new total is %d.\n", s, total);
						}
					} while (drawing && total <22 && comptotal <22);
					
					if (total == 21) {
						System.out.printf("Your total is %d. Blackjack!! You win\n", total);
						System.out.printf("Computer total is %d.\n",  comptotal);
						win++;
					}
					if (comptotal < 21 && total < 21 && (comptotal < total)) {
						win++;
						System.out.printf("Total is %d.Computer total is %d. You win.\n", total , comptotal);
					}
					if (comptotal < 21 && total < 21 && (comptotal > total)) {
						loss++;
						System.out.printf("Total is %d.Computer total is %d. You lose.\n", total , comptotal);
						
					}
					if (comptotal < 21 && total < 21 && (comptotal == total)) {
						tie++;
						System.out.printf("Total is %d.Computer total is %d. You have tied.\n", total , comptotal);
					}
					if (comptotal > 21 && total > 21 ) {
						tie++;
						System.out.printf("Total is %d.Computer total is %d. You have both busted.You have tied.\n", total , comptotal);
					}
					if (comptotal < 21 && total > 21 && (comptotal < total)) {
						loss++;
						System.out.printf("Total is %d.Computer total is %d. You lose.\n", total , comptotal);
					}
					if (comptotal > 21 && total < 21 && (comptotal < total)) {
						win++;
						System.out.printf("Total is %d.Computer total is %d. You win.\n", total , comptotal);
					}
					System.out.printf("Would you like to continue? Type in ''No'' to quit\n\n");
					String xz =input.nextLine();
					if (xz.equalsIgnoreCase("No")) {
						continuingLoop=false;
					}
					
			} while (continuingLoop);
				System.out.printf("You have won %d times and lost %d times.You have tied %d times\n", win , loss, tie);
		}
		//end
	}
}