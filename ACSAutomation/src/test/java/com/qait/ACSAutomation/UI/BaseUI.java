package com.qait.ACSAutomation.UI;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUI {
	WebDriver driver;
	int AJAX_WAIT = 60;
	private int waitTime = 60;

	public BaseUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean waitForElementToAppear(WebElement element) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis() + waitTime;
		int elementDisplayed = 0;
		while (System.currentTimeMillis() < endTime) {
			elementDisplayed++;
			System.out.println(elementDisplayed);
			try {
				if (element.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					return true;
				}
			} catch (Exception e) {
				System.out.println("Waiting...");
			}
		}// end while
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return false;
	}

	public void explicitWait(WebDriver driver, int seconds, String locator, String selectorElement, boolean check) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
		if (check) {
			if (locator.equalsIgnoreCase("xpath")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorElement)));
			} else if (locator.equalsIgnoreCase("css")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorElement)));
			} else if (locator.equalsIgnoreCase("id")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selectorElement)));
			} else {
				System.out.println("Enter correct locator");
			}
		}
	}

	public void SelectElementFromDropdown(WebElement selectElement, String selectorType, String sel) {
		Select select = new Select(selectElement);
		if (selectorType.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(sel));
		}
		if (selectorType.equalsIgnoreCase("visibleText")) {
			select.selectByVisibleText(sel);
		}
		if (selectorType.equalsIgnoreCase("value")) {
			select.selectByValue(sel);
		}
	}

	public void waitForLoaderToDisappear(WebElement element) {
		int i = 0;
		resetImplicitTimeout(2);
		try {
			while (element.isDisplayed() && i <= AJAX_WAIT) {
				Thread.sleep(1000);
				i++;
			}
		} catch (Exception e) {
		}
		resetImplicitTimeout(AJAX_WAIT);
	}

	public void resetImplicitTimeout(int newTimeOut) {
		try {
			driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
	}

	public void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			System.out.println("Can't wait...");
		}
	}
}
