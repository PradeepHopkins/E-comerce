package com.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {



	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_Browser(Properties prop) {

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		switch (browser) {

		case "chrome":
			tlDriver.set(new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")));
			break;
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
			default:
			System.out.println("Incorrect Browser" + browser);

		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(url);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {

		return tlDriver.get();
	}

}
