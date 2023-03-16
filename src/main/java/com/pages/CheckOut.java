package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.ElementUtil;

public class CheckOut extends ElementUtil {

	public CheckOut(WebDriver driver) {
		super(driver);
	}
	
	
	private By button_billing          = By.id("button-payment-address");
	private By button_deliveryDetails  = By.id("button-shipping-address");
	private By button_deliveryMethods  = By.id("button-shipping-method");
	private By Checkbox_payment        = By.xpath("//input[@type='checkbox']");
	private By Button_payment          = By.id("button-payment-method");
	
	
	public void doAddress() {

		WebElement element = waitForElementVisible(button_billing, 15);
		actionsClickByElement(element);
		WebElement element2 = waitForElementVisible(button_deliveryDetails, 15);
		actionsClickByElement(element2);
		WebElement element3 = waitForElementVisible(button_deliveryMethods, 15);
		actionsClickByElement(element3);

	}

	public void doPayment() {

		WebElement visible = waitForElementVisible(Checkbox_payment, 15);
		actionsClickByElement(visible);
		clickButton(Button_payment);

   }
}
