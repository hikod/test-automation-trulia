package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class CrimePage {

	private WebDriver driver;

	public CrimePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	public boolean isAt() {
		return driver.getTitle().contains("Crime Data");

}
}
