package com.qait.ACSAutomation.Test;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.ACSAutomation.Action.CR2_SpotlightReportColorCoding_Action;
import com.qait.ACSAutomation.Utilities.Utilities;

public class CR2_SpotlightReportColorCoding_Test {
	CR2_SpotlightReportColorCoding_Action test = new CR2_SpotlightReportColorCoding_Action();
	String eventName;

	@BeforeClass
	public void initialsettings() {
		Utilities.setYamlFilePath("testData/integration_testData_ACS.yml");
	}

	@Test
	public void setup() {
		Reporter.log(" ########## Start browser session STARTS ###########");
		test.startBrowserSession(test.getYamlVal("browser"));
		Reporter.log(" ########## Start browser session ENDS ###########");
	}

	@Test(dependsOnMethods = "setup")
	public void launchDashboardPage() {
		Reporter.log(" ########## Launch ACS Home page STARTS ###########");
		test.launchUrl(test.getYamlVal("appurl"));
		Reporter.log(" ########## Launch ACS Home page ENDS ###########");
	}

	@Test(dependsOnMethods = "launchDashboardPage")
	public void verifyLoginPage() {
		Reporter.log(" ########## Verify Login Page STARTS ###########");
		test.verifyLoginPage();
		Reporter.log(" ########## Verify Login Page ENDS ###########");
	}

	@Test(dependsOnMethods = "verifyLoginPage")
	public void loginToApplication() {
		Reporter.log(" ########## Verify Login page STARTS ###########");
		test.loginToApplication(test.getYamlVal("loginCredentials.userName"), test.getYamlVal("loginCredentials.password"));
		Reporter.log(" ########## Verify Login page ENDS ###########");
	}

	@Test(dependsOnMethods = "loginToApplication")
	public void verifyLandingPage() {
		Reporter.log(" ########## Verify Login to Application STARTS ###########");
		test.verifyLandingPage();
		Reporter.log(" ########## Verify Login to Application ENDS ###########");
	}

	@Test(dependsOnMethods = "verifyLandingPage")
	public void clickOnReportTab() {
		test.clickOnReportTab();
	}

	@Test(dependsOnMethods = "clickOnReportTab")
	public void clickOnSpotlightReportForTechnicalDivisionsLink() {
		test.clickOnSpotlightReportForTechnicalDivisionsLink();
	}

	@Test(dependsOnMethods = "clickOnSpotlightReportForTechnicalDivisionsLink")
	public void verifyResponseToQuestionDisplay() {
		test.verifyResponseToQuestionDisplay();
	}

	@Test(dependsOnMethods = "verifyResponseToQuestionDisplay")
	public void verifyColourCodingForResponce() {
		test.verifyColourCodingForResponce();
	}

	@Test(dependsOnMethods = "verifyColourCodingForResponce")
	public void changeOptionToNoAndVerifyColourCode() {
		test.changeOptionToNoAndVerifyColourCode("no");
	}

	@Test(dependsOnMethods = "changeOptionToNoAndVerifyColourCode")
	public void verifyColourCodeAsPerOptionNO() {
		test.verifyColourCodeAsPerOptionNO();
	}

	@Test(dependsOnMethods = "verifyColourCodeAsPerOptionNO")
	public void changeOptionToYESAndVerifyColourCode() {
		test.changeOptionToNoAndVerifyColourCode("yes");
	}

	@Test(dependsOnMethods = "changeOptionToYESAndVerifyColourCode")
	public void verifyColourCodeAsPerOptionYES() {
		test.verifyColourCodeAsPerOptionYES();
	}

	@AfterClass
	public void tearDown() {
		Reporter.log(" ########## Stop Browser Session ###########");
		test.stopBrowserSession();
	}
}
