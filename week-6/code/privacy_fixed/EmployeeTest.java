import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {
	
	Employee employee;
	Date hired;
	Date terminated;

	@BeforeEach
	void setUp() throws Exception {
		hired 		= new Date(1, 1, 2000);
		terminated 	= new Date(1, 1, 1999);
		
	}

	@Test
	void testEmployeeStringStringStringStringDoubleDateDate() {
		employee 		= new Employee(	"Frank", "Stein", "666-33-1234", 
										"Monster", 12345.67, hired, 
										terminated);
		
		Date hired 		= employee.getHireDate();
		Date terminated = employee.getDateTerminated();
		
		// domain validation
		assertTrue(hired.equals(terminated));
		
		// cloning
		Date privateHired = employee.getHireDate();
		assertFalse(privateHired == hired);
		assertTrue(privateHired.equals(hired));
		
		Date privateTerminated = employee.getDateTerminated();
		assertFalse(privateTerminated == terminated);
		assertTrue(privateTerminated.equals(terminated));
	}
}


