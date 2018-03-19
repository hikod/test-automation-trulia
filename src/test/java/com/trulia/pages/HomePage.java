package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Christos' Locators
	@FindBy(xpath="//p[@class='mbl mtn']")
	public WebElement passwordText;
	

	// Aika's Locators
//	@FindBy(xpath = "//button[@class='baz btn btnDefault btnSml signinButton menu-personalized__signinButton___1CxD']")
//	public WebElement signInButton;
//
//	@FindBy(xpath = "//div[@class='mbs txtC h3 typeEmphasize']")
//	public WebElement signInText;
//
//	@FindBy(name = "email")
//	public WebElement email;
//
//	@FindBy(xpath = "//button[@class='btn btnPrimary btnFullWidth']")
//	public WebElement submit;
//
//	@FindBy(name = "password")
//	public WebElement password;
//
//	@FindBy(xpath = "//button[@class='btn btnPrimary btnFullWidth']")
//	public WebElement signInButtonFinal;
//
//	//@FindBy(xpath = "//span[@class='typeTruncate menu-personalized_userEmail__RajK']")
//	@FindBy (xpath =" //*[@id=\"navbarContainer\"]/div/nav/div/div[2]/ul/li[3]/a/span[2]")
//	public WebElement linktextFast;
	@FindBy(xpath="//button[@class='baz btn btnDefault btnSml signinButton menu-personalized__signinButton___1CxD']")
	public WebElement signInButton;
	
	@FindBy(xpath="//div[@class='mbs txtC h3 typeEmphasize']")
	public WebElement signInText;
	
	@FindBy(name="email")
	public WebElement email;
	
	@FindBy(xpath="//button[@class='btn btnPrimary btnFullWidth']")
	public WebElement submit;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//button[@class='btn btnPrimary btnFullWidth']")
	public WebElement signInButtonFinal;
	
	@FindBy(xpath="//span[@class='typeTruncate menu-personalized__userEmail___RajK']")
	public WebElement linktextFast;

	// Iliyar's Locators
	@FindBy(linkText = "Recently Sold")
	public WebElement recentlySold;

	// Hikmet's Locators
	@FindBy(linkText = "Buy")
	public WebElement buy;

	@FindBy(linkText = "New Homes")
	public WebElement newHomes;

	@FindBy(xpath = "//*[@id=\"srpHeaderLeftColumn\"]/div/div[1]/div/h1")
	public WebElement newHomeForSale;

	@FindBy(id = "priceToggle")
	public WebElement anyPlan;

	@FindBy(id = "minPrice")
	public WebElement minPrice;

	@FindBy(id = "maxPrice")
	public WebElement maxPrice;
/*Aika has the same xpath for the next 2 locators in LoginPage class
 * 
 */
	@FindBy(xpath="//input[@type='text']")
	public WebElement searchBar;
	
	@FindBy(xpath="//button[@class='css-ejw4np btn btnPrimary']")
	public WebElement searchButton;
	

	// Lais's Locators
	@FindBy(linkText = "Local Scoop")
	public WebElement localScoop;

	@FindBy(linkText = "Crime")
	public WebElement crime;

	@FindBy(linkText = "Crime Data")
	public WebElement crimeData;

	// Aslan's Locators
	@FindBy(xpath = "(//section[@class='menu__dropdown___3YPv'])[1]")
	public WebElement buyDropDown;

	@FindBy(xpath = "(//section[@class='menu__dropdown___3YPv'][1]//ul[1]//a)[2]")
	public WebElement openHouse;

	public boolean isAt() {
		return driver.getTitle().equals("Trulia: Real Estate Listings, Homes For Sale, Housing Data");
	}

	public boolean isUrl() {
		return driver.getCurrentUrl().equals("https://www.trulia.com/");
	}

}
