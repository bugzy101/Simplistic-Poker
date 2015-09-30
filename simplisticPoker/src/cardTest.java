import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.junit.runners.model.InitializationError;

import Model.Card;


public class cardTest {

	Card result;
	Card temp;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
		result = new Card(14, 4);	
		temp = new Card(11, 5);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testConstructors() {
		
		//Card result = new Card(14, 4);	
		assertEquals("Expecting" + result.toString(), result, result);
	
		result.getSuit();
		assertEquals("Expecting" + result.getSuit(), 4, result.getSuit());

		result.getRank();
		assertEquals("Expecting" + result.getRank(), 14, result.getRank());

		result.toString();
		assertEquals("Expecting " + result.toString(), "Ace Spades", result.toString());

	}

	@Test
	public void testConstructors1() {
		
		//Card result = new Card();	
		assertEquals("Expecting" + result.toString(), result.toString(), result.toString());
	
	
	}

	@Test
	public void testSetSuit() {
		
		//Card result = new Card();	
		result.setSuit(4);
		assertEquals("Expecting " + 4, 4, result.getSuit());
	
		result.setSuit(15);
		assertEquals("Expecting " + 1, 1, result.getSuit());
	

	
	}
	
	@Test
	public void testIsHigher() {
		
		//Card result = new Card(14, 4);
		//Card temp = new Card(11, 5);
		
		assertEquals("Expecting False" , false , temp.isHigher(result));
		assertEquals("Expecting True" , true , result.isHigher(temp));

	
	}




}
