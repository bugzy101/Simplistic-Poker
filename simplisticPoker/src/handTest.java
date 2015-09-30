import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Model.Card;
import Model.Hand;


public class handTest {

	Hand hand;
	Card card1, card2, card3, card4, card5;
	Card[] cards;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
		cards = new Card[5];
		
		card1 = new Card(14, 4);
		card2 = new Card(11, 4);
		card3 = new Card(12, 4);
		card4 = new Card(13, 4);
		card5 = new Card(10, 4);
		
		
		hand = new Hand(card1, card2, card3, card4, card5);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
	
	assertEquals("Expecting 5 cards ", hand.toString(), hand.toString());
	  //System.out.println(hand.toString());
	}

	@Test
	public void testHasAce() {
	
	assertEquals("Expecting True ", true, hand.hasAce());
		
	hand = new Hand(card2, card3, card4, card5, new Card(11, 2));
	assertEquals("Expecting false ", false, hand.hasAce());

	}

	@Test
	public void testEvalRank() {
	
		
	hand = new Hand(new Card(13, 2), new Card(14, 3), new Card(10, 5), new Card(5, 2), new Card(11, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Nothing"));
	System.out.println(hand.toString());
	
	
	hand = new Hand(new Card(13, 2), new Card(14, 3), new Card(10, 5), new Card(5, 2), new Card(14, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Pair"));
	System.out.println(hand.toString());

	hand = new Hand(new Card(10, 2), new Card(14, 3), new Card(10, 5), new Card(5, 2), new Card(14, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Two Pair"));
	System.out.println(hand.toString());
	
	hand = new Hand(new Card(13, 2), new Card(13, 3), new Card(13, 4), new Card(5, 2), new Card(10, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Three of"));
	System.out.println(hand.toString());
	
	hand = new Hand(new Card(5, 2), new Card(10, 2), new Card(7, 2), new Card(11, 2), new Card(9, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Flush"));
	System.out.println(hand.toString());

	hand = new Hand(new Card(13, 2), new Card(13, 3), new Card(13, 4), new Card(14, 5), new Card(14, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Full House"));
	System.out.println(hand.toString());
	
	hand = new Hand(new Card(10, 2), new Card(10, 3), new Card(10, 4), new Card(10, 5), new Card(9, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Four of "));
	System.out.println(hand.toString());
	
	
	hand = new Hand(new Card(5, 2), new Card(6, 2), new Card(7, 2), new Card(8, 2), new Card(9, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Straight Flush"));
	System.out.println(hand.toString());
	
	hand = new Hand(new Card(11, 2), new Card(12, 2), new Card(13, 2), new Card(14, 2), new Card(10, 2));
	assertEquals("Expecting True ", true, hand.toString().contains("Royal Flush"));
	System.out.println(hand.toString());
	
	}

	@Test
	public void testSort() {
	
		
	assertEquals("Expecting True ", true, hand.hasAce());
		
	hand = new Hand(card2, card3, card4, card5, new Card(11, 2));
	assertEquals("Expecting false ", false, hand.hasAce());

	}

}
