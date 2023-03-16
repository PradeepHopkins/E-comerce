package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.util.ElementUtil;

public class HomePage extends ElementUtil{
	

	public HomePage(WebDriver driver) {
		super(driver);
	}
    
	private By text_search     = By.xpath("//input[@name='search']");
	private By button_search   = By.xpath("//button[@class='btn btn-default btn-lg']");
	
	
	public void doSearch(String product) {

		enterText(text_search, product);
		clickButton(button_search);

	}

	

}
