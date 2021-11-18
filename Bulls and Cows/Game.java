/**
 * The class Game represents a Bulls and Cows game, 
 * using four digits String which the user has to guess.
 * 
 * @author (Inbal Sapir)
 * @version (November 06, 2020)
 */
import java.util.Random;
public class Game 
{
	// variables
	private String number; // the number the user has to guess
	// constructors
	/**
	 * An empty constructor. Constructs a new Game object by choosing 
	 * a four digits long number, with only different digits.
	 */
	public Game ()
	{
		Random rand=new Random ();
		do
		{
			int assist=rand.nextInt(10000);
			conversion (assist);
		}
		while (number.charAt(0)==number.charAt(1) || number.charAt(0)==number.charAt(2) || 
				number.charAt(0)==number.charAt(3) || number.charAt(1)==number.charAt(2) || 
				number.charAt(1)==number.charAt(3) || number.charAt(2)==number.charAt(3)); // keep choosing numbers until chosen number is legal
		
	}
	// methods
	/**
	 * Converts a reference number to the four digits String that the user has to guess.
	 * if the reference number is less than 1000, adds as much 0 digits as needed 
	 * to the beginning of the String.
	 * @param assist the reference number
	 */
	private void conversion (int assist)
	{
		if (assist < 10) // 0 <= assist < 10
			number="000"+assist;
		else
		{
			if (assist < 100) // 10 <= assist < 100
				number="00"+assist;
			else
			{
				if (assist < 1000) // 100 <= assist < 1000
					number="0"+assist;
				else // 1000 <= assist
					number=""+assist;
			}
		}
	}
	/**
	 * Gets a reference String as a guess.
	 * Calculates the number of bulls and cows for the guess.
	 * Returns an answer as a String with the number of bulls and cows for the guess.
	 * If the guess has 4 bulls, adds a following winning message to the answer, 
	 * including the number of guesses the user had so far.
	 * @param guess the reference guess
	 * @param counter the number of guesses the user had so far
	 * @return the answer for the guess
	 */
	public String calculation (String guess, int counter)
	{
		int bullsCounter=0; // the number of bulls in the user's guess
		int cowsCounter=0; // the number of cows in the user's guess
		String answer; // the result of the guess
		// counting the bulls
		for (int i=0; i<4; i++)
		{
			if (guess.charAt(i)==number.charAt(i))
				bullsCounter++;
		}
		// counting the cows
		for (int i=0; i<4; i++)
		{
			if (guess.charAt(i)==number.charAt(0) || guess.charAt(i)==number.charAt(1) ||
					guess.charAt(i)==number.charAt(2) || guess.charAt(i)==number.charAt(3))
				cowsCounter++;
		}
		cowsCounter=cowsCounter-bullsCounter;
		// producing an answer
		answer="Your guess was: "+guess+". bulls: "+bullsCounter+". cows: "+cowsCounter+"\n";
		if (bullsCounter==4)
			answer=answer+"You win!\nYou had "+counter+" guesses.";
	    return answer;
	}
}
