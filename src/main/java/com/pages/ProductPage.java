package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.ElementUtil;

public class ProductPage extends ElementUtil {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	private By button_addToCart  = By.xpath("//button[text()='Add to Cart']");
	private By link_shoppingCart = By.xpath("//span[text()='Shopping Cart']");

	public void doAddToCart() {

		WebElement element = waitForElementVisible(button_addToCart, 15);
		actionsClickByElement(element);
		actionsClick(link_shoppingCart);

	}

}