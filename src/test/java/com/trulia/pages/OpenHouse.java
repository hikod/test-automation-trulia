package com.trulia.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class OpenHouse {
	private WebDriver driver;

	public OpenHouse() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//Hikmet's Locators
	@FindBy(xpath="//h1[@class='h3']")
	public WebElement openHousesText ;
	@FindBy(xpath="//div[@class='horizontalContainer']//div//button[@id='dropdownBtn']")
	public WebElement searchButton;
	@FindBy(id = "bedroomsToggle")
	public WebElement allBeds;
	@FindBy(xpath="//button[@class='btn btnDefault btnTouch btnSecondary'][contains(text(),'Studio+')]")
	public WebElement studioPlus;
	@FindBy(xpath = "(//button[contains(text(),'1+')])[1]")
	public WebElement onePlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'2+')])[1]")
	public WebElement twoPlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'3+')])[1]")
	public WebElement threePlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'4+')])[1]")
	public WebElement fourPlusBedroom;

	// Iliyar's Locators
	@FindBy(xpath = "//*[@id=\'resultsColumn\']/div/div[2]/div[1]/div[1]/ul/li[1]/div/div/div[2]/a[1]/div[2]/div/div[1]/span")
	public WebElement priceOfOpenHouse;

	public boolean comparisonOfPrice() {
		String str = driver.findElement(By.xpath(
				"//*[@id=\'resultsColumn\']/div/div[2]/div[1]/div[1]/ul/li[1]/div/div/div[2]/a[1]/div[2]/div/div[1]/span"))
				.getText().substring(1);
		str=str.replace(",", "");
		System.out.println(str);
		int price = Integer.parseInt(str);
		if (50000 <= price && price <= 250000) {
			return true;
		}
		return false;
	}

	
	//Aslan's creation for locators 
		@FindBy(xpath = "(//section[@class='menu__dropdown___3YPv'])[1]")
		public WebElement buyDropDown;
		
		@FindBy(xpath="//*[@class='h6 typeLowlight pbs']")
		public WebElement searchResultHomes;
		
		@FindBy(xpath = "(//section[@class='menu__dropdown___3YPv'][1]//ul[1]//a)[1]")
		public WebElement homesForSale;
		
		@FindBy(xpath="//div[@class='pbs']//label")
		List <WebElement> allHomeTypeList;
		
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
