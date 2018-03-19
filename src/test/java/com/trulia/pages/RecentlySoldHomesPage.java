package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecentlySoldHomesPage {
	private WebDriver driver;

	public RecentlySoldHomesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//*[@id=\'srpHeaderLeftColumn\']/div/div[1]/div/h1")
	public WebElement recentlySoldHomes;
	
	@FindBy (xpath="//*[@id=\'locationInputs\']")
	public WebElement searchBox;
	
	
}
