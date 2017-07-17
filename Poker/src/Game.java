import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {
		
		Player user = new Player();
		Player computer = new Player();
		
		// create an array (deck) out of the above cards and return
		
		Card[] theDeck = Deck.createCards();

		user.drawHand( theDeck );
		computer.drawHand( theDeck );
		
//		//make sure none of the cards in the computer's hand matches the user's hand
//		for( int i = 0; i < 5; i++){		
//			for( int j = 0; j < 5; j++){
//				if(computer.hand[i] == user.hand[j]){
//					computer.drawHand(theDeck);
//				}
//			}
//		}
		
		
		
		JOptionPane.showMessageDialog(null, "Your hand: \n" + user.hand[0].cardName + '\n' + user.hand[1].cardName + '\n' +
											user.hand[2].cardName + '\n' + user.hand[3].cardName + '\n' + 
											user.hand[4].cardName + '\n');
		
		JOptionPane.showMessageDialog(null, "Computer's hand: \n" + computer.hand[0].cardName + '\n' + computer.hand[1].cardName + '\n' +
											computer.hand[2].cardName + '\n' + computer.hand[3].cardName + '\n' + 
											computer.hand[4].cardName + '\n');
				
	}

}
