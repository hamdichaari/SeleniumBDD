package internet.Herookapp.stepDefinitions.coom;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import internet.Herookapp.com.DriverManager;
import internet.Herookapp.pom.com.BasePage;
import internet.Herookapp.pom.com.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepsDefinition {

	private String page;

	private BasePage getPage() {

//		switch (page) {
//		case "home":
//
//			return new HomePage();
//
//		}
		
		if (page.equals("home")) {
			return new HomePage();
		}

		return null;

	}

	@Before
	public void initRun() {

		BasePage.driver = DriverManager.getDriver();

	}
	
	
	@After 
	
	public void tearDown() {
		
		
		BasePage.driver.close();
	}
	
	

	@Given("^I have navigated to the 'the-internet' \"([^\"]*)\" page$")
	public void i_have_navigated_to_the_theinternet_something_page(String pageName) throws Throwable {

		this.page = pageName;
		String url = BasePage.PAGE_URLS.get(pageName.toLowerCase());

		System.out.println("aaaaaaaaaaaa   "  + url);
		
		Thread.sleep(5000);
		
		BasePage.driver.get(url);
		
		System.out.println("aaaaaaaaaaaa   ");

	}

	@Then("^the page title is \"([^\"]*)\"$")
	public void the_page_title_is_something(String expectedText) throws Throwable {

		String actualResult = getPage().getPageTitleText();

		Assert.assertEquals(expectedText, actualResult);

	}
	
    @Then("^the \"([^\"]*)\" page opens$")
    public void the_something_page_opens(String pageName) throws Throwable {
    	
		String expectedUrl = BasePage.PAGE_URLS.get(pageName.toLowerCase());
		
		
		WebDriverWait wait = new WebDriverWait(BasePage.driver, 15);
		
		wait.until(ExpectedConditions.urlToBe(expectedUrl));
		
		
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkk                "    +expectedUrl);
		
		System.out.println("jjjjjjjjjjjjjjjjjjjj          "   +BasePage.driver.getCurrentUrl());
		
		Assert.assertEquals(expectedUrl, BasePage.driver.getCurrentUrl());
		
		
    	
    }
    
	
	
	

}
