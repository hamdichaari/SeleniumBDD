package internet.Herookapp.pom.com;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	public static String BASE_URL = "https://the-internet.herokuapp.com";

	public static Map<String, String> PAGE_URLS = new HashMap<String, String>();

	static {

		PAGE_URLS.put("home", BASE_URL + "/");
		PAGE_URLS.put("checkboxes", BASE_URL + "/checkboxes");
		PAGE_URLS.put("dropdown", BASE_URL + "/dropdown");
		PAGE_URLS.put("dynamic controls", BASE_URL + "/dynamic_controls");
		PAGE_URLS.put("form authentication", BASE_URL + "/login");
		PAGE_URLS.put("inputs", BASE_URL + "/inputs");
		PAGE_URLS.put("secure area", BASE_URL + "/secure");
		PAGE_URLS.put("file download", BASE_URL + "/download");

		

	}

	public static WebDriver driver;

	public BasePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Elemental Selenium')]")
	static WebElement footerLink;

	@FindBy(xpath = "//body/div[2]/a[1]")
	static WebElement forkMeToGithubLink;

	public static String getPageFttoterText() {
		return footerLink.getText();

	}

	public abstract String getPageTitleText();

}
