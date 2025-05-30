package tests.simpleTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkipedTests {

    @Test
    @Disabled
    void someTest() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void someTest1() {
        assertTrue(false);
    }
}
