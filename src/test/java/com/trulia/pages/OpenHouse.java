package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenHouse {
	private WebDriver driver;

	public OpenHouse(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Aslan's creation for locators 
	@FindBy(id = "priceToggle")
	public WebElement anyPrice;

	@FindBy(id = "locationInputs")
	public WebElement searchBox;

	@FindBy(id = "priceForm")
	public WebElement priceForm;

	@FindBy(id = "minPrice")
	public WebElement minPrice;

	@FindBy(id = "maxPrice")
	public WebElement maxPrice;

	@FindBy(xpath = "//div[@class='ptm']")
	public WebElement adjustFilters;
}
