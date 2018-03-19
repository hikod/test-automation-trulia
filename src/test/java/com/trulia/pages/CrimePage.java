package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CrimePage {

	private WebDriver driver;

	public CrimePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isAt() {
		return driver.getTitle().contains("Crime Data");

}
}
