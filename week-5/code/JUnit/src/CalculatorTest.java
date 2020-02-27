import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	// create object
	Calculator c = new Calculator();
	
	@Test
	void testAdd() {
		int one = 1;
		int two = 2;
		
		int desired_result = 3;
		int real_result = c.add(one, two);
		
		// actually run test
		assertEquals(desired_result, real_result);
		
	}

	@Test
	void testSubtract() {
		int one = 1;
		int two = 2;
		
		int desired_result = -1;
		int real_result = c.subtract(one, two);
		
		// actually run test
		assertEquals(desired_result, real_result);
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}

}
