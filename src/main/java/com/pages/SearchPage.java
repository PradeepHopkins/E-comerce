package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.Constants;
import com.util.ElementUtil;

public class SearchPage extends ElementUtil {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	private By label_searchProduct = By.xpath("//div[@class='caption']/h4/a[text()='MacBook Air']");

	public void doSelectProduct() {

		WebElement element = waitForElementVisible(label_searchProduct, 15);
		Constants.productName = getText(label_searchProduct);
		System.out.println(Constants.productName);
		jsClickableByElement(element);

	}

}