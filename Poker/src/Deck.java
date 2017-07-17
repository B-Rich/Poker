
public class Deck {

	public static Card[] createCards() {
		
		//instantiate 52 card objects to create a full deck
		
		//clubs
		
		Card twoOfClubs = new Card();
		twoOfClubs.cardID = 0;
		twoOfClubs.cardName = "2 of clubs";
		twoOfClubs.pointValue = 2;
		twoOfClubs.suitValue = 0;
		
		Card threeOfClubs = new Card();
		threeOfClubs.cardID = 1;
		threeOfClubs.cardName = "3 of clubs";
		threeOfClubs.pointValue = 3;
		threeOfClubs.suitValue = 0;

		Card fourOfClubs = new Card();
		fourOfClubs.cardID = 2;
		fourOfClubs.cardName = "4 of clubs";
		fourOfClubs.pointValue = 4;
		fourOfClubs.suitValue = 0;
		
		Card fiveOfClubs = new Card();
		fiveOfClubs.cardID = 3;
		fiveOfClubs.cardName = "5 of clubs";
		fiveOfClubs.pointValue = 5;
		fiveOfClubs.suitValue = 0;
	
		Card sixOfClubs = new Card();
		sixOfClubs.cardID = 4;
		sixOfClubs.cardName = "6 of clubs";
		sixOfClubs.pointValue = 6;
		sixOfClubs.suitValue = 0;
		
		Card sevenOfClubs = new Card();
		sevenOfClubs.cardID = 5;
		sevenOfClubs.cardName = "7 of clubs";
		sevenOfClubs.pointValue = 7;
		sevenOfClubs.suitValue = 0;
		
		Card eightOfClubs = new Card();
		eightOfClubs.cardID = 6;
		eightOfClubs.cardName = "8 of clubs";
		eightOfClubs.pointValue = 8;
		eightOfClubs.suitValue = 0;
		
		Card nineOfClubs = new Card();
		nineOfClubs.cardID = 7;
		nineOfClubs.cardName = "9 of clubs";
		nineOfClubs.pointValue = 9;
		nineOfClubs.suitValue = 0;
		
		Card tenOfClubs = new Card();
		tenOfClubs.cardID = 8;
		tenOfClubs.cardName = "10 of clubs";
		tenOfClubs.pointValue = 10;
		tenOfClubs.suitValue = 0;
		
		Card jackOfClubs = new Card();
		jackOfClubs.cardID = 9;
		jackOfClubs.cardName = "Jack of clubs";
		jackOfClubs.pointValue = 11;
		jackOfClubs.suitValue = 0;
		
		Card queenOfClubs = new Card();
		queenOfClubs.cardID = 10;
		queenOfClubs.cardName = "Queen of clubs";
		queenOfClubs.pointValue = 12;
		queenOfClubs.suitValue = 0;
		
		Card kingOfClubs = new Card();
		kingOfClubs.cardID = 11;
		kingOfClubs.cardName = "King of clubs";
		kingOfClubs.pointValue = 13;
		kingOfClubs.suitValue = 0;
		
		Card aceOfClubs = new Card();
		aceOfClubs.cardID = 12;
		aceOfClubs.cardName = "Ace of clubs";
		aceOfClubs.pointValue = 14;
		aceOfClubs.suitValue = 0;
		
		
		//diamonds
		
		Card twoOfDiamonds = new Card();
		twoOfDiamonds.cardID = 13;
		twoOfDiamonds.cardName = "2 of diamonds";
		twoOfDiamonds.pointValue = 2;
		twoOfDiamonds.suitValue = 1;
		
		Card threeOfDiamonds = new Card();
		threeOfDiamonds.cardID = 14;
		threeOfDiamonds.cardName = "3 of diamonds";
		threeOfDiamonds.pointValue = 3;
		threeOfDiamonds.suitValue = 1;

		Card fourOfDiamonds = new Card();
		fourOfDiamonds.cardID = 15;
		fourOfDiamonds.cardName = "4 of diamonds";
		fourOfDiamonds.pointValue = 4;
		fourOfDiamonds.suitValue = 1;
		
		Card fiveOfDiamonds = new Card();
		fiveOfDiamonds.cardID = 16;
		fiveOfDiamonds.cardName = "5 of diamonds";
		fiveOfDiamonds.pointValue = 5;
		fiveOfDiamonds.suitValue = 1;
	
		Card sixOfDiamonds = new Card();
		sixOfDiamonds.cardID = 17;
		sixOfDiamonds.cardName = "6 of diamonds";
		sixOfDiamonds.pointValue = 6;
		sixOfDiamonds.suitValue = 1;
		
		Card sevenOfDiamonds = new Card();
		sevenOfDiamonds.cardID = 18;
		sevenOfDiamonds.cardName = "7 of diamonds";
		sevenOfDiamonds.pointValue = 7;
		sevenOfDiamonds.suitValue = 1;
		
		Card eightOfDiamonds = new Card();
		eightOfDiamonds.cardID = 19;
		eightOfDiamonds.cardName = "8 of diamonds";
		eightOfDiamonds.pointValue = 8;
		eightOfDiamonds.suitValue = 1;
		
		Card nineOfDiamonds = new Card();
		nineOfDiamonds.cardID = 20;
		nineOfDiamonds.cardName = "9 of diamonds";
		nineOfDiamonds.pointValue = 9;
		nineOfDiamonds.suitValue = 1;
		
		Card tenOfDiamonds = new Card();
		tenOfDiamonds.cardID = 21;
		tenOfDiamonds.cardName = "10 of diamonds";
		tenOfDiamonds.pointValue = 10;
		tenOfDiamonds.suitValue = 1;
		
		Card jackOfDiamonds = new Card();
		jackOfDiamonds.cardID = 22;
		jackOfDiamonds.cardName = "Jack of diamonds";
		jackOfDiamonds.pointValue = 11;
		jackOfDiamonds.suitValue = 1;
		
		Card queenOfDiamonds = new Card();
		queenOfDiamonds.cardID = 23;
		queenOfDiamonds.cardName = "Queen of diamonds";
		queenOfDiamonds.pointValue = 12;
		queenOfDiamonds.suitValue = 1;
		
		Card kingOfDiamonds = new Card();
		kingOfDiamonds.cardID = 24;
		kingOfDiamonds.cardName = "King of diamonds";
		kingOfDiamonds.pointValue = 13;
		kingOfDiamonds.suitValue = 1;
		
		Card aceOfDiamonds = new Card();
		aceOfDiamonds.cardID = 25;
		aceOfDiamonds.cardName = "Ace of diamonds";
		aceOfDiamonds.pointValue = 14;
		aceOfDiamonds.suitValue = 1;
		
		
		//hearts

		Card twoOfHearts = new Card();
		twoOfHearts.cardID = 26;
		twoOfHearts.cardName = "2 of hearts";
		twoOfHearts.pointValue = 2;
		twoOfHearts.suitValue = 2;
		
		Card threeOfHearts = new Card();
		threeOfHearts.cardID = 27;
		threeOfHearts.cardName = "3 of hearts";
		threeOfHearts.pointValue = 3;
		threeOfHearts.suitValue = 2;

		Card fourOfHearts = new Card();
		fourOfHearts.cardID = 28;
		fourOfHearts.cardName = "4 of hearts";
		fourOfHearts.pointValue = 4;
		fourOfHearts.suitValue = 2;
		
		Card fiveOfHearts = new Card();
		fiveOfHearts.cardID = 29;
		fiveOfHearts.cardName = "5 of hearts";
		fiveOfHearts.pointValue = 5;
		fiveOfHearts.suitValue = 2;
	
		Card sixOfHearts = new Card();
		sixOfHearts.cardID = 30;
		sixOfHearts.cardName = "6 of hearts";
		sixOfHearts.pointValue = 6;
		sixOfHearts.suitValue = 2;
		
		Card sevenOfHearts = new Card();
		sevenOfHearts.cardID = 31;
		sevenOfHearts.cardName = "7 of hearts";
		sevenOfHearts.pointValue = 7;
		sevenOfHearts.suitValue = 2;
		
		Card eightOfHearts = new Card();
		eightOfHearts.cardID = 32;
		eightOfHearts.cardName = "8 of hearts";
		eightOfHearts.pointValue = 8;
		eightOfHearts.suitValue = 2;
		
		Card nineOfHearts = new Card();
		nineOfHearts.cardID = 33;
		nineOfHearts.cardName = "9 of hearts";
		nineOfHearts.pointValue = 9;
		nineOfHearts.suitValue = 2;
		
		Card tenOfHearts = new Card();
		tenOfHearts.cardID = 34;
		tenOfHearts.cardName = "10 of hearts";
		tenOfHearts.pointValue = 10;
		tenOfHearts.suitValue = 2;
		
		Card jackOfHearts = new Card();
		jackOfHearts.cardID = 35;
		jackOfHearts.cardName = "Jack of hearts";
		jackOfHearts.pointValue = 11;
		jackOfHearts.suitValue = 2;
		
		Card queenOfHearts = new Card();
		queenOfHearts.cardID = 36;
		queenOfHearts.cardName = "Queen of hearts";
		queenOfHearts.pointValue = 12;
		queenOfHearts.suitValue = 2;
		
		Card kingOfHearts = new Card();
		kingOfHearts.cardID = 37;
		kingOfHearts.cardName = "King of hearts";
		kingOfHearts.pointValue = 13;
		kingOfHearts.suitValue = 2;
		
		Card aceOfHearts = new Card();
		aceOfHearts.cardID = 38;
		aceOfHearts.cardName = "Ace of hearts";
		aceOfHearts.pointValue = 14;
		aceOfHearts.suitValue = 2;
		
		
		//spades

		Card twoOfSpades = new Card();
		twoOfSpades.cardID = 39;
		twoOfSpades.cardName = "2 of spades";
		twoOfSpades.pointValue = 2;
		twoOfSpades.suitValue = 3;
		
		Card threeOfSpades = new Card();
		threeOfSpades.cardID = 40;
		threeOfSpades.cardName = "3 of spades";
		threeOfSpades.pointValue = 3;
		threeOfSpades.suitValue = 3;

		Card fourOfSpades = new Card();
		fourOfSpades.cardID = 41;
		fourOfSpades.cardName = "4 of spades";
		fourOfSpades.pointValue = 4;
		fourOfSpades.suitValue = 3;
		
		Card fiveOfSpades = new Card();
		fiveOfSpades.cardID = 42;
		fiveOfSpades.cardName = "5 of spades";
		fiveOfSpades.pointValue = 5;
		fiveOfSpades.suitValue = 3;
	
		Card sixOfSpades = new Card();
		sixOfSpades.cardID = 43;
		sixOfSpades.cardName = "6 of spades";
		sixOfSpades.pointValue = 6;
		sixOfSpades.suitValue = 3;
		
		Card sevenOfSpades = new Card();
		sevenOfSpades.cardID = 44;
		sevenOfSpades.cardName = "7 of spades";
		sevenOfSpades.pointValue = 7;
		sevenOfSpades.suitValue = 3;
		
		Card eightOfSpades = new Card();
		eightOfSpades.cardID = 45;
		eightOfSpades.cardName = "8 of spades";
		eightOfSpades.pointValue = 8;
		eightOfSpades.suitValue = 3;
		
		Card nineOfSpades = new Card();
		nineOfSpades.cardID = 46;
		nineOfSpades.cardName = "9 of spades";
		nineOfSpades.pointValue = 9;
		nineOfSpades.suitValue = 3;
		
		Card tenOfSpades = new Card();
		tenOfSpades.cardID = 47;
		tenOfSpades.cardName = "10 of spades";
		tenOfSpades.pointValue = 10;
		tenOfSpades.suitValue = 3;
		
		Card jackOfSpades = new Card();
		jackOfSpades.cardID = 48;
		jackOfSpades.cardName = "Jack of spades";
		jackOfSpades.pointValue = 11;
		jackOfSpades.suitValue = 3;
		
		Card queenOfSpades = new Card();
		queenOfSpades.cardID = 49;
		queenOfSpades.cardName = "Queen of spades";
		queenOfSpades.pointValue = 12;
		queenOfSpades.suitValue = 3;
		
		Card kingOfSpades = new Card();
		kingOfSpades.cardID = 50;
		kingOfSpades.cardName = "King of spades";
		kingOfSpades.pointValue = 13;
		kingOfSpades.suitValue = 3;
		
		Card aceOfSpades = new Card();
		aceOfSpades.cardID = 51;
		aceOfSpades.cardName = "Ace of spades";
		aceOfSpades.pointValue = 14;
		aceOfSpades.suitValue = 3;		
		
		
		// create an array (deck) out of the above cards and return
		
		Card[] orderedDeck = { twoOfClubs, threeOfClubs, fourOfClubs, fiveOfClubs, sixOfClubs, 
				sevenOfClubs, eightOfClubs, nineOfClubs, tenOfClubs, jackOfClubs, 
				queenOfClubs, kingOfClubs, aceOfClubs, twoOfDiamonds, threeOfDiamonds, 
				fourOfDiamonds, fiveOfDiamonds, sixOfDiamonds, sevenOfDiamonds, eightOfDiamonds, 
				nineOfDiamonds, tenOfDiamonds, jackOfDiamonds, queenOfDiamonds, kingOfDiamonds, 
				aceOfDiamonds, twoOfHearts, threeOfHearts, fourOfHearts, fiveOfHearts, sixOfHearts, 
				sevenOfHearts, eightOfHearts, nineOfHearts, tenOfHearts, jackOfHearts, queenOfHearts, 
				kingOfHearts, aceOfHearts, twoOfSpades, threeOfSpades, fourOfSpades, fiveOfSpades, 
				sixOfSpades, sevenOfSpades, eightOfSpades, nineOfSpades, tenOfSpades, jackOfSpades, 
				queenOfSpades, kingOfSpades, aceOfSpades };
		
		return orderedDeck;
	}
}
