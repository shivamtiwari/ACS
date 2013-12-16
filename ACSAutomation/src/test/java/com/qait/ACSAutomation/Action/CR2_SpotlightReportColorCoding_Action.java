package com.qait.ACSAutomation.Action;

import org.junit.Assert;

import com.qait.ACSAutomation.Utilities.Utilities;

public class CR2_SpotlightReportColorCoding_Action extends CR1StrategicPlanningQuestionFinal_Action {
	public void clickOnReportTab() {
		colourCoding.get_ReportTab().isDisplayed();
		colourCoding.get_ReportTab().click();
		waitForSync();
		colourCoding.get_spotlightReportForTechnicalDivisionsLink().isDisplayed();
	}

	public void clickOnSpotlightReportForTechnicalDivisionsLink() {
		colourCoding.get_spotlightReportForTechnicalDivisionsLink().click();
		waitForSync();
		colourCoding.get_organizationDropDown().isDisplayed();
	}

	public void verifyResponseToQuestionDisplay() {
		SelectElementFromDropdown(colourCoding.get_organizationDropDown(), "visibleText", Utilities.getYamlValue("Division.TDDivisionName"));
		SelectElementFromDropdown(colourCoding.get_yearDropDownReport(), "visibleText", "2013");
		colourCoding.get_goButtonReport().click();
		waitForSync();
		colourCoding.get_responceLabel().isDisplayed();
	}

	public void verifyColourCodingForResponce() {
		colourCoding.get_responceTextBox().isDisplayed();
		if (colourCoding.get_responceTextBox().getAttribute("value").equalsIgnoreCase("YES")) {
			Assert.assertTrue(colourCoding.get_responceTextBox().getAttribute("outerHTML").contains("background-color:#FF5555;"));
		} else {
			Assert.assertTrue(!colourCoding.get_responceTextBox().getAttribute("outerHTML").contains("background-color:#FF5555;"));
		}
	}

	public void changeOptionToNoAndVerifyColourCode(String Option) {
		planningQuestion.get_annualReportTab().click();
		waitForSync();
		planningQuestion.get_eventsAndActivitiesHeadingOnAnnualReport().isDisplayed();
		SelectElementFromDropdown(planningQuestion.get_divisionsDropDown(), "visibleText", Utilities.getYamlValue("Division.TDDivisionName"));
		SelectElementFromDropdown(planningQuestion.get_yearsDropDown(), "visibleText", "2013");
		planningQuestion.get_goButton().isDisplayed();
		planningQuestion.verifyAnnaualReportClickable("xpath", "//span[@class='gobutton']/input");
		planningQuestion.get_goButton().click();
		waitForSync();
		planningQuestion.get_AnnualReportTimeLineTableDivisionName(Utilities.getYamlValue("Division.TDDivisionName"));
		waitForSync();
		colourCoding.get_administrationForm().isDisplayed();
		colourCoding.get_administrationForm().click();
		waitForSync();
		colourCoding.get_PastYearFromAdminForm().isDisplayed();
		colourCoding.get_editTabAdminForm().click();
		waitForSync();
		while (colourCoding.get_PastYearFromAdminForm().getAttribute("outerHTML").contains("disable")) {
			hardWait(1);
			System.out.println("wait");
		}
		if (Option.equalsIgnoreCase("no")) {
			colourCoding.get_noOptionCheckBoxInAdminForm().click();
		}
		if (Option.equalsIgnoreCase("yes")) {
			colourCoding.get_yesOptionCheckBoxInAdminForm().click();
		}
		waitForSync();
		colourCoding.get_submitAdminForm().click();
	}

	public void verifyColourCodeAsPerOptionNO() {
		clickOnReportTab();
		clickOnSpotlightReportForTechnicalDivisionsLink();
		verifyResponseToQuestionDisplay();
		colourCoding.get_responceTextBox().isDisplayed();
		Assert.assertTrue(!colourCoding.get_responceTextBox().getAttribute("outerHTML").contains("background-color:#FF5555;"));
	}

	public void verifyColourCodeAsPerOptionYES() {
		clickOnReportTab();
		clickOnSpotlightReportForTechnicalDivisionsLink();
		verifyResponseToQuestionDisplay();
		colourCoding.get_responceTextBox().isDisplayed();
		Assert.assertTrue(colourCoding.get_responceTextBox().getAttribute("outerHTML").contains("background-color:#FF5555;"));
	}
}
