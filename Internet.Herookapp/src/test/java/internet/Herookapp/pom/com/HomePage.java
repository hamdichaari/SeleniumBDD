package internet.Herookapp.pom.com;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(tagName = "h1")
	WebElement pageTtile;
	@FindBy(tagName = "h2")
	WebElement subheader;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li")
	List<WebElement> allSubPages;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li/a")
	List<WebElement> allSubPageLinks;

	@Override
	public String getPageTitleText() {
		// TODO Auto-generated method stub
		return pageTtile.getText();
	}

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String getSubheaderText() {

		return subheader.getText();
	}

	public List<String> getSubPagesNames() {

		List<String> subPageNames = new ArrayList<String>();

		for (WebElement subPage : allSubPages) {

			subPageNames.add(subPage.getText().split("\\(")[0]);

			// subPageNames.add(subPage.getText());

		}

		return subPageNames;

	}

	public void clickOnPageLink(String pageName) {

		for (WebElement suPageLink : allSubPageLinks) {

			if (suPageLink.getText().startsWith(pageName)) {

				suPageLink.click();
                break;
			}

		}

	}

}
