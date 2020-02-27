import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixTest {
	
	int[][] matrix = {
				{845, 974, 680, 843, 587}, 
				{232, 206, 87,  176, 299},
				{831, 653, 460, 346, 57 },
				{211, 227, 7,   972, 22 },
				{906, 606, 719, 727, 849}
			 };
	
	int[][] matrixTest = new int[matrix.length][matrix[0].length];

	@Test
	void testFillArray() {
		MatrixStuff.fillArray(matrixTest);
		for(int i = 0; i < matrixTest.length; ++i)
			for(int j = 0; j < matrixTest[0].length; ++j)
				assertEquals(matrixTest[i][j], matrix[i][j]);
		
		assertFalse(matrix == matrixTest);
	}
	
	@Test
	void testFindMax() {
		int max = MatrixStuff.findMax(matrix);
		assertEquals(max, 974);
	}

	@Test
	void testFindMin() {
		int min = MatrixStuff.findMin(matrix);
		assertEquals(min, 7);
	}

	@Test
	void testFindMaxOfRow() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testFindMinOfRow() {
		fail("Not yet implemented"); // TODO
	}

}
