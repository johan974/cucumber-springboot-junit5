package nl.tester.springboot.cucumbertests.totest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void testBasic() {
        Calculator calculator = new Calculator();
        calculator.push( 4);
        calculator.push(5);
        calculator.push("+");
        assertEquals( 9.0, calculator.value());
    }
}
