package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Functional/Login.feature"
		,glue = {"stepDefinitions","hooks"}
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,monochrome = true
		,publish = true
		,tags = "@login"
		
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	//Below block is to run scenarios in a feature in parallel mode
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}