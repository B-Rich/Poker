import java.util.Random;

public class Player 
{

	public int balance = 100;
	public Card[] hand = new Card[5];
	
	public Card[] drawHand( Card[] theDeck ) 
	{	
		// make 'selection' variable a random number from 0 to 51
		int selection;
		final int upperBound = 51;
		final int lowerBound = 0;
		Random generator = new Random();
		
		//make five random selections from the deck and add them to hand
		for( int i = 0; i < 5; i++ )
		{
			selection = generator.nextInt();
			selection = Math.abs(selection);
			selection %= ( upperBound - lowerBound );
			selection += lowerBound;
				
			// make sure the card hasn't already been selected. If it is, regenerate random
			while ( hand[0] == theDeck[selection] || hand[1] == theDeck[selection] ||
	 				hand[2] == theDeck[selection] ||  hand[3] == theDeck[selection] ||
	 				hand[4] == theDeck[selection] ) 
			{
				selection = generator.nextInt();
				selection = Math.abs(selection);
				selection %= ( upperBound - lowerBound );
				selection += lowerBound;
			}
			
			hand[i] = theDeck[selection];
		}
		
		return hand;
	}	
}
