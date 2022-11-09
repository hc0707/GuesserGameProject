import java.util.Scanner;

// Enhancements made:

// 1--Made all data members private(encapsulation)
// 2--Created a constructor in Player class to get name of player as argument 
//    when Player object is created and to print the name when taking input
// 3--added methods both in player class and umpire class to increment the score 
// 	  and also display them.
// 4--Added functionality to either continue the game or exit it, because of which i 
//    had to change the compare method and call all other umpire method inside compare method
//    rather than calling in main method because it will reset the scores to 0 when 
//    continuing the game.


public class Project_GuesserGame {
    public static void main(String[] args) {

        
		System.out.println("****Welcome to The Guesser Game****");
		System.out.println();
		Umpire u=new Umpire();
		
		u.play();
			
    }
}

class Guesser
{
	private int guessNum;
	
	int guessNum()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;
	}	
}

class Player
{
	private int guessNum;
	private String name;
	private int score;

  	Player(String name)
	{ 
		this.name = name; 
	}
	int guessNum()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player " + name +" kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;
	}
	void dispScore()
	{
		System.out.println(name+":"+score);
	}
	void updateScore()
	{
		score++;
	}
}

class Umpire
{
	private int numFromGuesser;
	private int numFromPlayer1;
	private int numFromPlayer2;
	private int numFromPlayer3;
	
	Player p1=new Player("p1");
	Player p2=new Player("p2");
	Player p3=new Player("p3");
	
	void collectNumFromGuesser()
	{
		Guesser g=new Guesser();
		numFromGuesser=g.guessNum();
	}

	void collectNumFromPlayers()
	{
		numFromPlayer1=p1.guessNum();
		numFromPlayer2=p2.guessNum();
		numFromPlayer3=p3.guessNum();
	}

	void scoreBoard()
	{
		System.out.println("_______Score Board______");
		p1.dispScore();
		p2.dispScore();
		p3.dispScore();
	}

	void play()
	{

		while(true)//to continue the game
		{
			this.collectNumFromGuesser();
			this.collectNumFromPlayers();

			if(numFromGuesser==numFromPlayer1)
			{
				if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3)
				{
					System.out.println("All players won the game");
					p1.updateScore();
					p2.updateScore();
					p3.updateScore();
				}

				else if(numFromGuesser==numFromPlayer2 )
				{
					System.out.println("Player 1 & Player2 won");
					p1.updateScore();
					p2.updateScore();
				}
				else if(numFromGuesser==numFromPlayer3)
				{
					System.out.println("Player 1 & Player3 won");
					p1.updateScore();
					p3.updateScore();
				}
				else
				{
					System.out.println("Player 1 won the game");
					p1.updateScore();
				}
			}
			else if(numFromGuesser==numFromPlayer2)
			{
				if(numFromGuesser==numFromPlayer3)
				{
					System.out.println("Player 2 & Player3 won");
					p2.updateScore();
					p3.updateScore();
				}
				else
				{
					System.out.println("Player 2 won the game");
					p2.updateScore();	
				}
			}
			else if(numFromGuesser==numFromPlayer3)
			{
				System.out.println("Player 3 won the game");
				p3.updateScore();
			}
			else
			{
				System.out.println("Game lost Try Again!");
			}
			
			System.out.println();

			this.scoreBoard();

			System.out.println("Do you want to continue the game(y/n)");
			Scanner scan = new Scanner(System.in);

				if (scan.next().equals("y"))
					continue;
				else if(scan.next().equals("n"))
					break;
		}		
	}
	
}
