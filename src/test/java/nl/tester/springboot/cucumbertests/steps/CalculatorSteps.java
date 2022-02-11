package nl.tester.springboot.cucumbertests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tester.springboot.cucumbertests.totest.Calculator;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

public class CalculatorSteps {

    static final Logger log = getLogger(lookup().lookupClass());

    private Calculator calc;

    @Given("^a calculator I just turned on$")
    public void setup() {
        calc = new Calculator();
        log.info( "Starting the Cucumber tests");
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void add(int arg1, int arg2) {
        log.debug("Adding {} and {}", arg1, arg2);
        calc.push(arg1);
        calc.push(arg2);
        calc.push("+");
    }

    @When("^I substract (\\d+) to (\\d+)$")
    public void substract(int arg1, int arg2) {
        log.debug("Substracting {} and {}", arg1, arg2);
        calc.push(arg1);
        calc.push(arg2);
        calc.push("-");
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected) {
        Number value = calc.value();
        log.debug("Result: {} (expected {})", value, expected);
        assertEquals(expected, value);
    }

}
