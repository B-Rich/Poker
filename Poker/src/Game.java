import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {
		
		Player user = new Player();
		Player computer = new Player();

		Card[] theDeck = Deck.createCards();
		
		// draw both hands, then compare both hands to make sure none of the cards are the same
		// if they are, redraw the computer's hand.
		
		user.drawHand( theDeck );
		computer.drawHand( theDeck );
		
		for( int i = 0; i < 5; i++){		
			for( int j = 0; j < 5; j++){
				while( computer.hand[i].cardID == user.hand[j].cardID || computer.hand[j].cardID == user.hand[i].cardID  ){
					computer.drawHand(theDeck);
				}
			}
		}
		
//		JOptionPane.showMessageDialog(null, "Your hand: \n" + user.hand[0].cardName + '\n' +  user.hand[1].cardName + '\n' +
//				user.hand[2].cardName + '\n' + user.hand[3].cardName + '\n' + 
//				user.hand[4].cardName + '\n');
		
		System.out.println( "Your hand: \n" + user.hand[0].cardName + '\n' +  user.hand[1].cardName + '\n' +
				user.hand[2].cardName + '\n' + user.hand[3].cardName + '\n' + 
				user.hand[4].cardName + '\n');
		
//		System.out.println("Computer's hand: \n" + computer.hand[0].cardName + '\n' + computer.hand[1].cardName + '\n' +
//				computer.hand[2].cardName + '\n' + computer.hand[3].cardName + '\n' + 
//				computer.hand[4].cardName + '\n');
		
		int userPoints = Game.countPoints(user.hand);
		System.out.println( userPoints );
	}
	
	
	private static int countPoints( Card[] playerHand ){
		
		int totalPoints = 0;
		
		int highestCardValue = 0;
		
		//for use in full house evaluations
		int secondHighestCardValue = 0;

		// evaluate highest and second highest card in the hand
		for( int i = 0; i < 5; i++){
			
			if ( playerHand[i].pointValue > highestCardValue) {
				
				secondHighestCardValue = highestCardValue;
				highestCardValue = playerHand[i].pointValue;
				totalPoints = highestCardValue;
				
			} else if ( playerHand[i].pointValue > secondHighestCardValue ) {
				
				secondHighestCardValue = playerHand[i].pointValue;
				
			}
		}
		
		
		
		// check for one pair
		
		int highestPair = 0;
		int lowestPair = 0;
//		boolean hasOnePair = false;
		
		for( int i = 0; i < 5; i++){
			for( int j = 0; j < 5; j++){
				if ( playerHand[i].pointValue == playerHand[j].pointValue && i != j  ) {
					
					totalPoints = 14 + highestCardValue;
					
					highestPair = highestCardValue;
//					hasOnePair = true;
					
					if ( playerHand[i].pointValue == playerHand[j].pointValue && i != j &&
						 highestPair != playerHand[i].pointValue && highestPair != playerHand[j].pointValue ) {
						
//						lowestPair = playerHand[i].pointValue;
						
//						totalPoints = 28 + 20 * highestPair + lowestPair;
						System.out.println("You have two pair. The second is at: " + i + " " + j );
					}
					
					System.out.println("You have one pair. It's at: " + i + ", " + j);	
				}
			}
		}
				
        // check for two pair
		
		
		
		// check for three of a kind
		
		for( int n = 0; n < 5; n++){
			for( int j = 0; j < 5; j++){
				for( int k = 0; k < 5; k++){
					if ( playerHand[n].pointValue == playerHand[j].pointValue && 
						 playerHand[n].pointValue == playerHand[k].pointValue && 
						 n != j && n != k && j != k ) {
						
						totalPoints = 321 + highestCardValue;
	
						System.out.println("You have three of a kind. They're at: " + n + ", " + j + ", " + k);	
					}
				}
			}
		}
		
		
		
		// check for straight
		
		boolean isStraight = false;
		int temporary;
		
		// sort hand in ascending order
		
		for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (playerHand[i].cardID > playerHand[j].cardID) {
                    temporary = playerHand[i].cardID;
                    playerHand[i].cardID = playerHand[j].cardID;
                    playerHand[j].cardID = temporary;
                }
            }
        }
		
		// check if hand is straight
		
		if ( playerHand[0].cardID == playerHand[1].cardID - 1 && 
			 playerHand[0].cardID == playerHand[2].cardID - 2 &&
			 playerHand[0].cardID == playerHand[3].cardID - 3 && 
			 playerHand[0].cardID == playerHand[4].cardID - 4 ){
			
			isStraight = true;
			totalPoints = 335 + highestCardValue;
			
		}

		
		
		// check for flush
		
		boolean isFlush = false;
		
		if ( playerHand[0].suitValue == playerHand[1].suitValue && 
			 playerHand[1].suitValue == playerHand[2].suitValue &&
			 playerHand[2].suitValue == playerHand[3].suitValue && 
			 playerHand[3].suitValue == playerHand[4].suitValue ){
			
			isFlush = true;
			totalPoints = 349 + highestCardValue;
		}
		
		
		
		
		// check for full house
		
		
		// check for four of a kind
		
		for( int n = 0; n < 5; n++){
			for( int j = 0; j < 5; j++){
				for( int k = 0; k < 5; k++){
					for( int m = 0; m < 5; m++){
						if ( playerHand[n].pointValue == playerHand[j].pointValue && 
							 playerHand[n].pointValue == playerHand[k].pointValue && 
							playerHand[n].pointValue == playerHand[m].pointValue &&
							 n != j && n != k && j != k && n != m && j!= m && k != m ) {
							
							//not sure how to formalize this
					//		totalPoints = 656 + 20 * playerHand[n].pointValue + REMAININGCARD ;
		
							System.out.println("You have four of a kind. They're at: " + n + ", " + j + ", " + k + ", " + m);	
						}
					}
				}
			}
		}
		
		
		
		// check for straight flush
		
		if ( isStraight && isFlush ){
			totalPoints = 949 + highestCardValue;
		}
		
		
		
		
		return totalPoints;
	}
	
	
	
//	private boolean determineWinner( Card[] hand1, Card[] hand2 ){
//		
//		
//		if ( hand1 > hand2 )
//		
//		return false;
//	}
}
