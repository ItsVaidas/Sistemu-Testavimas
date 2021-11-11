package ktu.testing.system;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ktu.testing.Json;

class systemTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * Tikrinama ar teisingai gauna aktyvaus serverio žaidėjus
	 */
	void testGetPlayersWhenServerOnline() {
		Json val = (new system()).getPlayers("1", "kaimux.lt", 25565);
		assertNotEquals("Offline", val.get("MOTD"));
	}

	@Test
	/**
	 * Tikrinama ar teisingai išmeta klaidą dėl neaktyvaus serverio
	 */
	void testGetPlayersWhenServerOffline() {
		Json val = (new system()).getPlayers("1", "donotexist", 25565);
		assertEquals("Offline", val.get("MOTD"));
	}

	@Test
	/**
	 * Tikrinama ar serverio susijungimas sėkmingas su aktyviu serveriu
	 */
	void testConnectWithOnlineServer() {
		String[] val = (new system()).connect("kaimux.lt", 25565);
		assertNotEquals("Offline", val[2]);
	}

	@Test
	/**
	 * Tikrinama ar serverio susijungimas sėkmingas su neaktyviu serveriu
	 */
	void testConnectWithOfflineServer() {
		String[] val = (new system()).connect("donotexist", 25565);
		assertEquals("Offline", val[2]);
	}

}
