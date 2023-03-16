package com.util;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	private String parentWindowId;
	private String childWindowId;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

	public List<WebElement> getElements(By by, int sec) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		List<WebElement> findElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

		return findElements;
	}

	public void enterText(By by, String text) {
		WebElement element = getElement(by);
		element.sendKeys(text);
	}

	public void sendText(WebElement element, String text) {

		element.sendKeys(text);

	}

	public void clickButton(By by) {
		WebElement element = getElement(by);
		element.click();
	}

	public String getTitles() {
		return driver.getTitle();

	}

	public void actionsClick(By locator) {
		WebElement element = getElement(locator);
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();

	}

	public void actionsEnterText(By locator, String text) {
		WebElement element = getElement(locator);
		Actions actions = new Actions(driver);
		actions.sendKeys(element, text).build().perform();

	}

	public void actionsClickByElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.click(element).build().perform();

	}

	public void jsClickable(By locator) {

		WebElement element = getElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void jsClickableByElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void switchToNewWindow() {

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		parentWindowId = iterator.next();
		childWindowId = iterator.next();
		driver.switchTo().window(childWindowId);

	}

	public void switchToParentId() {

		driver.switchTo().window(parentWindowId);
	}

	public void newWindow() {

		driver.switchTo().newWindow(WindowType.WINDOW);

	}

	public String getText(By locator) {
		WebElement element = getElement(locator);
		String string = element.getText().trim();
		return string;

	}

	public void globalWait(int n) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(n));

	}

	public Boolean waitForTitle(String text, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		Boolean until = wait.until(ExpectedConditions.titleIs(text));
		return until;
		
	}
	public WebElement waitForElementVisible(By locator, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return until;
	}

}
