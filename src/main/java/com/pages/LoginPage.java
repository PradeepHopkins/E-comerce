package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.ElementUtil;

public class LoginPage extends ElementUtil {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By text_mailID   = By.id("input-email");
	private By text_password = By.id("input-password");
	private By button_login  = By.id("button-login");

	public void doLogin(String username, String password) {

		WebElement visible = waitForElementVisible(text_mailID, 15);
		sendText(visible, username);
		actionsEnterText(text_password, password);
		actionsClick(button_login);
	}
}
