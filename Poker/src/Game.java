import javax.swing.JOptionPane;
import java.util.Random;

public class Game {

	public static void main(String[] args) {
		
		
		Player[] bothPlayers = Game.createPlayers();
		
		int userPoints = Game.countPoints( bothPlayers[0].hand );
		System.out.println( userPoints );
		
		int computerPoints = Game.countPoints( bothPlayers[1].hand );
		System.out.println( computerPoints );
		
		
		boolean userHasHigherHand = Game.determinePlayerWithHigherHand( userPoints, computerPoints );
		
		if ( userHasHigherHand ){
			System.out.println("user is posed to win");
		} else {
			System.out.println("computer is posed to win");
		}
		
		
		
		
		
		
		boolean computerWillBet = Game.decisionToBet(20, 90, computerPoints);
		
	}
	
	
	private static Player[] createPlayers (){
		
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
		
		
		Player[] bothPlayers = { user, computer };
		
		
		JOptionPane.showMessageDialog(null, "Your hand: \n" + user.hand[0].cardName + '\n' +  user.hand[1].cardName + '\n' +
											user.hand[2].cardName + '\n' + user.hand[3].cardName + '\n' + 
											user.hand[4].cardName + '\n');
		
		System.out.println( "Your hand: \n" + user.hand[0].cardName + '\n' +  user.hand[1].cardName + '\n' +
							user.hand[2].cardName + '\n' + user.hand[3].cardName + '\n' + 
							user.hand[4].cardName + '\n');
		
		System.out.println("Computer's hand: \n" + computer.hand[0].cardName + '\n' + computer.hand[1].cardName + '\n' +
							computer.hand[2].cardName + '\n' + computer.hand[3].cardName + '\n' + 
							computer.hand[4].cardName + '\n');
		
	
		
		return bothPlayers;
		
	}
	
// evaluate        the various possible hands to determine the points of each hand
	
	private static int countPoints( Card[] playerHand ){
		
		int totalPoints = 0;
		

		/*
		 *  evaluate highest card in the hand
		 */
		
		int highestCardValue = 0;
		
		// for use in four of a kind
		int secondHighestCardValue = 0;
		
		
		for( int i = 0; i < 5; i++){
			
			if ( playerHand[i].pointValue > highestCardValue) {
				
				secondHighestCardValue = highestCardValue;
				highestCardValue = playerHand[i].pointValue;
				totalPoints = highestCardValue;
				
			} else if ( playerHand[i].pointValue > secondHighestCardValue ){
				
				secondHighestCardValue = playerHand[i].pointValue;
				
//				System.out.println( "second highest: " + secondHighestCardValue );
			}
		
		}

		
		
		/*
		 *  check for one pair
		 */
		
		int highestPair = 0;
		int lowestPair = 0;
		boolean hasOnePair = false;
		
		//for use in full house evaluation
		
		int pairValue = 0;
		
		// if this equals 4, (i.e. two increments for each pair), there are two pairs. If one pair it'll only increase to 2.0
		
		int hasTwoPair = 0;
		
		for( int i = 0; i < 5; i++){
			for( int j = 0; j < 5; j++){
				if ( playerHand[i].pointValue == playerHand[j].pointValue && i != j  ) {
					
					totalPoints = 14 + highestCardValue;
					
					highestPair = highestCardValue;
					hasOnePair = true;
					pairValue = playerHand[i].pointValue;
					
					hasTwoPair++;
					
//					System.out.println("You have one pair. It's at: " + i + ", " + j);
					
					
					//check for second pair
					
					if ( hasTwoPair == 4 ) {
						
						lowestPair = playerHand[j].pointValue;
						
						totalPoints = 28 + 20 * highestPair + lowestPair;

//						System.out.println("You have two pair. The second is at: " + i + " " + j );
					}
			
				}
			}
		}
			
		
		
		/*
		 *  check for three of a kind
		 */
		
		
		//for use in full house evaluation
		
		boolean hasThreeOfAKind = false;
		int threeOfAKindValue = 0;
		
		for( int n = 0; n < 5; n++){
			for( int j = 0; j < 5; j++){
				for( int k = 0; k < 5; k++){
					if ( playerHand[n].pointValue == playerHand[j].pointValue && 
						 playerHand[n].pointValue == playerHand[k].pointValue && 
						 n != j && n != k && j != k ) {
						
						totalPoints = 321 + highestCardValue;
						hasThreeOfAKind = true;
						threeOfAKindValue = playerHand[n].pointValue;
						
//						System.out.println("You have three of a kind. They're at: " + n + ", " + j + ", " + k);	
					}
				}
			}
		}
		
		
		
		/*
		 *  check for straight
		 */
		
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
		
		if ( playerHand[0].pointValue == playerHand[1].pointValue - 1 && 
			 playerHand[0].pointValue == playerHand[2].pointValue - 2 &&
			 playerHand[0].pointValue == playerHand[3].pointValue - 3 && 
			 playerHand[0].pointValue == playerHand[4].pointValue - 4 ){
			
			isStraight = true;
			totalPoints = 335 + highestCardValue;
			
//			System.out.println("You have a straight.");
			
		}

		
		
		
		/*
		 *  check for flush
		 */
		
		boolean isFlush = false;
		
		if ( playerHand[0].suitValue == playerHand[1].suitValue && 
			 playerHand[1].suitValue == playerHand[2].suitValue &&
			 playerHand[2].suitValue == playerHand[3].suitValue && 
			 playerHand[3].suitValue == playerHand[4].suitValue ){
			
			isFlush = true;
			totalPoints = 349 + highestCardValue;
			
//			System.out.println("You have a flush.");
		}
		
		
		
		
		/*
		 *  check for full house
		 */
		
		if ( hasThreeOfAKind && hasOnePair ) {
			totalPoints = 363 + 20 * threeOfAKindValue + pairValue;
			
//			System.out.println("You have a full house.");
		}
		
		
		
		/*
		 *  check for four of a kind
		 */
		
		for( int n = 0; n < 5; n++){
			for( int j = 0; j < 5; j++){
				for( int k = 0; k < 5; k++){
					for( int m = 0; m < 5; m++){
						if ( playerHand[n].pointValue == playerHand[j].pointValue && 
							 playerHand[n].pointValue == playerHand[k].pointValue && 
							 playerHand[n].pointValue == playerHand[m].pointValue &&
							 n != j && n != k && j != k && n != m && j!= m && k != m ) {
							
							int fourOfAKindValue = 0;
							int remainingCardValue = 0;
							
							fourOfAKindValue = playerHand[n].pointValue;
							
							
							if ( fourOfAKindValue > secondHighestCardValue ){
								remainingCardValue = secondHighestCardValue;
							} else {
								remainingCardValue = highestCardValue;
							}
							
							
							totalPoints = 656 + 20 * fourOfAKindValue + remainingCardValue;
		
//							System.out.println("You have four of a kind. Remaining card is : " +  remainingCardValue );	
						}
					}
				}
			}
		}	
		
		
		/*
		 *  check for straight flush
		 */
		
		if ( isStraight && isFlush ){
			totalPoints = 949 + highestCardValue;
//			System.out.println("You have a straight flush.");
		}

		return totalPoints;
	}
	
	
	
	private static boolean determinePlayerWithHigherHand( int userPoints, int computerPoints ){
			
		if ( userPoints > computerPoints ){
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	private static boolean decisionToBet( int totalMoneyInPot, int computerBalance, int valueOfHand ){
	
		
		boolean computerWillBet = false;
		
		int riskFactor = 1000 * totalMoneyInPot / computerBalance - 5  * valueOfHand;
		System.out.println( riskFactor );
		
		if ( riskFactor < 750 ){
			
			computerWillBet = true;		
			
			
			
			// random bluff factor. If bluff < 5, computerWillBet becomes true.
			int bluff;
			final int upperBound = 100;
			final int lowerBound = 1;
			Random generator = new Random();

			bluff = generator.nextInt();
			bluff = Math.abs(bluff);
			bluff %= ( upperBound - lowerBound );
			bluff += lowerBound;
			
			if( bluff < 5 ){
				computerWillBet = false;
			}
			
			
			
		} else {		
			computerWillBet = false;	
		}
		
		return computerWillBet;
		
	}
	
	
	
}
