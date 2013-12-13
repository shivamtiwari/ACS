package com.qait.ACSAutomation.UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CR1StrategicPlanningQuestionFinal_UI extends BaseUI {
	public CR1StrategicPlanningQuestionFinal_UI(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;
	@FindBy(id = "loginForm:username")
	protected WebElement usernameTextBox;
	@FindBy(id = "loginForm:password")
	protected WebElement passwordTextBox;
	@FindBy(id = "loginForm:save")
	protected WebElement signinButton;
	@FindBy(id = "form_topnav:forms")
	protected WebElement annualReportTabOnHomePage;
	@FindBy(xpath = "//legend[contains(text(),'Events, Activities and Meetings')]")
	protected WebElement eventsAndActivitiesHeadingOnAnnualReport;
	@FindBy(id = "divisions")
	protected WebElement divisionsDropDown;
	@FindBy(id = "years")
	protected WebElement yearsDropDown;
	@FindBy(xpath = "//span[@class='gobutton']/input")
	protected WebElement goButton;
	@FindBy(id = "listView:addNew")
	protected WebElement addActivityButton;
	@FindBy(xpath = "//label[@for='strategicGoal']")
	protected WebElement strategicGoalHeading;
	@FindBy(xpath = "//table[@id='overviewForm:idStrategicGoal']")
	protected WebElement strategicGoalOptionsTable;
	// *********** Event Form UI Elements ************
	@FindBy(id = "overviewForm:eventName")
	protected WebElement nameOfEvent;
	@FindBy(id = "overviewForm:eventDescription")
	protected WebElement briefDescription;
	@FindBy(id = "overviewForm:eventOrganization")
	protected WebElement organization;
	@FindBy(id = "overviewForm:yearHeld")
	protected WebElement yearHeld;
	@FindBy(id = "overviewForm:primaryContact")
	protected WebElement primaryContact;
	@FindBy(id = "overviewForm:eventPhase")
	protected WebElement phaseDropDown;
	@FindBy(id = "overviewForm:eventFrequency")
	protected WebElement frequencyDropDown;
	@FindBy(id = "overviewForm:save")
	protected WebElement saveButton;
	@FindBy(xpath = "//table[@id='overviewForm:idCategories']//td[1]//li")
	protected WebElement categoriesOptionsToSelect;
	@FindBy(xpath = "//table[@id='overviewForm:idCategories']//button[1]")
	protected WebElement selectButtonWithCategories;
	@FindBy(id = "overviewForm:hiddenMessageMessage")
	protected WebElement saveMessage;
	@FindBy(id = "overviewForm:idStrategicGoalMessage")
	protected WebElement strategicGoalMessage;
	@FindBy(id = "overviewForm:j_idt29")
	protected WebElement editButtonOnEventPage;
	@FindBy(xpath = "//a[contains(text(),'ACS Strategic Plan')]")
	protected WebElement aceStrategicPlanLink;
	@FindBy(xpath = "//a[contains(text(),'Examples of how categories relate to the strategic plan')]")
	protected WebElement examplesOfHowCategoriesLink;

	public WebElement get_usernameTextBox() {
		return usernameTextBox;
	}

	public WebElement get_passwordTextBox() {
		return passwordTextBox;
	}

	public WebElement get_signinButton() {
		return signinButton;
	}

	public WebElement get_annualReportTab() {
		return annualReportTabOnHomePage;
	}

	public void verifyAnnaualReportClickable(String selectorType, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		if (selectorType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
		}
		if (selectorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
		}
	}

	public WebElement get_eventsAndActivitiesHeadingOnAnnualReport() {
		return eventsAndActivitiesHeadingOnAnnualReport;
	}

	public WebElement get_divisionsDropDown() {
		return divisionsDropDown;
	}

	public WebElement get_yearsDropDown() {
		return yearsDropDown;
	}

	public WebElement get_goButton() {
		return goButton;
	}

	public WebElement get_addActivityButton() {
		System.out.println(driver.findElement(By.xpath(".//*[@id='listView']/fieldset[1]//button")).getAttribute("outerHTML"));
		return addActivityButton;
	}

	public WebElement get_AnnualReportTimeLineTableDivisionName(String divisionName) {
		return driver.findElement(By.xpath("//table[@id='LSAndTDList']//td[contains(text(),'" + divisionName + "')]"));
	}

	public WebElement get_strategicGoalHeading() {
		return strategicGoalHeading;
	}

	public WebElement get_strategicGoalOptionsTable() {
		return strategicGoalOptionsTable;
	}

	public List<WebElement> get_checkboxStrategicGoalOptions() {
		return driver.findElements(By.name("overviewForm:idStrategicGoal"));
	}

	public WebElement get_nameOfEvent() {
		return nameOfEvent;
	}

	public WebElement get_briefDescription() {
		return briefDescription;
	}

	public WebElement get_organization() {
		return organization;
	}

	public WebElement get_yearHeld() {
		return yearHeld;
	}

	public WebElement get_phaseDropDown() {
		return phaseDropDown;
	}

	public WebElement get_primaryContact() {
		return primaryContact;
	}

	public WebElement get_frequencyDropDown() {
		return frequencyDropDown;
	}

	public WebElement get_saveButton() {
		return saveButton;
	}

	public WebElement get_selectButtonWithCategories() {
		return selectButtonWithCategories;
	}

	public List<WebElement> get_optionToSelectFromCat() {
		return driver.findElements(By.xpath("//table[@id='overviewForm:idCategories']//td[1]//li"));
	}

	public WebElement get_saveMessage() {
		return saveMessage;
	}

	public WebElement get_eventNameInEventTable(String str) {
		return driver.findElement(By.xpath("//div[@id='listView:activityList']//span[contains(text(),'" + str + "')]"));
	}

	public WebElement get_editButtonOnEventPage() {
		return editButtonOnEventPage;
	}

	public void waitforEditPage() {
		while (driver.findElement(By.id("overviewForm:eventName")).getAttribute("outerHTML").contains("disabled=")) {
			hardWait(1);
		}
	}

	public WebElement get_DropDownFromEventTable(String str) {
		return driver.findElement(By.xpath("//tbody[@id='listView:activityList_data']//span[contains(text(),'" + str + "')]/parent::a/parent::td/parent::tr/td//select"));
	}

	public WebElement get_GoButtonFromTable(String str) {
		return driver.findElement(By.xpath("//tbody[@id='listView:activityList_data']//span[contains(text(),'" + str
				+ "')]/parent::a/parent::td/parent::tr/td//select/following-sibling::div/button[1]"));
	}

	public WebElement get_aceStrategicPlanLink() {
		return aceStrategicPlanLink;
	}

	public WebElement get_examplesOfHowCategoriesLink() {
		return examplesOfHowCategoriesLink;
	}

	public WebElement get_strategicGoalMessage() {
		return strategicGoalMessage;
	}
}
