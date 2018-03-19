package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MiamiBeachRecentlySoldHomesPage {
	private WebDriver driver;

	public MiamiBeachRecentlySoldHomesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isAt() {
		return driver.getTitle().contains("Miami Beach Recently Sold Properties | Trulia");
	}

}
