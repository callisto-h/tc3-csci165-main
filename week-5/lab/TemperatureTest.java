import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureTest {

	@Test
	void testGetDegreesC() {
		Temperature tester1 = new Temperature(212.0f, Temperature.Scale.F);
		assertEquals(100.0f, tester1.getDegreesC(), "testGetDegreesC Result");

		Temperature tester2 = new Temperature(32.0f, Temperature.Scale.F);
		assertEquals(0.0f, tester2.getDegreesC(), "testGetDegreesC Result");

		Temperature tester3 = new Temperature(-40f, Temperature.Scale.F);
		assertEquals(-40f, tester3.getDegreesC(), "testGetDegreesC Result");
	}

	@Test
	void testGetDegreesF() {
		Temperature tester1 = new Temperature(100.0f, Temperature.Scale.C);
		assertEquals(212.0f, tester1.getDegreesF(), "testGetDegreesC Result");

		Temperature tester2 = new Temperature(0f, Temperature.Scale.C);
		assertEquals(32.0f, tester2.getDegreesF(), "testGetDegreesC Result");

		Temperature tester3 = new Temperature(-40f, Temperature.Scale.C);
		assertEquals(-40f, tester3.getDegreesF(), "testGetDegreesC Result");
	}

	@Test
	void testSetScale() {
		Temperature tester1 = new Temperature(100.0f, Temperature.Scale.C);
		tester1.setScale(Temperature.Scale.F);
		assertTrue(tester1.toString().contains("Fahrenheit"), "testSetScale Result");

		Temperature tester2 = new Temperature(100.0f, Temperature.Scale.F);
		tester2.setScale(Temperature.Scale.C);
		assertTrue(tester2.toString().contains("Celsius"), "testSetScale Result");
	}

	@Test
	void testSetScaleAndTemperature() {
		Temperature tester1 = new Temperature();
		tester1.setScaleAndTemperature(Temperature.Scale.C, 100.0f);
		assertTrue(tester1.toString().contains("Celsius"), "testSetScale Result");
		assertTrue(tester1.toString().contains("100.0"), "testSetScale Result");

		Temperature tester2 = new Temperature();
		tester2.setScaleAndTemperature(Temperature.Scale.F, -40.5f);
		assertTrue(tester2.toString().contains("Fahrenheit"), "testSetScale Result");
		assertTrue(tester2.toString().contains("-40.5"), "testSetScale Result");
	}

	@Test
	void testEqualsTemperature() {
		Temperature tester1 = new Temperature(0.0f, Temperature.Scale.C);
		Temperature tester2 = new Temperature(32.0f, Temperature.Scale.F);
		assertTrue(tester1.equals(tester2), "testEqualsTemperature()");

		Temperature tester3 = new Temperature(100.0f, Temperature.Scale.C);
		Temperature tester4 = new Temperature(212.0f, Temperature.Scale.F);
		assertTrue(tester3.equals(tester4), "testEqualsTemperature()");
	}

	@Test
	void testCompareTo() {
		Temperature tester1 = new Temperature(0.0f, Temperature.Scale.C);
		Temperature tester2 = new Temperature(32.0f, Temperature.Scale.F);
		assertEquals(0, tester1.compareTo(tester2), "testCompareTo()");

		Temperature tester3 = new Temperature(1.0f, Temperature.Scale.C);
		Temperature tester4 = new Temperature(32.0f, Temperature.Scale.F);
		assertEquals(1, tester3.compareTo(tester4), "testCompareTo()");

		Temperature tester5 = new Temperature(0.0f, Temperature.Scale.C);
		Temperature tester6 = new Temperature(33.0f, Temperature.Scale.F);
		assertEquals(-1, tester5.compareTo(tester6), "testCompareTo()");
	}

	@Test
	void testToString() {
		Temperature tester1 = new Temperature(0.0f, Temperature.Scale.C);
		assertEquals("0.0 degrees Celsius", tester1.toString(), "testEqualsTemperature()");

		Temperature tester2 = new Temperature(32.0f, Temperature.Scale.F);
		assertEquals("32.0 degrees Fahrenheit", tester2.toString(), "testEqualsTemperature()");

	}

}
