package ktu.testing.sitemaps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class sitemapsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testCombineAll() {
//		fail("Not yet implemented");
		sitemaps maps = new sitemaps();
		String header = maps.getHeader();
		String middle = maps.generateMiddle(maps.getAllServers());
		String footer = maps.getFooter();
		String val = maps.combineAll(header, middle, footer);
		String test1 = header+"\n"+middle+"\n"+footer;
		String test2 = "bad";
		assertEquals(test1,val);
		assertNotSame(test2,val);
	}

	@Test
	void testGenerateMiddle() {
//		fail("Not yet implemented");
		sitemaps maps = new sitemaps();
		String val = maps.generateMiddle(maps.getAllServers());
		
		assertNotSame("",val);
//		assertEquals("",val);
		
		
		
	}

	@Test
	void testGetHeader() {
//		fail("Not yet implemented");
//		String head = (new ().get)
		
		String val = (new sitemaps().getHeader());
		String test2 = "belekas";
		String test1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\" xmlns:news=\"http://www.google.com/schemas/sitemap-news/0.9\" xmlns:xhtml=\"http://www.w3.org/1999/xhtml\" xmlns:mobile=\"http://www.google.com/schemas/sitemap-mobile/1.0\" xmlns:image=\"http://www.google.com/schemas/sitemap-image/1.1\" xmlns:video=\"http://www.google.com/schemas/sitemap-video/1.1\">";
		assertEquals(test1, val);
//		assertEquals(test2, val);
		assertNotSame(test2,val);
		
	}
	

	@Test
	void testGetAllServers() {
//		fail("Not yet implemented");
		
//		assertEquals(null, (new sitemaps().getAllServers()));
		assertNotSame(null, (new sitemaps().getAllServers()));
	}

	@Test
	void testGetFooter() {
//		fail("Not yet implemented");
		
		String val = (new sitemaps().getFooter());
		String test1 = "</urlset>";
		String test2 = "blogas";
		assertEquals(test1, val);
//		assertEquals(test2, val);
		assertNotSame(test2,val);
		
	}

}
