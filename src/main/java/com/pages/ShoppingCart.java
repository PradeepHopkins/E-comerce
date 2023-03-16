package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.ElementUtil;

public class ShoppingCart extends ElementUtil {

	public ShoppingCart(WebDriver driver) {
		super(driver);
	}

	
	private By list                      =  By.xpath("//table[@class='table table-bordered']//td[@class='text-left']/a");
	private By button_submit             =  By.xpath("//a[text()='Checkout']");
	private By link_backToShoppingCart   =  By.xpath("//a[text()='Shopping Cart']");
	private By button_remove             =  By.xpath("//button[@data-original-title='Remove']");
	private By label_empty               =  By.xpath("//h1/following-sibling::p[text()='Your shopping cart is empty!']");
	
	
	public String doVerify() {

		List<WebElement> elements = getElements(list, 15);
		if (elements.size() == 0) {
			return "";
		} else {
			String text = getText(list);
			System.out.println(text);
			return text;
		}

	}

	public void doCheckOut() {

		WebElement visible = waitForElementVisible(button_submit, 15);
		actionsClickByElement(visible);

	}
	
	public void doCancel() {

		clickButton(link_backToShoppingCart);
		WebElement visible = waitForElementVisible(button_remove, 15);
		actionsClickByElement(visible);

	}

	public String emptyCart() {

		WebElement element = waitForElementVisible(label_empty, 30);
		return element.getText().trim();
	}
	
}
