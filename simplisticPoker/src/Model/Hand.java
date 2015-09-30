package Model;

public class Hand {
    private Card [] hand;
    private int rank;

    /**
     * Description: Creates a PokerHand object with the 5 cards
     *   passed in as parameters.  It uses the evalRank() method
     *   to give assign a rank to the hand.
     */
    public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
	hand = new Card[5];
	hand[0] = c1;
	hand[1] = c2;
	hand[2] = c3;
	hand[3] = c4;
	hand[4] = c5;
	evalRank();
    }

    public Hand() {
	this(new Card(), new Card(), new Card(), new Card(), new Card());
    }

    //an integer representing the rank of the card    
    public int getRank() {
	return rank;
    }

    //method used to determine whether the hand has an ace
    public boolean hasAce() {
	for(int i = 0; i < 5; i++)
	    if(hand[i].getRank() == 14)
		return true;
	return false;
    }

    /**
       prints out the hand numbered without printing
     *   out the rank.
     */
    public String gameToString() {
	String result = new String("");
	for(int i = 0; i < hand.length; i++)
	    result += "(" + (i+1) + ") " + hand[i] + "\n";
	return result;
    }

    /**
     for printing out the rank.
     */
    public static String rankToString(int rank) {
	switch(rank) {
	case 0: return "Nothing";
	case 1: return "Pair";
	case 2: return "Two Pair";
	case 3: return "3 of a Kind";
	case 4: return "Straight";
	case 5: return "Flush";
	case 6: return "Full House";
	case 7: return "4 of a Kind";
	case 8: return "Straight Flush";
	case 9: return "Royal Flush";
	default: return "Error";

	}
    }

    /**
	a boolean which is true if the hand
     *   is a pair of Jacks or better
     */
    public boolean hasGoodPair() {
	boolean result;
	result = false;
	if(rank == 1) {
	    for(int i = 0; i < 5; i++) {
		for(int j = i+1; j < 5; j++) 
		if(hand[i].getRank() == hand[j].getRank() && hand[i].getRank() > 10)
		    result = true;
	    }
	}
	return result;
    }

    /**
	A method that returns the String representation
     *   of this card hand - including the rank.
     */
    public String toString() {
	evalRank();
	String result = "";
	switch(rank) {
	case 0:
	    result += "Nothing";
	    break;
	case 1:
	    result += "Pair";
	    break;
	case 2:
	    result += "Two Pair";
	    break;
	case 3:
	    result += "Three of a Kind";
	    break;
	case 4:
	    result += "Straight";
	    break;
	case 5:
	    result += "Flush";
	    break;
	case 6:
	    result += "Full House";
	    break;
	case 7:
	    result += "Four of a Kind";
	    break;
	case 8:
	    result += "Straight Flush";
	    break;
	case 9:
	    result += "Royal Flush";
	    break;
	default:
	    result += "Nothing";
	    break;
	}
	result += ": " + hand[0] + ", " + hand[1] + ", " + hand[2] + ", " + hand[3] + ", " + hand[4] +"\n";
	return result;
    }

    
    /**

     computes the rank of the hand.
     ** all in one function to avoid code redundancy
     */
    private void evalRank() {
	Card [] sortedHand = new Card[5];
	for(int i = 0; i < 5; i++)
	    sortedHand[i] = hand[i];

	this.sort(sortedHand);
	int pairIndex = -1;

	rank = 0;  //assume its a BUST
	
	//check for pair
	for(int i = 0; i < 4; i++)
	    if(sortedHand[i].getRank() == sortedHand[i+1].getRank()) {
		pairIndex = i;
		rank = 1;
		i = 4;
	    }

	//check for 2 pair
	if(rank == 1) {
	    for(int i = pairIndex + 2; i < 4; i++)
		if(sortedHand[i].getRank() == sortedHand[i+1].getRank())
		    rank = 2;
	}

	//check for 3 of a kind or full house
	for(int i = 0; i < 3; i++)
	    if(sortedHand[i].getRank() == sortedHand[i+1].getRank() && sortedHand[i+1].getRank() == sortedHand[i+2].getRank()) {
		rank = 3;
		if(i==0 && sortedHand[3].getRank()==sortedHand[4].getRank() || i==2 && sortedHand[0].getRank() == sortedHand[1].getRank())
		    rank = 6;
	    }
	
	//check for 4 of a kind
	for(int i = 0; i < 2; i++)
	    if(sortedHand[i].getRank() == sortedHand[i+1].getRank() && sortedHand[i+1].getRank() == sortedHand[i+2].getRank() &&
	       sortedHand[i+2].getRank() == sortedHand[i+3].getRank()) {
		rank = 7;
	    }

	//check for straight (if we haven't already found any pairs)
	if(rank == 0) 
	    if((sortedHand[4].getRank() - sortedHand[0].getRank() == 4) ||
	       (sortedHand[3].getRank() - sortedHand[0].getRank() == 3 && sortedHand[4].getRank() == 14 && sortedHand[0].getRank() == 2)) {
		rank = 4;
	    }

	//check for flush (if we haven't already found any pairs)
	boolean flush;
	if(rank == 0 || rank == 4) {
	    flush = true;
	    for(int i = 0; i < 4; i++)
		if(sortedHand[i].getSuit() != sortedHand[i+1].getSuit())
		    flush = false;
	    if(flush && rank == 4)
		rank = 8; //straight flush!
	    else if(flush)
		rank = 5;
	}
	    
	//check for royal flush (if it's a straight flush)
	if(rank == 8 && sortedHand[4].getRank() == 14 && sortedHand[0].getRank() == 10)
	    rank = 9; //royal flush!
    }//end evalRank

    /**
   Sorts an array of cards using a selection sort
     *   algorithm.  Used by the evalRank() method.
     */
    private void sort(Card [] a) {
	Card temp;
	int minIndex;
	for(int i = 0; i < a.length; i++) {
	    minIndex = i;
	    for(int j = i; j < a.length; j++) {

		if(a[minIndex].isHigher(a[j]))
		    minIndex = j;
	    }
	    //swap the elements at i and j
	    temp = a[minIndex];
	    a[minIndex] = a[i];
	    a[i] = temp;
	}
    }
}