package com.qait.ACSAutomation.Action;

import org.testng.Assert;

import com.qait.ACSAutomation.Utilities.Utilities;

public class CR1StrategicPlanningQuestionFinal_Action extends BaseFixture {
	public void verifyLoginPage() {
		waitForSync();
		planningQuestion.get_usernameTextBox().isDisplayed();
		planningQuestion.get_passwordTextBox().isDisplayed();
		planningQuestion.get_signinButton().isDisplayed();
	}

	public void loginToApplication(String userName, String password) {
		planningQuestion.get_usernameTextBox().sendKeys(userName);
		planningQuestion.get_passwordTextBox().sendKeys(password);
		planningQuestion.get_signinButton().click();
		waitForSync();
	}

	public void verifyLandingPage() {
		waitForElementToVisible(planningQuestion.get_annualReportTab());
		planningQuestion.get_annualReportTab().isDisplayed();
		waitForSync();
	}

	public void clickOnAnnualReportTab() {
		planningQuestion.verifyAnnaualReportClickable("id", "form_topnav:forms");
		planningQuestion.get_annualReportTab().click();
		waitForSync();
	}

	public void verifyAnnualReportTabLoaded() {
		planningQuestion.get_eventsAndActivitiesHeadingOnAnnualReport().isDisplayed();
	}

	public void verifyStrategicPlanningQuestionDisplayForLS(String LSdivisionName) {
		planningQuestion.get_eventsAndActivitiesHeadingOnAnnualReport().isDisplayed();
		SelectElementFromDropdown(planningQuestion.get_divisionsDropDown(), "visibleText", LSdivisionName);
		SelectElementFromDropdown(planningQuestion.get_yearsDropDown(), "visibleText", "2013");
		planningQuestion.get_goButton().isDisplayed();
		planningQuestion.verifyAnnaualReportClickable("xpath", "//span[@class='gobutton']/input");
		planningQuestion.get_goButton().click();
		waitForSync();
		waitForElementToVisible(planningQuestion.get_AnnualReportTimeLineTableDivisionName(LSdivisionName));
		planningQuestion.get_addActivityButton().click();
		Assert.assertTrue(planningQuestion.get_strategicGoalHeading().getText()
				.equals("Which strategic goal(s) from the ACS Strategic Plan does this event support? Examples of how categories relate to the strategic plan*"));
		String temp = planningQuestion.get_strategicGoalOptionsTable().getText();
		Assert.assertTrue(temp.contains("1. Provide Information. Be the most authoritative, comprehensive, and indispensable provider of chemistry-related information.")
				&& temp.contains("2. Advance Member Careers. Empower an inclusive community of members with networks, opportunities, resources, and skills to thrive in the global economy.")
				&& temp.contains("3. Improve Education. Foster the development of the most innovative, relevant and effective chemistry education in the world.")
				&& temp.contains("4. Communicate Chemistry’s Value. Communicate chemistry’s vital role in addressing the world’s challenges to the public and policymakers."));
	}

	public void verifyStrategicPlanningQuestionDisplayForTD(String TDdivisionName) {
		planningQuestion.get_annualReportTab().click();
		waitForSync();
		verifyStrategicPlanningQuestionDisplayForLS(TDdivisionName);
	}

	public void userAllowToAddTheEvent(String name, String description, String organization, String years, String phone) {
		planningQuestion.get_annualReportTab().click();
		waitForSync();
		verifyStrategicPlanningQuestionDisplayForLS("Alaska");
		enterInformationOnAssEventPage(name, description, organization, years, phone);
		planningQuestion.get_saveButton().click();
		planningQuestion.get_saveMessage().isDisplayed();
		Assert.assertTrue(planningQuestion.get_saveMessage().getText().equals("The event details were successfully saved."));
	}

	public void verifyEventCreatedAndListedBelowEventHeading(String eventName) {
		planningQuestion.get_annualReportTab().click();
		SelectElementFromDropdown(planningQuestion.get_divisionsDropDown(), "visibleText", Utilities.getYamlValue("Division.LSDivisionName"));
		SelectElementFromDropdown(planningQuestion.get_yearsDropDown(), "visibleText", "2013");
		planningQuestion.get_goButton().isDisplayed();
		planningQuestion.verifyAnnaualReportClickable("xpath", "//span[@class='gobutton']/input");
		planningQuestion.get_goButton().click();
		waitForSync();
		waitForSync();
		planningQuestion.get_eventsAndActivitiesHeadingOnAnnualReport().isDisplayed();
		planningQuestion.get_eventNameInEventTable(eventName).isDisplayed();
	}

	public void verifyQuestionsDisplayUnderAddedEvent(String eventName) {
		planningQuestion.get_eventNameInEventTable(eventName).click();
		waitForSync();
		planningQuestion.get_nameOfEvent().isDisplayed();
		Assert.assertTrue(planningQuestion.get_strategicGoalHeading().getText()
				.equals("Which strategic goal(s) from the ACS Strategic Plan does this event support? Examples of how categories relate to the strategic plan*"));
		String temp = planningQuestion.get_strategicGoalOptionsTable().getText();
		Assert.assertTrue(temp.contains("1. Provide Information. Be the most authoritative, comprehensive, and indispensable provider of chemistry-related information.")
				&& temp.contains("2. Advance Member Careers. Empower an inclusive community of members with networks, opportunities, resources, and skills to thrive in the global economy.")
				&& temp.contains("3. Improve Education. Foster the development of the most innovative, relevant and effective chemistry education in the world.")
				&& temp.contains("4. Communicate Chemistry’s Value. Communicate chemistry’s vital role in addressing the world’s challenges to the public and policymakers."));
	}

	public void verifyEditTabAllowUserToEditEvent() {
		planningQuestion.get_editButtonOnEventPage().isDisplayed();
		planningQuestion.get_editButtonOnEventPage().click();
		waitForSync();
		planningQuestion.waitforEditPage();
		planningQuestion.get_checkboxStrategicGoalOptions().get(0).click();
		planningQuestion.get_saveButton().click();
		planningQuestion.get_saveMessage().isDisplayed();
		Assert.assertTrue(planningQuestion.get_saveMessage().getText().equals("The event details were successfully saved."));
	}

	public void verifyUserAllowedEditFromDropDown(String str) {
		
		planningQuestion.get_annualReportTab().click();
		SelectElementFromDropdown(planningQuestion.get_divisionsDropDown(), "visibleText", Utilities.getYamlValue("Division.LSDivisionName"));
		SelectElementFromDropdown(planningQuestion.get_yearsDropDown(), "visibleText", "2013");
		planningQuestion.get_goButton().isDisplayed();
		planningQuestion.verifyAnnaualReportClickable("xpath", "//span[@class='gobutton']/input");
		planningQuestion.get_goButton().click();
		waitForSync();
		waitForSync();
		planningQuestion.get_eventsAndActivitiesHeadingOnAnnualReport().isDisplayed();
		planningQuestion.get_eventNameInEventTable(str).isDisplayed();
		

		hardWait(4);
		SelectElementFromDropdown(planningQuestion.get_DropDownFromEventTable(str), "visibleText", "Edit");
		planningQuestion.get_GoButtonFromTable(str).click();
		planningQuestion.get_nameOfEvent().isDisplayed();
		planningQuestion.get_checkboxStrategicGoalOptions().get(3).click();
		planningQuestion.get_saveButton().click();
		planningQuestion.get_saveMessage().isDisplayed();
		Assert.assertTrue(planningQuestion.get_saveMessage().getText().equals("The event details were successfully saved."));
	}

	public void verifyQuestionsDisplayForPastYear() {
		planningQuestion.get_annualReportTab().click();
		waitForSync();
		planningQuestion.get_eventsAndActivitiesHeadingOnAnnualReport().isDisplayed();
		SelectElementFromDropdown(planningQuestion.get_divisionsDropDown(), "visibleText", Utilities.getYamlValue("Division.LSDivisionName"));
		SelectElementFromDropdown(planningQuestion.get_yearsDropDown(), "visibleText", "2014");
		planningQuestion.get_goButton().isDisplayed();
		planningQuestion.verifyAnnaualReportClickable("xpath", "//span[@class='gobutton']/input");
		planningQuestion.get_goButton().click();
		waitForSync();
		waitForSync();
		planningQuestion.get_addActivityButton().click();
		waitForSync();
		planningQuestion.get_nameOfEvent().isDisplayed();
		Assert.assertTrue(planningQuestion.get_strategicGoalHeading().getText()
				.equals("Which strategic goal(s) from the ACS Strategic Plan does this event support? Examples of how categories relate to the strategic plan*"));
		String temp = planningQuestion.get_strategicGoalOptionsTable().getText();
		Assert.assertTrue(temp.contains("1. Provide Information. Be the most authoritative, comprehensive, and indispensable provider of chemistry-related information.")
				&& temp.contains("2. Advance Member Careers. Empower an inclusive community of members with networks, opportunities, resources, and skills to thrive in the global economy.")
				&& temp.contains("3. Improve Education. Foster the development of the most innovative, relevant and effective chemistry education in the world.")
				&& temp.contains("4. Communicate Chemistry’s Value. Communicate chemistry’s vital role in addressing the world’s challenges to the public and policymakers."));
	}

	public void verifyHyperLinkInQuestionsOnEventPage() {
		planningQuestion.get_aceStrategicPlanLink().isDisplayed();
		Assert.assertTrue(planningQuestion.get_aceStrategicPlanLink().getAttribute("href").equals("http://strategy.acs.org/"));
		planningQuestion.get_examplesOfHowCategoriesLink().isDisplayed();
		Assert.assertTrue(planningQuestion.get_examplesOfHowCategoriesLink().getAttribute("href").equals("http://acswebcontent.acs.org/FORMS/category_examples.doc"));
	}

	public void verifyLinksNavigationACStrategicPlanLink() {
		planningQuestion.get_aceStrategicPlanLink().click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	public void verifyApplicationNotAllowUserToSaveFormWithNoQuestion(String name, String description, String organization, String years, String phone) {
		planningQuestion.get_nameOfEvent().clear();
		planningQuestion.get_nameOfEvent().sendKeys(name);
		planningQuestion.get_briefDescription().clear();
		planningQuestion.get_briefDescription().sendKeys(description);
		SelectElementFromDropdown(planningQuestion.get_organization(), "visibleText", organization);
		SelectElementFromDropdown(planningQuestion.get_yearHeld(), "visibleText", years);
		planningQuestion.get_primaryContact().click();
		planningQuestion.get_primaryContact().clear();
		planningQuestion.get_primaryContact().sendKeys(phone);
		planningQuestion.get_optionToSelectFromCat().get(1).click();
		planningQuestion.get_selectButtonWithCategories().click();
		planningQuestion.get_saveButton().click();
		planningQuestion.get_saveMessage().isDisplayed();
		Assert.assertTrue(planningQuestion.get_saveMessage().isDisplayed());
		Assert.assertTrue(planningQuestion.get_saveMessage().getText().equals("Please check for validation errors on the page."));
		planningQuestion.get_strategicGoalMessage().isDisplayed();
		Assert.assertTrue(planningQuestion.get_strategicGoalMessage().getText().equals("Please Select at least one Strategic Goal."));
	}

	public void enterInformationOnAssEventPage(String name, String description, String organization, String years, String phone) {
		planningQuestion.get_nameOfEvent().clear();
		planningQuestion.get_nameOfEvent().sendKeys(name);
		planningQuestion.get_briefDescription().clear();
		planningQuestion.get_briefDescription().sendKeys(description);
		SelectElementFromDropdown(planningQuestion.get_organization(), "visibleText", organization);
		SelectElementFromDropdown(planningQuestion.get_yearHeld(), "visibleText", years);
		planningQuestion.get_primaryContact().click();
		planningQuestion.get_primaryContact().clear();
		planningQuestion.get_primaryContact().sendKeys(phone);
		planningQuestion.get_checkboxStrategicGoalOptions().get(1).click();
		planningQuestion.get_checkboxStrategicGoalOptions().get(2).click();
		planningQuestion.get_optionToSelectFromCat().get(1).click();
		planningQuestion.get_selectButtonWithCategories().click();
	}
}
