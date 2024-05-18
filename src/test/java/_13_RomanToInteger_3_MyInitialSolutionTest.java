import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import competitiveprogramming.leetcode.string.easy._13_RomanToInteger_1_Problem;
import competitiveprogramming.leetcode.string.easy._13_RomanToInteger_3_MyInitialSolution;

public class _13_RomanToInteger_3_MyInitialSolutionTest {

/**
@TestFactory – denotes a method that’s a test factory for dynamic tests
@DisplayName – defines a custom display name for a test class or a test method
@Nested – denotes that the annotated class is a nested, non-static test class
@Tag – declares tags for filtering tests
@ExtendWith – registers custom extensions
@BeforeEach – denotes that the annotated method will be executed before each test method (previously @Before)
@AfterEach – denotes that the annotated method will be executed after each test method (previously @After)
@BeforeAll – denotes that the annotated method will be executed before all test methods in the current class (previously @BeforeClass)
@AfterAll – denotes that the annotated method will be executed after all test methods in the current class (previously @AfterClass)
@Disabled – disables a test class or method (previously @Ignore)
* */
	
    @Test
    public void testRomanToInt() {
    	
    	_13_RomanToInteger_1_Problem solution = new _13_RomanToInteger_3_MyInitialSolution();

//        assertAll("numbers",
//                () -> assertEquals(solution.romanToInt("III"), 3),
//				() -> assertEquals(solution.romanToInt("IV"), 4),
//				() -> assertEquals(solution.romanToInt("V"), 5),
//				() -> assertEquals(solution.romanToInt("VIII"), 8),
//				() -> assertEquals(solution.romanToInt("IX"), 9),
//				() -> assertEquals(solution.romanToInt("XLIX"), 49),
//				() -> assertEquals(solution.romanToInt("L"), 50)
//            );
    	
        assertEquals(3, solution.romanToInt("III"));
        assertEquals(4, solution.romanToInt("IV"));
        assertEquals(5, solution.romanToInt("V"));
        assertEquals(8, solution.romanToInt("VIII"));
        assertEquals(9, solution.romanToInt("IX"));
        assertEquals(49, solution.romanToInt("XLIX"));
        assertEquals(50, solution.romanToInt("L"));
    }
    
    
}

