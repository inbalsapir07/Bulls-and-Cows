/**
 * Question 1, maman 11.
 * 
 * @author (Inbal Sapir)
 * @version (November 06, 2020)
 */
import javax.swing.JOptionPane;
public class BullsAndCowsGame 
{
	/**
	 * The main method of the game Bulls and Cows.
	 * The game chooses a four digits long number, with only different digits,
	 * that the user has to guess.
	 * The game is over when the user guesses all four digits of the number
	 * and their exact place in the number.
	 * When the game is over, the user can choose to start a new game.
	 */
	public static void main(String[] args) 
	{
		JOptionPane.showMessageDialog(null, "Welcome to the game Bulls and Cows!");
		int again=0; // the user's wish to play another game or to quit
		do
		{
			Game game = new Game (); // starting new game
			String guess; // the user's guess
			boolean isLegal; // true if the user's guess input is legal, false otherwise
			String result=""; // the results of all the user's guesses
			int counter=0; // counts the number of guesses
			do
			{
				counter++;
				do 
				{
					guess=JOptionPane.showInputDialog("Please enter your guess: ");
					isLegal=BullsAndCowsGame.isLegal (guess);
				}
				while(isLegal==false); // asks the user for his guess until a legal input is received
				result=result+game.calculation(guess, counter); // calculates the result of the guess
				JOptionPane.showMessageDialog(null, result);
			}
			while(!result.endsWith(".")); // asks the user for his guess until user wins the game
			again=JOptionPane.showConfirmDialog (null, "Do you want to start a new game?");
		}
		while (again==0); // playing the game until user doesn't want to play anymore
	}
	/**
	 * Gets a reference String.
	 * Checks whether the String is 4 characters long,
	 * include only digits and has no identical digits.
	 * @param input the reference String
	 * @return true if the refernce String is 4 characters long,
	 * include only digits and has no identical digits; false otherwise
	 */
	public static boolean isLegal (String input)
	{
		boolean isLegal=false; // true if input is legal, false otherwise 
		if (input.length()!=4) // if input is not exactly 4 characters long
		{
			JOptionPane.showMessageDialog(null, "Bad input; The input must be exactly 4 digits long", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1)) ||
					!Character.isDigit(input.charAt(2)) || !Character.isDigit(input.charAt(3)) ) // if input doesn't include only digits
			{
				JOptionPane.showMessageDialog(null, "Bad input; The input must include only digits", "Error", 
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (input.charAt(0)==input.charAt(1) || input.charAt(0)==input.charAt(2) || 
						input.charAt(0)==input.charAt(3) || input.charAt(1)==input.charAt(2) ||
						input.charAt(1)==input.charAt(3) || input.charAt(2)==input.charAt(3)) // if 2 digits or more of the input are identical
				{
					JOptionPane.showMessageDialog(null, "Bad input; The input must include only different digits",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				else // input is legal
				{
					isLegal=true;
				}
			}
		}
		return isLegal;	
	}

}

