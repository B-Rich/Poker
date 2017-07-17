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
		
		JOptionPane.showMessageDialog(null, "Your hand: \n" + user.hand[0].cardName + '\n' +  user.hand[1].cardName + '\n' +
				user.hand[2].cardName + '\n' + user.hand[3].cardName + '\n' + 
				user.hand[4].cardName + '\n');
		
		
		
		System.out.println("Computer's hand: \n" + computer.hand[0].cardName + '\n' + computer.hand[1].cardName + '\n' +
				computer.hand[2].cardName + '\n' + computer.hand[3].cardName + '\n' + 
				computer.hand[4].cardName + '\n');
	}
}
