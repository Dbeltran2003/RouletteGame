package program08;
import java.util.Scanner;
public class program08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner std = new Scanner(System.in);
		int menu;
		int numBet = 0;
		int numChips = 0;
		int chips = 100;
		String color = "null";
		String betColor = "null";
		int random = 0;
		int chipsWon = 0;
		welcome();
		do {// to keep the player playing until they choose 3 and exit
			System.out.println("");
			menu = getMenuChoice(std);
			System.out.println("");
			if (menu == 1) {// to see what the user wants to play
				numBet = getNumber(std);
				numChips = getBet(std,chips);
			}else if (menu == 2) {
				betColor = getColor(std);
				numChips = getBet(std,chips);
			}
			if (menu != 3) {// to protect this from showing up if they press 3
				System.out.println("");
				System.out.println("Spinning the wheel ... ");
				random = (int)(Math.random()*36);
				System.out.println("Spin number: " + random);
				color = determineColor(random);
				System.out.println("Spin color: " + color);
				System.out.println("");
			}
			if (menu == 1){// to decide if the user won depending on what the bet
				if (numBet == random) {
					System.out.println("Congrats, you won!");
					numChips *= 36;
					chips += numChips;
					chipsWon += numChips;
					System.out.println("You now have "+ chips +" chips");
				}else {
					System.out.println("Sorry, you lost");
					chips -= numChips;
					chipsWon -= numChips;
				System.out.println("You now have "+ chips +" chips");
				}
			}else if (menu == 2) {
				if (betColor.equals(color)){
					System.out.println("Congrats, you won!");
					chips += numChips;
					chipsWon += numChips;
					System.out.println("You now have "+ chips +" chips");	
				}else {
					System.out.println("sorry, you lost");
					chips -= numChips;
					chipsWon -= numChips;
					System.out.println("You now have "+ chips +" chips");
				}
				if (chips == 0) {// in case they get to 0 ships and can't keep playing to check them out
					break;
				}
					
			}
		}while(menu != 3);
		report(chipsWon, chips);
	}
	public static void welcome() {// welcome message 
		System.out.println("############################\n"
				+ "# WELCOME TO ROULETTE #\n"
				+ "############################\n"
				+ "# NUMBER BETS PAYOUT: 35:1 #\n"
				+ "# COLOR BETS PAYOUT: 1:1 #\n"
				+ "############################\n"
				+ "You have 100 chips");
	}
	public static int getMenuChoice(Scanner std) {// ask user what he want to play 
		System.out.println("1. Pick a number to bet on\n"
				+ "2. Pick a color to bet on\n"
				+ "3. Cash out");
		int num;
		do {
			System.out.print("Enter a choice [1-3]:");
			num = std.nextInt();
		}while (num < 1 || num > 3);
		return num;
	}
	public static int getNumber(Scanner std) {// get the number the user is going bet 
		int num;
		do {
			System.out.print("Enter the number to bet on [1-36]:");
			num = std.nextInt();
		}while (num < 1 || num > 36);
		return num;
	}
	public static String getColor(Scanner std) {// get the color the user is going to bet on
		String color;
		do {
			System.out.print("Enter the color to bet on [Red or Black]: ");
			color = std.next();
		
		}while (!(color.equals("Red") || color.equals("Black")));
		return color;
	}
	public static int getBet(Scanner std, int chipsNow) {// the number of chips from the ones they have to bet
		int num;
		do {
			System.out.print("Enter the number of chips to bet [1-" + chipsNow + "]:");
			num = std.nextInt();
		}while (num < 1 || num > chipsNow);
		return num;
	}
	public static String determineColor(int spinNum) {// to see what color does the roullete land on 
		if (spinNum == 0) {
			return "Green";
		}else if (spinNum %2 == 0) {
			return "Red";
		}else return "Black";
	}
	public static void report(int chipsNow, int chips) {// the end message with how many chips they got and how many they ended up with
		System.out.println("Thanks for playing, you won a total of " + chipsNow + " chips");
		System.out.println("Thanks for playing, you ended with " + chips + " chips");
	}
	}
