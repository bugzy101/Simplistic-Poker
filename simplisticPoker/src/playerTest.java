import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Model.Card;
import Model.Deck;
import Model.Hand;
import Model.Player;


public class playerTest {

	Player player1;
	Player player2;
	Player player3;
	Player player4;
	Card playerHand[];
	Deck deck;
	Hand hand;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
	player1 = new Player(1);
	player2 = new Player(2);
	player3 = new Player(3);
	player4 = new Player(4);

	playerHand = new Card[player1.MAX_CARD];
	deck = new Deck();
	//playerHand = new Hand();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	

	@Test
	public void testPlayer() {
		
		assertEquals("Expecting player ", player1,  player1);

		
	}

	@Test
	public void testGetId() {
	
		assertEquals("Expecting player ", 1,  player1.getId());
		assertEquals("Expecting player ", 2,  player2.getId());
		assertEquals("Expecting player ", 3,  player3.getId());
		assertEquals("Expecting player ", 4,  player4.getId());
		
	
	}

	@Test
	public void testSetId() {
	
		player1.setId(4);
		player2.setId(3);
		player3.setId(2);
		player4.setId(1);
		
		assertEquals("Expecting 4 ", 4,  player1.getId());
		assertEquals("Expecting 3 ", 3,  player2.getId());
		assertEquals("Expecting 2 ", 2,  player3.getId());
		assertEquals("Expecting 1 ", 1,  player4.getId());
	
	}

	@Test
	public void testGetCards() {
	
        deck.shuffle();

		playerHand[0] = deck.deal();
		playerHand[1] = deck.deal();
		playerHand[2] = deck.deal();
		playerHand[3] = deck.deal();
		playerHand[4] = deck.deal();
		
		player1.setCards(playerHand);
		for(int i =0; i < player1.getCards().length; i++)
		System.out.println(player1.getCards()[i].toString());
	
	}

	@Test
	public void testSetCards() {
	
		playerHand[0] = new Card(14, 4);	
		player1.setCards(playerHand);

		assertEquals("Expecting Ace of Spades ", "Ace Spades",  player1.getCards()[0].toString());

	}

	@Test
	public void testGetName() {
	
		assertEquals("Expecting Null", null,  player1.getName());

	
	}

	@Test
	public void testSetName() {
		
		player1.setName("Henry");
	
		assertEquals("Expecting Henry", "Henry",  player1.getName());

	
	}

	@Test
	public void testGetCardAtIndex() {
		
		playerHand[0] = new Card(14, 4);
		playerHand[1] = new Card(10, 4);
		playerHand[2] = new Card(9, 4);
		playerHand[3] = new Card(5, 4);
		playerHand[4] = new Card(3, 4);


		player1.setCards(playerHand);

		assertEquals("Expecting Ace of Spades ", "Ace Spades",  player1.getCardAtIndex(0).toString());
		assertEquals("Expecting Ace of Spades ", "10Spades",  player1.getCardAtIndex(1).toString());
		assertEquals("Expecting Ace of Spades ", "9 Spades",  player1.getCardAtIndex(2).toString());
		assertEquals("Expecting Ace of Spades ", "5 Spades",  player1.getCardAtIndex(3).toString());
	
	}

}
