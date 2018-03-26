package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class HomePage {

	private WebDriver driver;

	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	// Christos' Locators
	@FindBy(xpath = "//p[@class='mbl mtn']")
	public WebElement passwordText;

	// Aika's Locators

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
	
	@FindBy(linkText="Buy")
	public WebElement BuyLink;
	
	@FindBy(xpath="//a[contains(text(),'New Homes')]")
	public WebElement NewHomesLink;
	
	@FindBy(xpath="//a[contains(text(),'Open Houses')]")
	public WebElement openHousesLink;
	
	@FindBy(xpath="//a[contains(text(),'Homes for Sale')]")
	public WebElement homesForSaleLink;
	
	@FindBy(xpath="//a[@class='floatLeft navbar__navbarLogo___2-cY']")
	public WebElement logo;
	
	@FindBy(linkText="Local Scoop")
	public WebElement localScoopLink;
	
	@FindBy(linkText="Market Trends")
	public WebElement marketTrendsLink;

	// Iliyar's Locators
	@FindBy(linkText = "Recently Sold")
	public WebElement recentlySold;

	// Hikmet's Locators
	@FindBy(xpath="//*[@id=\'keywordsToggle\']")
	public WebElement keywordsToggle;
	@FindBy(xpath="//*[@id=\'keywordInput\']")
	public WebElement keywordsInputTextBox;
	@FindBy(xpath="//*[@id=\'keywordsDropdown\']/div/span/span")
	public WebElement parkingGarageFilter;
	@FindBy(xpath="//*[@id=\'srpHeaderLeftColumn\']/div/div[3]/span/span")
	public WebElement parkingGarageFilterAfter;
	@FindBy (xpath="//*[@id=\'srpHeaderLeftColumn\']/div/div[1]/div/h2")
	public WebElement searchResultForParkingGarage;
	@FindBy(xpath="//*[@id=\'resultsColumn\']/div/h6")
	public WebElement x ;
	@FindBy(xpath = "//*[@id=\'homeTypesDropdown\']/div/div/div[1]/div[1]/span/label")
	public WebElement houseCheckBoxHomeTypes;
	@FindBy(xpath = "//*[@id=\'homeTypesDropdown\']/div/div/div[1]/div[2]/span/label")
	public WebElement condoCheckBoxHomeTypes;
	@FindBy(xpath = "//*[@id=\'homeTypesDropdown\']/div/div/div[1]/div[3]/span/label")
	public WebElement townhomeCheckBoxHomeTypes;
	@FindBy(xpath = "//*[@id=\'homeTypesDropdown\']/div/div/div[1]/div[4]/span/label")
	public WebElement multifamilyCheckBoxHomeTypes;
	@FindBy(xpath = "//*[@id=\'homeTypesDropdown\']/div/div/div[2]/div[1]/span/label")
	public WebElement landCheckBoxHomeTypes;
	@FindBy(xpath = "//*[@id=\'homeTypesDropdown\']/div/div/div[2]/div[2]/span/label")
	public WebElement mobileManufacturedCheckBoxHomeTypes;
	@FindBy(xpath = "//*[@id=\'homeTypesDropdown\']/div/div/div[2]/div[3]/span/label")
	public WebElement otherCheckBoxHomeTypes;
	@FindBy(xpath="//*[@id=\'srpHeaderLeftColumn\']/div/div[1]/div/h2")
	public WebElement searchResultForHomesForSalesLand;

	@FindBy(id = "homeTypeToggle")
	public WebElement allHomeTypesToggle;
//	@FindBy(linkText = "Homes for Sale")
//	public WebElement homesForSaleLink;

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
	/*
	 * Aika has the same xpath for the next 2 locators in LoginPage class
	 * 
	 */
	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchBar;

	@FindBy(xpath = "//button[@class='css-ejw4np btn btnPrimary']")
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

	@FindBy(linkText="Schools")
	public WebElement schools;

	public boolean isAt() {
		return driver.getTitle().equals("Trulia: Real Estate Listings, Homes For Sale, Housing Data");
	}

	public boolean isUrl() {
		return driver.getCurrentUrl().equals("https://www.trulia.com/");
	}
	
}
