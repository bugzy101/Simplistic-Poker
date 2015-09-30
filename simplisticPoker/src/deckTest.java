import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Model.Card;
import Model.Deck;


public class deckTest {

	Deck deck;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	
	
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	@Test
	public void testConstructors() {
		
		//Deck deck = new Deck();
		assertEquals("Expecting a deck of 52 cards", deck.toString(), deck.toString());

		assertEquals("Expecting a deck of 52 cards", 52, deck.getDeck().length);

	
	}
		public void testDeal() {
		
		Deck deck = new Deck();
		//deck.deal();
		assertEquals("Expecting 0 ", deck.getTop() , deck.deal());
		//deck.getTop().toString();	
		deck.shuffle();
		assertEquals("Expecting 0 ", deck.deal(), deck.getTop());
		}


}
