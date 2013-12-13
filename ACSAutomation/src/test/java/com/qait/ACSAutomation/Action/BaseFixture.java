package com.qait.ACSAutomation.Action;

//import java.io.File;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.WebDriver;
//
//import com.qait.myNGconnect.CXP.UI.*;
//
//package com.qait.myNGconnect.CXP.Action;

import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.ACSAutomation.UI.CR1StrategicPlanningQuestionFinal_UI;
import com.qait.ACSAutomation.Utilities.Utilities;

public class BaseFixture {

	public WebDriver driver;
	public DesiredCapabilities capabilities;

	 CR1StrategicPlanningQuestionFinal_UI planningQuestion;

	public void startBrowserSession(String Bro) {
		capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		if (Bro.equalsIgnoreCase("firefox")) {
			capabilities.setBrowserName("firefox");
			driver = new FirefoxDriver();
			addAllBrowserSetup(driver);
		} else if (Bro.equalsIgnoreCase("iexplore")) {
			File file = new File("IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setJavascriptEnabled(true);
			driver = new InternetExplorerDriver(dc);

		} else if (Bro.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		initPageObjects();
		driver.manage().window().maximize();

	}

	private static void addAllBrowserSetup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0, 0));
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();
		Dimension dim = new Dimension((int) screenSize.getWidth(),
				(int) screenSize.getHeight());
		driver.manage().window().setSize(dim);
	}

	public void initPageObjects() {
		 planningQuestion = new CR1StrategicPlanningQuestionFinal_UI(driver);

	}

	public void launchUrl(String url) {
		driver.get(url);

	}

	public void stopBrowserSession() {
		driver.quit();
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public void waitForSync(){
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}
	
	
	
	public void waitForElementToVisible(WebElement e){
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void setUpDataFile(String dataFilePath) {
		Utilities.setYamlFilePath(dataFilePath);
	}

	public String getYamlVal(String yamlMapObj) {
		return Utilities.getYamlValue(yamlMapObj);
	}
	
	public void hardWait(int seconds){
		try{
			Thread.sleep(seconds*1000);
		}catch(Exception e){
			System.out.println("Can't wait...");
		}
	}
	
	public void SelectElementFromDropdown(WebElement selectElement, String selectorType,  String sel){
		Select select=new Select(selectElement);
		if(selectorType.equalsIgnoreCase("index")){
			select.selectByIndex(Integer.parseInt(sel));
		}
		if(selectorType.equalsIgnoreCase("visibleText")){
			select.selectByVisibleText(sel);
		}
		if(selectorType.equalsIgnoreCase("value")){
			select.selectByValue(sel);
		}
		
	}
}