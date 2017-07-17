import java.util.Random;

public class Player {

	private int balance = 0;
	private static Card[] hand = new Card[5];
	
	public static void createDeck() {
		
		// create a deck using the above card objects in random order
	
		Card[] theDeck = Deck.createCards();
		
		
		
		// make selection a random number from 0 to 51
		int selection;
		final int upperBound = 51;
		final int lowerBound = 0;
		
		Random generator = new Random();
		
		selection = generator.nextInt();
		selection = Math.abs(selection);
		selection %= ( upperBound - lowerBound );
		selection += lowerBound;
		
		
		
		for( int i = 0; i < 5; i++ ){
			
			do{
				hand[i] = theDeck[selection];
			} while (hand[0] != theDeck[selection] && hand[1] != theDeck[selection] && 
				 hand[2] != theDeck[selection] &&  hand[3] != theDeck[selection] && 
				 hand[4] != theDeck[selection] );
		
			
			
		}
		
		System.out.println( hand[0].cardName + "'" );
		
		
		
		
		
		
	}
	
	
	
}
