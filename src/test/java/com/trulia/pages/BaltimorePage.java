package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class BaltimorePage {

	private WebDriver driver;

	public BaltimorePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="bedroomsToggle")
	public WebElement allBeds;
	
	@FindBy(xpath="(//button[@class='btn btnDefault btnTouch '])[2]")
	public WebElement bedNumber;
	
	@FindBy(id="homeTypeToggle")
	public WebElement homeType;
	
	@FindBy(xpath="//label[@for='homeType0']")
	public WebElement house;
	
	@FindBy(id="moreToggle")
	public WebElement more;
	
	@FindBy(id="newListings")
	public WebElement listings;
	
	@FindBy(xpath="//span[@class='typeTruncate menu-personalized__userEmail___RajK']")
	public WebElement fastFurious;
	
	@FindBy(linkText="Log Out")
	public WebElement logOut;
}
