package cuke;

// cucumber needs
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


// general comparison/testing needs
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

// selenium needs
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkStepDefinitions {
	private final WebDriver driver = new ChromeDriver();
	
	@Given("^I am on the Galvanize Home Page$")
	public void i_am_on_the_Galvanize_Home_Page() throws Throwable {
		driver.get("http://www.galvanize.com");
	}
	
	@When("^I click the \"(.*)\" link$")
	public void i_click_the(String query) throws Throwable {
		WebElement element = driver.findElement(By.linkText(query));
		element.click();
	}
	
	@Then("^The page title should be \"(.*)\"$")
	public void the_page_should_be(final String pTitle) throws Throwable {
		(new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle() != null;				
			}
		});

		assertThat(driver.getTitle(), is(pTitle));
		driver.quit();
	}
}
