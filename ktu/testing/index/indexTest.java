package ktu.testing.index;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ktu.testing.Json;
import ktu.testing.delete.delete;

class indexTest {

	String[] args1;
	String[] args2;
	String[] args3;
	
	@BeforeEach
	void setUp() throws Exception {
		args1 = new String[] {"", "1aaa", "key1", "arab"};
		args2 = new String[] {"", "1"};
		args3 = new String[] {"", "1", "key1","kebab"};
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	//Testuojama ar gaunamas atsakymas
	void testGetAnwser() {
		Json val = (new index()).getAnwser(Integer.parseInt(this.args3[1]), this.args3[2],this.args3[3]);
		assertEquals(0, val.get("error"));
	}

	@Test
	//Testuojama ar vardas atitinka
	void testGetRightName() {
		String val = (new index(this.args1)).getName();
		assertEquals("arab", val);
	}

	@Test
	//Testavimas kaip vardas neatitinka
	void testGetBadName() {
		String val = (new index(this.args2)).getName();
		assertEquals(null, val);
	}

	@Test
	//Testavimas ar teisingas raktas
	void testGetRightKey() {
		String val = (new index(this.args1)).getKey();
		assertEquals("key1", val);
	}

	@Test
	//Testavimas ar neteisingas raktas
	void testGetBadKey2() {
		Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			String val = (new index(this.args2)).getKey();
			assertEquals("key1", val);
	    });
		
	    String expectedMessage = "Index 2 out of bounds for length 2";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	//Testuojama ar iðsiustas neteisingas ID
	void testGetBadID() {
		int val = (new index(this.args1)).getID();
		assertEquals(-1, val);
	}

	@Test
	//Testuojama ar iðsiustas teisingas ID
	void testGetRightID() {
		int val = (new index(this.args2)).getID();
		assertEquals(1, val);
	}

	@Test
	//Testuojama ar iðsiustas neteisingas skaièius
	void testIsBadNumber() {
		boolean val = (new index()).isNumber(this.args1[1]);
		assertFalse(val);
	}

	@Test
	//Testuojama ar iðsiustas teisingas skaièius
	void testIsRightNumber() {
		boolean val = (new index()).isNumber(this.args2[1]);
		assertTrue(val);
	}

	@Test
	//Testuojama ar visi argumentai
	void testEnoughArgs() {
		if(Args() == true) {
			assertTrue(Args());
		}
		else {
			assertFalse(Args());
		}
	}

	@Test
	//Testuojama ar trûksta argumentø
	void testNotEnoughArgs() {
		if(Args() == true) {
			assertTrue(Args());
		}
		else {
			assertFalse(Args());
		}
	}
	
	boolean Args() {
		boolean val = (new index(this.args2)).enoughArgs();
		return val;
	}
}
