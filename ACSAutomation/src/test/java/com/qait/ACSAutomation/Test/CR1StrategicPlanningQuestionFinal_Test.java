package com.qait.ACSAutomation.Test;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.qait.ACSAutomation.Action.CR1StrategicPlanningQuestionFinal_Action;
import com.qait.ACSAutomation.Utilities.Utilities;

public class CR1StrategicPlanningQuestionFinal_Test {
	CR1StrategicPlanningQuestionFinal_Action test = new CR1StrategicPlanningQuestionFinal_Action();
	String eventName;

	public CR1StrategicPlanningQuestionFinal_Test() {
	}

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
	public void clickOnAnnualReportTab() {
		test.clickOnAnnualReportTab();
	}

	@Test(dependsOnMethods = "clickOnAnnualReportTab")
	public void verifyAnnualReportTabLoaded() {
		test.verifyAnnualReportTabLoaded();
	}

	@Test(dependsOnMethods = "verifyAnnualReportTabLoaded")
	public void verifyStrategicPlanningQuestionDisplayForLS() {
		test.verifyStrategicPlanningQuestionDisplayForLS(test.getYamlVal("Division.LSDivisionName"));
	}

	@Test(dependsOnMethods = "verifyStrategicPlanningQuestionDisplayForLS")
	public void verifyStrategicPlanningQuestionDisplayForTD() {
		test.verifyStrategicPlanningQuestionDisplayForTD(test.getYamlVal("Division.TDDivisionName"));
	}

	@Test(dependsOnMethods = "verifyStrategicPlanningQuestionDisplayForLS")
	public void userAllowToAddTheEvent() {
		eventName = test.getYamlVal("EventInfo.Name") + Utilities.getCurrentFormatedTime();
		System.out.println(eventName);
		test.userAllowToAddTheEvent(eventName, test.getYamlVal("EventInfo.Description"), test.getYamlVal("EventInfo.Organization"), test.getYamlVal("EventInfo.Year"),
				test.getYamlVal("EventInfo.Phone"));
	}

	@Test(dependsOnMethods = "userAllowToAddTheEvent")
	public void verifyEventCreatedAndListedBelowEventHeading() {
		test.verifyEventCreatedAndListedBelowEventHeading(eventName);
	}

	@Test(dependsOnMethods = "verifyEventCreatedAndListedBelowEventHeading")
	public void verifyQuestionsDisplayUnderAddedEvent() {
		test.verifyQuestionsDisplayUnderAddedEvent(eventName);
	}

	@Test(dependsOnMethods = "verifyQuestionsDisplayUnderAddedEvent")
	public void verifyEditTabAllowUserToEditEvent() {
		test.verifyEditTabAllowUserToEditEvent();
	}

	@Test(dependsOnMethods = "verifyEditTabAllowUserToEditEvent")
	public void verifyUserAllowedEditFromDropDown() {
		test.verifyUserAllowedEditFromDropDown(eventName);
	}

	@Test(dependsOnMethods = "verifyUserAllowedEditFromDropDown")
	public void verifyQuestionsDisplayForPastYear() {
		test.verifyQuestionsDisplayForPastYear();
	}

	@Test(dependsOnMethods = "verifyQuestionsDisplayForPastYear")
	public void verifyHyperLinkInQuestionsOnEventPage() {
		test.verifyHyperLinkInQuestionsOnEventPage();
	}

	@Test(dependsOnMethods = "verifyHyperLinkInQuestionsOnEventPage")
	public void verifyLinksNavigationACStrategicPlanLink() {
		test.verifyLinksNavigationACStrategicPlanLink();
	}

	@Test(dependsOnMethods = "verifyLinksNavigationACStrategicPlanLink")
	public void verifyApplicationNotAllowUserToSaveFormWithNoQuestion() {
		test.verifyApplicationNotAllowUserToSaveFormWithNoQuestion(eventName, test.getYamlVal("EventInfo.Description"), test.getYamlVal("EventInfo.Organization"),
				test.getYamlVal("EventInfo.Year"), test.getYamlVal("EventInfo.Phone"));
	}

	@AfterClass
	public void tearDown() {
		Reporter.log(" ########## Stop Browser Session ###########");
		test.stopBrowserSession();
	}
}
