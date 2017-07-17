
public class Card {
	
	/* cardID -- value from 1 to 52
	 * cardName -- verbal representation of card, to be shown to user
	 * pointValue -- value of card to be added to formula for total hand value. e.g. 2 for a 2 of clubs, 14 for an ace of hearts
	 * suitValue -- numeric value to represent suit of card, for use in evaluating straight hands and high card ties: 
	 * 				0 for clubs, 1 for diamonds, 2 for hearts, 3 for spades.
	 */
	
	public int cardID;
	public String cardName;
	public int pointValue;
	public int suitValue;
}
