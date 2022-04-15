package hooks;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;




public class Hooks {
	
	
	TestContext testContext;	
	public Hooks(TestContext context) {
		testContext = context;
	}
	

	
	@After(order=1)
	public void addScreenshot(Scenario scenario) throws IOException, InterruptedException {
		//if(scenario.isFailed()) {
		  File screenshot = ((TakesScreenshot)  testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		  scenario.attach(fileContent, "image/png", "screenshot");
		//}
		Thread.sleep(2000);
	}

	
	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
		}
	
	
}
