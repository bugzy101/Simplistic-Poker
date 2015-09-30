package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Model.Card;
import Model.Deck;
import Model.Hand;
import Model.Player;

public class Poker {

	private int minPlayers;
	private int maxPlayers;
	private static Player players[];
    private Deck deck;
    Hand hand;
    private static int numOfPlayers = 0;
    //constructor initializes the deck and cards
    public Poker() {
    	
   // player = new Player(1);
    deck = new Deck();
    hand = new Hand();
    deck.shuffle();
    System.out.println( "The shuffled deck : " + deck.toString());
    }
    //deals the card to each player
    public void dealCards() {
        
    	int count = 0;
    	players = new Player[numOfPlayers];
    	for(int i = 0; i < numOfPlayers; i++)
    		players[i] = new Player(i);
        deck.shuffle();

    	
    	Card playerHand[] = new Card[players[0].MAX_CARD];
    	Card playerHand2[] = new Card[players[0].MAX_CARD];
    	Card playerHand3[] = new Card[players[0].MAX_CARD];
    	Card playerHand4[] = new Card[players[0].MAX_CARD];
	
        
        	for(int j = 0; j < 5; j++){

    	playerHand[j] = deck.deal();  //deal 5 cards
    	playerHand2[j] = deck.deal();
    	playerHand3[j] = deck.deal();
    	playerHand4[j] = deck.deal();
    	    	
    	if(numOfPlayers == 2){
        	players[0].setCards(playerHand);
        	players[1].setCards(playerHand2);

    	}else if(numOfPlayers == 3){
    		players[0].setCards(playerHand);
        	players[1].setCards(playerHand2);
        	players[2].setCards(playerHand3);
    	}else if(numOfPlayers == 4){
    		players[0].setCards(playerHand);
        	players[1].setCards(playerHand2);
        	players[2].setCards(playerHand3);
        	players[3].setCards(playerHand4);

    	}
    	
    	
        	}
    	}
    
    //simulates the game and shows the result
    public static void showCards() {
    	for (int i = 0; i < players.length; i++) {
    		System.out.println("\nPlayer " + players[i].getId() + ": ");

        	Hand hand = new Hand(players[i].getCards()[0],players[i].getCards()[1],players[i].getCards()[2],players[i].getCards()[3],players[i].getCards()[4]);
        	System.out.println(hand.toString());

    	}
    	

    }
    
    public static void checkWinner(){
    	
    	
    	if(numOfPlayers == 2){
    		Hand hand1 = new Hand(players[0].getCards()[0],players[0].getCards()[1],players[0].getCards()[2],players[0].getCards()[3],players[0].getCards()[4]);
    		Hand hand2 = new Hand(players[1].getCards()[0],players[1].getCards()[1],players[1].getCards()[2],players[1].getCards()[3],players[1].getCards()[4]);
    			if(hand1.getRank() > hand2.getRank())
    				System.out.println("\n Player Id " + players[0].getId() + " Wins!" );
    			else if(hand1.getRank() == hand2.getRank())
    				System.out.println("\n Nobody wins. Draw!" );
    			else
    			System.out.println("\n Player Id " + players[1].getId() + " Wins!" );

    	}else if (numOfPlayers == 3){
    		
    		Hand hand1 = new Hand(players[0].getCards()[0],players[0].getCards()[1],players[0].getCards()[2],players[0].getCards()[3],players[0].getCards()[4]);
    		Hand hand2 = new Hand(players[1].getCards()[0],players[1].getCards()[1],players[1].getCards()[2],players[1].getCards()[3],players[1].getCards()[4]);
    		Hand hand3 = new Hand(players[2].getCards()[0],players[2].getCards()[1],players[2].getCards()[2],players[2].getCards()[3],players[2].getCards()[4]);

    		if(hand1.getRank() > hand2.getRank() && hand1.getRank() > hand3.getRank())
				System.out.println("\n Player Id " + players[0].getId() + " Wins!" );
			else if(hand2.getRank() > hand1.getRank() && hand2.getRank() > hand3.getRank())
				System.out.println("\n Player Id " + players[1].getId() + " Wins!" );
			else if(hand3.getRank() > hand1.getRank() && hand3.getRank() > hand2.getRank())
				System.out.println("\n Player Id " + players[2].getId() + " Wins!" );	
			else if(hand1.getRank() == hand2.getRank() && hand2.getRank() > hand3.getRank())
			System.out.println("\n Player ID " + players[2].getId() + " Loose!");
    		
			else
				System.out.println("\n Nobody wins");
    		
    		}else if(numOfPlayers == 4){
    			
    			Hand hand1 = new Hand(players[0].getCards()[0],players[0].getCards()[1],players[0].getCards()[2],players[0].getCards()[3],players[0].getCards()[4]);
        		Hand hand2 = new Hand(players[1].getCards()[0],players[1].getCards()[1],players[1].getCards()[2],players[1].getCards()[3],players[1].getCards()[4]);
        		Hand hand3 = new Hand(players[2].getCards()[0],players[2].getCards()[1],players[2].getCards()[2],players[2].getCards()[3],players[2].getCards()[4]);
        		Hand hand4 = new Hand(players[3].getCards()[0],players[3].getCards()[1],players[3].getCards()[2],players[3].getCards()[3],players[3].getCards()[4]);

        		if(hand1.getRank() > hand2.getRank() && hand1.getRank() > hand3.getRank() && hand1.getRank() > hand4.getRank())
    				System.out.println("\n Player Id " + players[0].getId() + " Wins!" );
    			else if(hand2.getRank() > hand1.getRank() && hand2.getRank() > hand3.getRank() && hand2.getRank() > hand4.getRank())
    				System.out.println("\n Player Id " + players[1].getId() + " Wins!" );
    			else if(hand3.getRank() > hand1.getRank() && hand3.getRank() > hand2.getRank() && hand3.getRank() > hand4.getRank())
    				System.out.println("\n Player Id " + players[2].getId() + " Wins!" );
    			else if(hand4.getRank() > hand1.getRank() && hand4.getRank() > hand2.getRank() && hand4.getRank() > hand3.getRank())
    				System.out.println("\n Player Id " + players[3].getId() + " Wins!" );
        		
    			else if(hand1.getRank() == hand2.getRank() && hand2.getRank() > hand3.getRank() && hand3.getRank() > hand4.getRank())
    			System.out.println("\n Player ID " + players[3].getId() + " Loose!");
        		
    			else
    				System.out.println("\n Nobody wins");
    		
    		
    		
    		}
    	
    	
    
    }
    	 	
    
    public static void promptPlayers(){
    	
    	System.out.println("Please enter the number of players");
    	String input = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            numOfPlayers = Integer.parseInt(input);
            if(numOfPlayers < 2 || numOfPlayers > 4){
            	
            	System.out.println("Must be minimum of 2 players and Maximum of 4 players");
            	numOfPlayers = 0;
            	promptPlayers();
            }

        } catch (NumberFormatException ex) {
           System.out.println("Input must be a whole number!");
           promptPlayers();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }    	
    

public static void main(String[] args){
	
	//System.out.println("")
	promptPlayers();
	Poker poker = new Poker();
	poker.dealCards();
	showCards();
	checkWinner();
	
}

}
