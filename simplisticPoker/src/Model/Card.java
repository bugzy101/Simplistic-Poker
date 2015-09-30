package Model;

import java.util.Random;

public class Card {

	private int suit;
    private int rank;
    private static Random gen = new Random();

        
     //Creates a Card object with a random
     // rank and a random suit
     
    public Card() {
	suit = gen.nextInt(4) + 1;
	rank = gen.nextInt(13) + 2;
    }

    /**
     * Card(int r, int s)
     * Input: int r - an int between 2 and 14 
     *        int s - a suit between 1 and 4 
			Creates a Card object with a rank r
     *  and a suit s
     */
    public Card(int r, int s) {
	if(r > 14 || r < 2)
	    rank = 2;
	else
	    rank = r;
	if(s > 4 || s < 1)
	    suit = 1;
	else
	    suit = s;
    }

     //gets the integer representation of the suit
     
    public int getSuit() {
	return suit;
    }

     // sets the suit to a value if the input is
     //  in the appropriate range; otherwise sets it to 1
    
    public void setSuit(int newSuit) {
	if(newSuit >=1 && newSuit <= 4)
	    suit = newSuit;
	else
	    suit = 1;
    }

    public int getRank() {
	return rank;
    }

    public boolean isHigher(Card c) {
	if(this.getRank() > c.getRank() || (this.getRank() == c.getRank() && this.getSuit() > c.getSuit()))
	    return true;
	else
	    return false;
    }
    
    /** Creates a String representation of the card by checking its rank and then its suit.
     */
    public String toString() {
	String result = "";
	switch(this.getRank()) { 
	case 14: 
	    result += "Ace "; 
	    break;
	case 13: 	
	    result += "King ";
	    break;
	case 12:
	    result += "Queen ";
	    break;
	case 11:
	    result += "Jack ";
	    break;
	case 10:
	    result += "10";
	    break;
	default:
	    result += rank + " ";

	}
	
	//result += " of ";

	switch(this.getSuit()) {
	case 1:
	    result += "Diamonds";
	    break;
	case 2:
	    result += "Heart";
	    break;
	case 3:
	    result += "Clubs";
	    break;
	case 4:
	    result += "Spades";
	    break;
	}
	return result;
    }  

}
