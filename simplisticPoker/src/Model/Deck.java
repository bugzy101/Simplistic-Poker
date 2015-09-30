/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Henry
 *
 */
public class Deck {

   private Card [] deck;
   private int top;
   private static Random random = new Random();

	    /**
	     * Creates a deck of 52 playing cards - one
	     *   for each suit/rank combination
	     */
	    public Deck() {
		int count = 0;
		setDeck(new Card[52]);
		for(int i = 2; i <= 14; i++) {
		    for(int j = 1; j <= 4; j++) {
			getDeck()[count] = new Card(i, j);
			count++;
		    }
		}
		top = 0;
	    }//end constructor

	    /**
	     *gets the index which is currently acting as
	     *   the top of the deck.
	     */
	    public int getTop() {
		return top;
	    }//end getTop

	    /**
	   returns the card that is the top of the deck and sets the top
	     *   pointer to the next card in the array.  If the last card in the deck has
	     *   just been dealt, the deck is reshuffled.
	     */
	    public Card deal() {
		Card topCard = getDeck()[top];
		top++;
		if(top == 52)
		    this.shuffle();
		return topCard;
	    }//end deal

	    /**
	     * Description: shuffles the deck using a random permutation algorithm
	     *   that chooses a permutation uniformly at random.
	     */
	    public void shuffle() {
		int swapIndex;
		Card temp;
		for(int i = 0; i < getDeck().length; i++) {
		    swapIndex = random.nextInt(getDeck().length-i) + i;
		    temp = getDeck()[swapIndex];
		    getDeck()[swapIndex] = getDeck()[i];
		    getDeck()[i] = temp;
		}//end shuffle
		top = 0;
	    }

	    /**
	     creates a string representation of the deck
	     *   which includes each card printed out in order
	     */
	    public String toString() {
		String result = "";
		for(int i = 0; i < 52; i++) {
		    result += getDeck()[i] + ", ";
		    if((i+1)%8 == 0 || i == 51)
			result += "\n";
		}
		return result;
	    }//end toString

		public Card [] getDeck() {
			return deck;
		}

		public void setDeck(Card [] deck) {
			this.deck = deck;
		}

}
