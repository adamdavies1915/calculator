package adam.md.project;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void calcWorkingWithAddAndMultiply() {
        List<String> input = Arrays.asList("add 2", "multiply 3", "apply 3");
        Calculator calculator = new Calculator();
        String result = calculator.processApplyBlock(input);
        assertEquals(result, "15");
    }
    @Test
    void calcWorkingWithAddAndMultiply2() {
        List<String> input = Arrays.asList("multiply 9", "apply 5");
        Calculator calculator = new Calculator();
        String result = calculator.processApplyBlock(input);
        assertEquals(result, "45");
    }
}