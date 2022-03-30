package internet.Herookapp.stepDefinitions.coom;

import java.util.List;

import org.junit.Assert;

import internet.Herookapp.pom.com.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinition {

	HomePage page = new HomePage();

	@Then("^the sub-header text is \"([^\"]*)\"$")
	public void the_subheader_text_is_something(String expectedText) throws Throwable {

		String actualText = page.getSubheaderText();

		Assert.assertEquals(expectedText, actualText);

	}

	@Then("^a list of the following sub-pages is displayed$")
	public void a_list_of_the_following_subpages_is_displayed(DataTable data) throws Throwable {

		List<String> ExpectedSubPageNames = data.asList();

		List<String> ActualResult = page.getSubPagesNames();

		Assert.assertEquals(ExpectedSubPageNames, ActualResult);

	}

	
	 @When("^I click on the \"([^\"]*)\" link$")
	    public void i_click_on_the_something_link(String pagelink) throws Throwable {
		 
		 page.clickOnPageLink(pagelink);
		 
	    }

	
	
	
}
