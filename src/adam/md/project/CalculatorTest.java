package adam.md.project;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Inherited;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calcWorkingWithAddAndMultiply() throws Exception {
        List<String> input = Arrays.asList("add 2", "multiply 3", "apply 3");
        Calculator calculator = new Calculator();
        String result = calculator.processApplyBlock(input);
        assertEquals(result, "15");
    }
    @Test
    void calcWorkingWithAddAndMultiply2() throws Exception {
        List<String> input = Arrays.asList("multiply 9", "apply 5");
        Calculator calculator = new Calculator();
        String result = calculator.processApplyBlock(input);
        assertEquals(result, "45");
    }
    @Test
    void throwErrorWithMoreThan2InstructionsPerLine() {
        List<String> input = Arrays.asList("multiply 9 add 5", "apply 5");
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(Exception.class, () -> calculator.processApplyBlock(input));

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void throwErrorWithInvalidOperation() {
        List<String> input = Arrays.asList("sqaureroot 9 add 5", "apply 5");
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(Exception.class, () -> calculator.processApplyBlock(input));

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}