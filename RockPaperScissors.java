import java.util.Scanner;

public class RockPaperScissors{
	public static void main(String[] args){

		String[] choises = {"Rock", "Paper", "Scissors"};
		//String[] choises2 = new String[3];

		//choises2[0] = "Rock";
		//choises2[1] = "Paper";
		//choises2[2] = "Scissors";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose R (Rock), P (Paper), S (Scissors)");
		String playerChoise = scanner.nextLine().toUpperCase();
		while(!playerChoise.equals("R") && !playerChoise.equals("P") && !playerChoise.equals("S")){
			System.out.println("Please choose only one of the following: R (Rock), P (Paper), S (Scissors)");
			playerChoise = scanner.nextLine().toUpperCase();
		}
		String computerChoise = choises[(int)(Math.random() * choises.length)];

		if(playerChoise.equals("R")){
			playerChoise = "Rock";
		}
		else if(playerChoise.equals("P")){
			playerChoise = "Paper";
		}
		else{
			playerChoise = "Scissors";
		}

		System.out.println("Ur choise is: " + playerChoise);
		System.out.println("The computer choise is: " + computerChoise);

		//Fall 1
		if(computerChoise.equals(playerChoise)){
			System.out.println("Tie");
		}

		else if(playerChoise.equals("Rock")){
			if(computerChoise.equals("Paper")){
				System.out.println("You lost! :(");
			}
			//Scissors
			else{
				System.out.println("You won !!! yay");
			}
		}

		else if(playerChoise.equals("Paper")){
			if(computerChoise.equals("Rock")){
				System.out.println("You won !!! yay");
			}
			//Scissors
			else{
				System.out.println("You lost! :(");
			}
		}

		else{
			if(computerChoise.equals("Rock")){
				System.out.println("You lost! :(");
			}
			//Paper
			else{
				System.out.println("You won !!! yay");
			}
		}

	}
}
