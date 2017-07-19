import javax.swing.JOptionPane;
import java.util.Random;

public class Game 
{

	public static void main(String[] args) 
	{
		Game.runGame();		
	}
	
	
	private static void runGame()
	{
		// bothPlayers[0] is the user, bothPlayers[1] is the computer
		Player[] bothPlayers = Game.createPlayers();
		
		//counts the number of rounds
		int round = 0;
		
		//if player folds, make true so that the player who folded can't still win
		boolean playerFolded = false;
		
		//terminate while loop when either player hits 0 balance
		while ( bothPlayers[0].balance > 0 && bothPlayers[1].balance > 0 )
		{
		
			//if round is even, the user bets first. If odd, computer bets first.
			if ( round % 2 == 0 )
			{
				
				//call countPoints on each player to determine their hand values
				int userPoints = Game.countPoints( bothPlayers[0].hand );
				int computerPoints = Game.countPoints( bothPlayers[1].hand );
				
				//determine whose hand has the higher point value
				boolean userHasHigherHand = Game.determinePlayerWithHigherHand( userPoints, computerPoints );	
				
				//for user in computer's decision making process
				boolean computerWillBet = false;
				boolean computerWillRaise = false;
				
				//initialize pot and bet amounts
				int amountInPot = 0;
				int amountUserBet = 0;
				int amountComputerBet = 0;
				
				//ask the user how much they want to bet
				int amountUserWantsToBet = Integer.parseInt( JOptionPane.showInputDialog("Round " + round + 
																			  "\n\nYour balance: " + bothPlayers[0].balance +
																			  "\nPot: " + amountInPot + 
																			  "\nPlace a bet: " ) );	
				
				//determine if the amount they want to bet is valid. Must be greater than 0 and less than balance.
				if ( amountUserWantsToBet <= 0 || amountUserWantsToBet > bothPlayers[0].balance )
				{
					
					//tell the user their bet is invalid
					amountUserWantsToBet = Integer.parseInt( JOptionPane.showInputDialog("INVALID BET. \n Bet must be greater than 0 and less than your balance." + "\n\nRound " + round + 
							  "\n\nYour balance: " + bothPlayers[0].balance +
							  "\nPot: " + amountInPot + 
							  "\nPlace a bet: " ) );
					
				} 
				else 
				{	
					//amount user wants to bet is valid, make it the actual bet
					amountUserBet = amountUserWantsToBet;
				}
				
				//subtract that bet from the user's balance
				bothPlayers[0].balance -= amountUserBet;
				
				//add their bet to the pot
				amountInPot += amountUserBet;
				
				//use the variables above as parameters in the methods that help the computer decide what to do
				computerWillBet = Game.decisionToBet(amountInPot, bothPlayers[1].balance, computerPoints);
				computerWillRaise = Game.decisionToRaise(amountInPot, bothPlayers[1].balance, computerPoints);
				
				//do different procedures depending on if computer will raise, call, or fold
				if (computerWillRaise) 
				{
					//initialize raise variable
					int amountComputerRaise = 0;
					
					//determine how much to raise by
					amountComputerRaise = amountUserBet + computerPoints / 5 ;
					
					//if the computer raises more than the player even has, maximize its bet
					if( amountComputerBet > bothPlayers[0].balance )
					{
						amountComputerRaise = bothPlayers[0].balance;
					}
					
					//subtract bet from computer's balance
					bothPlayers[1].balance -= amountComputerRaise + amountUserBet;
					
					//add raise to pot
					amountInPot += amountComputerRaise;			
					
					//determine whether user will accept the raise or fold
					String userDecisionToMatchRaise = JOptionPane.showInputDialog(null, "Computer raises your bet to " +  amountComputerRaise + 
																						".\n Pot: " + amountInPot +
																						".\n Match the raise by entering y. If you want to fold, enter 0.\n\nYour hand: \n" + 
															 							bothPlayers[0].hand[0].cardName + "\n" +  
															 							bothPlayers[0].hand[1].cardName + "\n" +
															 							bothPlayers[0].hand[2].cardName + "\n" + 
															 							bothPlayers[0].hand[3].cardName + "\n" + 
															 							bothPlayers[0].hand[4].cardName); 
					
					
					//if folds, computer will win. else add raise to pot
					if ( userDecisionToMatchRaise.equals("0") )
					{						
						
						//make this boolean true so that even if the player's hand is higher, the program will not say the play won
						playerFolded = true;
						
						JOptionPane.showMessageDialog(null, "You folded. Computer wins the hand.");	
						
					} 
					else 
					{
						
						//subtract the computer's raise from the user's balance
						bothPlayers[0].balance -= amountComputerRaise;
						
						//add a second value of the computer's bet to the pot, which is actually the user's raise
						amountInPot += amountComputerRaise;
					
					} 
					
					
				}
				
				else if ( computerWillBet )
				{
					
					amountComputerBet = amountUserBet;
					amountInPot += amountComputerBet;
					
					JOptionPane.showMessageDialog(null, "Computer accepts your bet of " + amountComputerBet);
			
				} 
				else 
				{
					//get the initial bet back in the user's balance
					bothPlayers[0].balance += amountInPot;
					
					JOptionPane.showMessageDialog(null, "Computer folds.");
				}
				
				
				if ( userHasHigherHand && !playerFolded  )
				{
					
					//award pot to user
					bothPlayers[0].balance += amountInPot;
				
					//show hand and tell user they won
					JOptionPane.showMessageDialog(null, "You win the hand." + "\n\nYour hand: \n" + bothPlayers[0].hand[0].cardName + '\n' +  bothPlayers[0].hand[1].cardName + '\n' +
							bothPlayers[0].hand[2].cardName + '\n' + bothPlayers[0].hand[3].cardName + '\n' + 
							bothPlayers[0].hand[4].cardName + 
							"\n\n\n" +
							"Computer's hand: \n" + bothPlayers[1].hand[0].cardName + '\n' + bothPlayers[1].hand[1].cardName + '\n' +
							bothPlayers[1].hand[2].cardName + '\n' + bothPlayers[1].hand[3].cardName + '\n' + 
							bothPlayers[1].hand[4].cardName + '\n');
					
					
				} 
				else 
				{
					//award pot to computer
					bothPlayers[1].balance += amountInPot;
					
					//show hand and tell user the computer won
					JOptionPane.showMessageDialog(null, "Computer wins the hand." + "\n\nYour hand: \n" + bothPlayers[0].hand[0].cardName + '\n' +  bothPlayers[0].hand[1].cardName + '\n' +
							bothPlayers[0].hand[2].cardName + '\n' + bothPlayers[0].hand[3].cardName + '\n' + 
							bothPlayers[0].hand[4].cardName + 
							"\n\n\n" +
							"Computer's hand: \n" + bothPlayers[1].hand[0].cardName + '\n' + bothPlayers[1].hand[1].cardName + '\n' +
							bothPlayers[1].hand[2].cardName + '\n' + bothPlayers[1].hand[3].cardName + '\n' + 
							bothPlayers[1].hand[4].cardName + "\n\n\n" +
							"Your balance is now " + bothPlayers[0].balance);
					
				}
				
				//increment round
				round++;
				
				
				
			} 
			// if the round is odd numbered, the computer bids first.		
			else 
			{

				int userPoints = Game.countPoints( bothPlayers[0].hand );
				int computerPoints = Game.countPoints( bothPlayers[1].hand );
	
				boolean userHasHigherHand = Game.determinePlayerWithHigherHand( userPoints, computerPoints );	
					
				boolean computerWillBet = false;
				
				int amountInPot = 0;
				int amountUserBet = 0;
				int amountComputerBet = 0;
				
				//determine how much computer will bet
				amountComputerBet = Game.countPoints( bothPlayers[1].hand ) / 10;
				
				//add computer's bet to the pot
				amountInPot += amountComputerBet;
				
				//prompt the user to call, fold, or raise
				String userPlayDecision = JOptionPane.showInputDialog( "The computer's inital bet is " + amountComputerBet + 
						                                               ". Would you like to call, raise or fold?\n"
						                                               + "If call, enter " + amountComputerBet + ".\n If raise, enter a number greater than that.\n"
						                                               + " If fold, enter 0.\n");

				//throw exception if user enters something other than a number
				try 
				{
					Integer.parseInt(userPlayDecision);
				} catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "You didn't input a number and you broke the whole program.");
				}
				
				//parse integer to amountUserBet variable
				amountUserBet = Integer.parseInt(userPlayDecision);
				
				//keep prompting if user attempts to enter a bet lower than the computer's bet
				while ( amountUserBet < amountComputerBet )
				{
					userPlayDecision = JOptionPane.showInputDialog( "INVALID VALUE. Your bet has to be equal to or greater than the computer's.\n\n "
							+ "The computer's inital bet is " + amountComputerBet + 
                            ". Would you like to call, raise or fold?\n"
                            + "If call, enter " + amountComputerBet + ".\n If raise, enter a number greater than that.\n"
                            + " If fold, enter 0.\n");
				}
				
				//once determined a valid integer, subtract user's bet from their balance
				bothPlayers[0].balance -= amountUserBet;
				
				//did the user call (if), raise (else if), or fold (else)?
				if ( amountUserBet == amountComputerBet )
				{
					
					//if the user bet is equal to the computer bet, evaluate hands and determine winner
					amountInPot += amountUserBet;
					
					
				} 
				else if ( amountUserBet > amountComputerBet )
				{
					
					//user raises
					
					//the amount will equal to the total bet minus the computer's bet
					int amountUserRaise = amountUserBet - amountComputerBet;
					
					//if the user raises more than the computer even has, maximize their bet
					if( amountUserBet > bothPlayers[1].balance )
					{
						amountUserBet = bothPlayers[1].balance;
						JOptionPane.showMessageDialog(null, "Computer only has " + bothPlayers[1].balance + " in balance.\n Raising the that amount." );
					}		
					
					//decide if computer will accept the raise, or fold
					computerWillBet = Game.decisionToBet(amountInPot, bothPlayers[1].balance, computerPoints);
					
					
					if ( computerWillBet )
					{						
						
						//subtract the user's raise from the computer's balance
						bothPlayers[1].balance -= amountUserRaise;
						
						//add the user's raise, which is the computer's money
						amountInPot += amountUserRaise;
						
					} 
					else 
					{
											
						//make this boolean true so that even if the player's hand is higher, the program will not say the play won
						playerFolded = true;
						
						JOptionPane.showMessageDialog(null, "The computer folded. You win the hand.");	
					} 
					
				}
				
				if ( userHasHigherHand || playerFolded )
				{
					
					//add pot to user's balance
					bothPlayers[0].balance += amountInPot;
					amountInPot = 0;
				
					//display results
					JOptionPane.showMessageDialog(null, "You win the hand." + "\n\nYour hand: \n" + bothPlayers[0].hand[0].cardName + '\n' +  bothPlayers[0].hand[1].cardName + '\n' +
							bothPlayers[0].hand[2].cardName + '\n' + bothPlayers[0].hand[3].cardName + '\n' + 
							bothPlayers[0].hand[4].cardName + 
							"\n\n\n" +
							"Computer's hand: \n" + bothPlayers[1].hand[0].cardName + '\n' + bothPlayers[1].hand[1].cardName + '\n' +
							bothPlayers[1].hand[2].cardName + '\n' + bothPlayers[1].hand[3].cardName + '\n' + 
							bothPlayers[1].hand[4].cardName + '\n');
					
					
				} 
				else 
				{
					
					//add pot to computer's balance
					bothPlayers[1].balance += amountInPot;
					amountInPot = 0;
					
					
					JOptionPane.showMessageDialog(null, "Computer wins the hand." + "\n\nYour hand: \n" + bothPlayers[0].hand[0].cardName + '\n' +  bothPlayers[0].hand[1].cardName + '\n' +
							bothPlayers[0].hand[2].cardName + '\n' + bothPlayers[0].hand[3].cardName + '\n' + 
							bothPlayers[0].hand[4].cardName + 
							"\n\n\n" +
							"Computer's hand: \n" + bothPlayers[1].hand[0].cardName + '\n' + bothPlayers[1].hand[1].cardName + '\n' +
							bothPlayers[1].hand[2].cardName + '\n' + bothPlayers[1].hand[3].cardName + '\n' + 
							bothPlayers[1].hand[4].cardName + "\n\n\n" +
							"Your balance is now " + bothPlayers[0].balance);
					
				}		
				
				round++;
			}	
			
		}
		
		
		
		
		//determine who wins after end game status.
		if ( bothPlayers[0].balance <= 0 )
		{
			JOptionPane.showMessageDialog(null, "Your balance is 0. Game over.");
		} 
		else 
		{
			JOptionPane.showMessageDialog(null, "The computer's balance is 0. You broke the bank.");
		}
	}
	
	private static Player[] createPlayers ()
	{
		
		Player user = new Player();
		Player computer = new Player();

		Card[] theDeck = Deck.createCards();
		
		// draw both hands, then compare both hands to make sure none of the cards are the same
		// if they are, redraw the computer's hand.
		
		user.drawHand( theDeck );
		computer.drawHand( theDeck );
		
		for( int i = 0; i < 5; i++)
		{		
			for( int j = 0; j < 5; j++)
			{
				while( computer.hand[i].cardID == user.hand[j].cardID || computer.hand[j].cardID == user.hand[i].cardID  )
				{
					computer.drawHand(theDeck);
				}
			}
		}
		
		
		Player[] bothPlayers = { user, computer };
		
		return bothPlayers;
		
	}
	
	
	// evaluate the various possible hands to determine the points of each hand
	
	private static int countPoints( Card[] playerHand )
	{
		
		int totalPoints = 0;
		

		/*
		 *  evaluate highest card in the hand
		 */
		
		int highestCardValue = 0;
		
		// for use in four of a kind
		int secondHighestCardValue = 0;
		
		
		for( int i = 0; i < 5; i++){
			
			if ( playerHand[i].pointValue > highestCardValue) 
			{
				
				secondHighestCardValue = highestCardValue;
				highestCardValue = playerHand[i].pointValue;
				totalPoints = highestCardValue;
				
			} 
			else if ( playerHand[i].pointValue > secondHighestCardValue )
			{
				
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
		
		for( int i = 0; i < 5; i++)
		{
			for( int j = 0; j < 5; j++)
			{
				if ( playerHand[i].pointValue == playerHand[j].pointValue && i != j  ) 
				{
					
					totalPoints = 14 + highestCardValue;
					
					highestPair = highestCardValue;
					hasOnePair = true;
					pairValue = playerHand[i].pointValue;
					
					hasTwoPair++;
					
//					System.out.println("You have one pair. It's at: " + i + ", " + j);
					
					
					//check for second pair
					
					if ( hasTwoPair == 4 ) 
					{
						
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
		
		for( int n = 0; n < 5; n++)
		{
			for( int j = 0; j < 5; j++)
			{
				for( int k = 0; k < 5; k++)
				{
					if ( playerHand[n].pointValue == playerHand[j].pointValue && 
						 playerHand[n].pointValue == playerHand[k].pointValue && 
						 n != j && n != k && j != k ) 
					{
						
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
		
		for (int i = 0; i < 5; i++) 
		{
            for (int j = i + 1; j < 5; j++) 
            {
                if (playerHand[i].cardID > playerHand[j].cardID) 
                {
                	
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
			 playerHand[0].pointValue == playerHand[4].pointValue - 4 )
		{
			
			isStraight = true;
			totalPoints = 335 + highestCardValue;
			
		}

		
		
		
		/*
		 *  check for flush
		 */
		
		boolean isFlush = false;
		
		if ( playerHand[0].suitValue == playerHand[1].suitValue && 
			 playerHand[1].suitValue == playerHand[2].suitValue &&
			 playerHand[2].suitValue == playerHand[3].suitValue && 
			 playerHand[3].suitValue == playerHand[4].suitValue )
		{
			isFlush = true;
			totalPoints = 349 + highestCardValue;
		}
		
		
		
		
		/*
		 *  check for full house
		 */
		
		if ( hasThreeOfAKind && hasOnePair ) 
		{
			totalPoints = 363 + 20 * threeOfAKindValue + pairValue;
		}
		
		
		
		/*
		 *  check for four of a kind
		 */
		
		for( int n = 0; n < 5; n++)
		{
			for( int j = 0; j < 5; j++)
			{
				for( int k = 0; k < 5; k++)
				{
					for( int m = 0; m < 5; m++)
					{
						if ( playerHand[n].pointValue == playerHand[j].pointValue && 
							 playerHand[n].pointValue == playerHand[k].pointValue && 
							 playerHand[n].pointValue == playerHand[m].pointValue &&
							 n != j && n != k && j != k && n != m && j!= m && k != m ) 
						{
							
							int fourOfAKindValue = 0;
							int remainingCardValue = 0;
							
							fourOfAKindValue = playerHand[n].pointValue;
							
							
							if ( fourOfAKindValue > secondHighestCardValue )
							{
								remainingCardValue = secondHighestCardValue;
							} else 
							{
								remainingCardValue = highestCardValue;
							}
							
							
							totalPoints = 656 + 20 * fourOfAKindValue + remainingCardValue;
		
						}
					}
				}
			}
		}	
		
		
		/*
		 *  check for straight flush
		 */
		
		if ( isStraight && isFlush )
		{
			totalPoints = 949 + highestCardValue;
		}

		return totalPoints;
	}
	
	
	
	private static boolean determinePlayerWithHigherHand( int userPoints, int computerPoints )
	{	
		if ( userPoints > computerPoints )
		{
			return true;
		} 
		else 
		{
			return false;
		}
		
	}
	
	
	
	private static boolean decisionToBet( int totalMoneyInPot, int computerBalance, int valueOfHand ){
	
		
		boolean computerWillBet = false;
		
		int riskFactor = 1000 * totalMoneyInPot / computerBalance - 5  * valueOfHand;
		
		if ( riskFactor < 750 )
		{
			
			computerWillBet = true;					
			
		} 
		else 
		{		
			
			computerWillBet = false;	
			
			// random bluff factor. If bluff < 5, computerWillBet becomes true.
			int bluff;
			final int upperBound = 100;
			final int lowerBound = 1;
			Random generator = new Random();

			bluff = generator.nextInt();
			bluff = Math.abs(bluff);
			bluff %= ( upperBound - lowerBound );
			bluff += lowerBound;
			
			if( bluff < 5 )
			{
				computerWillBet = true;
			}
			
		}
		
		return computerWillBet;
		
	}
	
	
	
	private static boolean decisionToRaise( int totalMoneyInPot, int computerBalance, int valueOfHand )
	{
	
		
		boolean computerWillRaise = false;
		
		int riskFactor = 1000 * totalMoneyInPot / computerBalance - 5  * valueOfHand;
		
		// only difference between this and decisionToBet is that the threshold is lower for riskFactor, i.e. the better hand
		// the computer has, the more likely it is to raise.
		
		if ( riskFactor < 100 )
		{
			
			computerWillRaise = true;					
			
		} 
		else 
		{		
			
			computerWillRaise = false;	
			
			// random bluff factor. If bluff < 5, computerWillBet becomes true.
			int bluff;
			final int upperBound = 100;
			final int lowerBound = 1;
			Random generator = new Random();

			bluff = generator.nextInt();
			bluff = Math.abs(bluff);
			bluff %= ( upperBound - lowerBound );
			bluff += lowerBound;
			
			if( bluff < 5 )
			{
				computerWillRaise = true;
			}
			
		}
		
		return computerWillRaise;
		
	}
	
	
	
	
}
