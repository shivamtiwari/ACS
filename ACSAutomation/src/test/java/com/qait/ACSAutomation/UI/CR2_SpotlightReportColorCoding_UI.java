package com.qait.ACSAutomation.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CR2_SpotlightReportColorCoding_UI extends BaseUI {
	public CR2_SpotlightReportColorCoding_UI(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "form_topnav:reports")
	protected WebElement reportTab;
	@FindBy(id = "frmReportLinks:dt2:11:r1")
	protected WebElement spotlightReportForTechnicalDivisionsLink;
	@FindBy(id = "spotlightTdReportForm:org")
	protected WebElement organizationDropDown;
	@FindBy(id = "spotlightTdReportForm:year")
	protected WebElement yearDropDownReport;
	@FindBy(id = "spotlightTdReportForm:j_idt36")
	protected WebElement goButtonReport;
	@FindBy(xpath = "//td[contains(text(),'Division Offices Not Filled by Elections')]")
	protected WebElement responceLabel;
	@FindBy(xpath = "//td[contains(text(),'Division Offices Not Filled by Elections')]/following-sibling::td/input")
	protected WebElement responceTextBox;
	@FindBy(xpath = "//span[@class='color_link' and contains(text(),'Administration Form 2013')]")
	protected WebElement administrationForm;
	@FindBy(id = "governanceForm:j_idt33")
	protected WebElement editTabAdminForm;
	@FindBy(id = "governanceForm:positionVacant:1")
	protected WebElement noOptionCheckBoxInAdminForm;
	@FindBy(id = "governanceForm:positionVacant:0")
	protected WebElement yesOptionCheckBoxInAdminForm;
	@FindBy(id = "governanceForm:chkSubmitStatus")
	protected WebElement submitAdminForm;

	public WebElement get_ReportTab() {
		return reportTab;
	}

	public WebElement get_spotlightReportForTechnicalDivisionsLink() {
		return spotlightReportForTechnicalDivisionsLink;
	}

	public WebElement get_organizationDropDown() {
		return organizationDropDown;
	}

	public WebElement get_yearDropDownReport() {
		return yearDropDownReport;
	}

	public WebElement get_goButtonReport() {
		return goButtonReport;
	}

	public WebElement get_responceLabel() {
		return responceLabel;
	}

	public WebElement get_responceTextBox() {
		return responceTextBox;
	}

	public WebElement get_administrationForm() {
		return administrationForm;
	}

	public WebElement get_PastYearFromAdminForm() {
		return driver.findElement(By.id("governanceForm:positionsFilledLastYear"));
	}

	public WebElement get_editTabAdminForm() {
		return editTabAdminForm;
	}

	public WebElement get_yesOptionCheckBoxInAdminForm() {
		return yesOptionCheckBoxInAdminForm;
	}

	public WebElement get_noOptionCheckBoxInAdminForm() {
		return noOptionCheckBoxInAdminForm;
	}
	
	public WebElement get_submitAdminForm(){
		return submitAdminForm;
	}
}
