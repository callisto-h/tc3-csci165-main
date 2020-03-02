import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {
	
	Date d1, d2, d3, d4, d5;

	@BeforeEach
	void setUp() throws Exception {
		d1 = new Date(1,  5, 2020);
		d2 = new Date(1,  4, 2020);
		d3 = new Date(12, 6, 2019);
		d4 = new Date(1,  5, 2020);
		d5 = new Date(10, 6, 2019);
	}

	@Test
	void testCompareTo() {
		// compare equality
		assertEquals(d1.compareTo(d4), 0);
		assertTrue(d1.equals(d4));
		// compare inequality
		assertFalse(d1.compareTo(d2) == 0);
		assertFalse(d1.equals(d2));
		// compare years
		assertTrue(d3.compareTo(d1) < 0);
		assertTrue(d1.compareTo(d3) > 0);
		//compare months
		assertTrue(d5.compareTo(d3) < 0);
		assertTrue(d3.compareTo(d5) > 0);
		// compare days
		assertTrue(d2.compareTo(d1) < 0);
		assertTrue(d1.compareTo(d2) > 0);
	}
	
	@Test
	void testClone() {
		// clone instance
		Date clone = new Date(d1);
		// verify identity
		assertFalse(clone == d1);
		// verify state
		assertTrue(clone.equals(d1));
		assertEquals(clone.compareTo(d1), 0);
	}

}
