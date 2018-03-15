package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean isAt() {
		return driver.getTitle().equals("Trulia: Real Estate Listings, Homes For Sale, Housing Data");
	}
	
}
