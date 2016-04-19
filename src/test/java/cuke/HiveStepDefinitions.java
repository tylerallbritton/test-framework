package cuke;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.ResultSet;

public class HiveStepDefinitions {
	private Hive hive;
		
	@Given("^I can connect to Hive$")
	public void i_can_connect_to_hive() throws Throwable {
		hive = new Hive();
	}
	
	@When("^I request a list of tables$")
	public void i_request_a_list_of_tables() throws Throwable {
		hive.executeSQL("show tables");
	}
	
	@Then("^I get a list of (\\d+) tables$")
	public void i_get_a_list_of_tables(int expectedCount) throws Throwable {
		int actualResult = hive.RowCount();
		assertThat(actualResult,is(expectedCount));
	}
}
