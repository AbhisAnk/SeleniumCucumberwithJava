package managers;

import org.openqa.selenium.WebDriver;

 
import pageObjects.LandingPage;
 

public class PageObjectManager {
	
	private WebDriver driver;
	
	private LandingPage landingPage;
	

	
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public LandingPage getlandingPage(){

		return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;

	}
	
	/*public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}*/
	
	
}
