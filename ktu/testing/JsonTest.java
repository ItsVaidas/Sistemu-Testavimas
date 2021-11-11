package ktu.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonTest {
	
	Json json;
	
	@BeforeEach
	void setUp() throws Exception {
		json = new Json();
		json.put("TEST", 10);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * Testuojama ar Json klasė teisingai ideda elementus į Map
	 */
	void testPut() {
		json.put("testas", true);
		assertEquals(true, json.get("testas"));
	}

	@Test
	/**
	 * Testuojama ar elementas yra išemamas kai tokio elemento per json nėra
	 */
	void testRemoveWhenKeyDoesntExist() {
		boolean val = json.remove("key");
		assertEquals(false, val);
	}

	@Test
	/**
	 * Testuojama elemento pašalinimas kai elementas egzistuoja
	 */
	void testRemoveWhenKeyExist() {
		boolean val = json.remove("TEST");
		assertEquals(true, val);
	}

	@Test
	/**
	 * Testuojama kaip Json objektas parodomas elutėje
	 */
	void testToString() {
		String val = json.toString();
		assertEquals("{'TEST':10}", val);
	}

	@Test
	/**
	 * Testuojamas elemento paimimas kai raktas egzistuoja
	 */
	void testGetWhenKeyExist() {
		Object val = json.get("TEST");
		assertEquals(10, val);
	}

	@Test
	/**
	 * Testuojamas elemento paimimas kai raktas neegzistuoja
	 */
	void testGetWhenKeyDoesntExist() {
		Object val = json.get("key");
		assertEquals(null, val);
	}

}
