

import java.util.Random;

public class Player {

	private int balance = 0;
	public static Card[] hand = new Card[5];
	
	public static Card[] drawHand( Card[] theDeck) {
		
		// create a deck
		
		
		// make 'selection' variable a random number from 0 to 51
		int selection;
		final int upperBound = 51;
		final int lowerBound = 0;
		Random generator = new Random();
		
		for( int i = 0; i < 5; i++ ){
		
			selection = generator.nextInt();
			selection = Math.abs(selection);
			selection %= ( upperBound - lowerBound );
			selection += lowerBound;
				
			// make sure the card hasn't already been selected
			
			while ( hand[0] == theDeck[selection] || hand[1] == theDeck[selection] ||
	 				hand[2] == theDeck[selection] ||  hand[3] == theDeck[selection] ||
	 				hand[4] == theDeck[selection] ) {
				
//				System.out.println("already selected...");
				selection = generator.nextInt();
				selection = Math.abs(selection);
				selection %= ( upperBound - lowerBound );
				selection += lowerBound;
				
			}
			
			hand[i] = theDeck[selection];
			
//  			System.out.println( selection );
  				
		}
		
		return hand;
	}	
}
