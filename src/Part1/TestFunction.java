package Part1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;

public class TestFunction {

	
	// Bai 8
    private static int nbTC = 0;

    private static Triangle t;
    private static Circle c;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before All");

        t = new Triangle("Triangle");
        c = new Circle("Circle");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before TC: " + ++nbTC);
    }

    @Test
    void test() {

        t.setBase(10);
        t.setHeight(5);

        c.setRadius(5);

        System.out.println(
                "The area of " + t.getName() + " : " + t.getArea()
        );

        System.out.println(
                "The area of " + c.getName() + " : " + c.getArea()
        );

        assertEquals(25.0f, t.getArea());

        assertEquals(78.53982f, c.getArea(), 0.00001f);
    }

    @RepeatedTest(2)
    void repeatedTest() {

        t.setBase(2);
        t.setHeight(1);

        c.setRadius(5);

        System.out.println(
                "The area of " + t.getName() + " : " + t.getArea()
        );

        System.out.println(
                "The area of " + c.getName() + " : " + c.getArea()
        );

        assertEquals(1.0f, t.getArea());

        assertEquals(78.53982f, c.getArea(), 0.00001f);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 10, 10",
        "100, 2, 100"
    })
    void testWithCSVSource(float base, float height, float area) {

        t.setBase(base);
        t.setHeight(height);

        System.out.println(t.getArea());

        assertEquals(area, t.getArea());
    }

    @ParameterizedTest
    @CsvFileSource(
        files = "src/Part1/Hinhhoc.csv",
        numLinesToSkip = 1
    )
    void testWithCSVFile(float base, float height, float area) {

        t.setBase(base);
        t.setHeight(height);

        System.out.println(t.getArea());

        assertEquals(area, t.getArea());
    }

    @ParameterizedTest
    @MethodSource("baseHeightAreaProvider")
    void testWithMethodSource(float base, float height, float area) {

        t.setBase(base);
        t.setHeight(height);

        System.out.println(t.getArea());

        assertEquals(area, t.getArea());
    }

    static Stream<Arguments> baseHeightAreaProvider() {

        return Stream.of(
            Arguments.arguments(10000, 2, 10000),
            Arguments.arguments(9999999, 2, 9999999)
        );
    }

    @AfterAll
    public static void afterClass() {

        System.out.println("Total of TCs: " + nbTC);
        System.out.println("After All");
    }

    @AfterEach
    public void after() {

        System.out.println("After TC: " + nbTC);
    }
	
}
