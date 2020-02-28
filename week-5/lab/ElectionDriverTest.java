import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElectionDriverTest {

	/* Alright there's some weirdness in here -- we could not get
	 * any of the before or after test specifications to work properly
	 * with fillList() -- we had to do it in each test case. Because of
	 * this, we needed a way to clear the arraylist between runs or
	 * else you'd end up with duplicate data.
	 */
	
	
	@Test
	void testFindLargestMargin() {
		ElectionDriver.fillList();
		
		double expected = 1273485.0;

		CountyResults2016 county = ElectionDriver.findLargestMargin();
		double countyLargestMargin = county.getDifference();

		assertEquals(expected, countyLargestMargin, "testFindLargestMargin result");
		
		ElectionDriver.clear();
	}

	@Test
	void testFindLargestMarginState() {
		ElectionDriver.fillList();

		double expectedNY = 461433.0;
		CountyResults2016 countyNY = ElectionDriver.findLargestMargin("NY");
		double countyLargestMarginNY = countyNY.getDifference();

		assertEquals(expectedNY, countyLargestMarginNY, "testFindLargestMarginState result");
		
		double expectedTX = 196980.0;
		CountyResults2016 countyTX = ElectionDriver.findLargestMargin("TX");
		double countyLargestMarginTX = countyTX.getDifference();

		assertEquals(expectedTX, countyLargestMarginTX, "testFindLargestMarginState result");
		
		double expectedCA = 1273485.0;
		CountyResults2016 countyCA = ElectionDriver.findLargestMargin("CA");
		double countyLargestMarginCA = countyCA.getDifference();

		assertEquals(expectedCA, countyLargestMarginCA, "testFindLargestMarginState result");
		
		
		ElectionDriver.clear();
	}

	@Test
	void getStateTotals() {
		ElectionDriver.fillList();

		String[] totals = ElectionDriver.getStateTotals();

		System.out.println(totals[0]);
		assertTrue(totals[0].contains("Dem votes: 2697087"), "getStateTotals result");
		assertTrue(totals[1].contains("GOP votes: 1306925"), "getStateTotals result");
		assertTrue(totals[2].contains("Margin of victory: 379649"), "getStateTotals result");
		
		ElectionDriver.clear();
	}

}
