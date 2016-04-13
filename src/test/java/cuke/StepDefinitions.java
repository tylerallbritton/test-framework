package cuke;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StepDefinitions {
	private Math math;
	
	@Given("^I provide a base value (\\d+)$")
	public void i_provide_a_base_value(int base) throws Throwable {
		math = new Math(base);
	}
	
	@When("^I provide a multiplier of (\\d+)$")
	public void i_provide_a_multiplier_of(int multi) throws Throwable {
		math.applyCalc(multi);
	}
	
	@Then("^I should see a result of (\\d+)$")
	public void i_should_see_a_result_of(int expectedResult) throws Throwable {
		int actualResult = math.getCalc();
		assertThat(actualResult,is(expectedResult));
	}
}
