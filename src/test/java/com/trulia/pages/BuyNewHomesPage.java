package com.trulia.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class BuyNewHomesPage {
	private WebDriver driver;

	public BuyNewHomesPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "locationInputs")
	public WebElement searchBar;

	@FindBy(id = "bedroomsToggle")
	public WebElement allBeds;
	@FindBy(xpath = "(//button[contains(text(),'1+')])[1]")
	public WebElement onePlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'2+')])[1]")
	public WebElement twoPlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'3+')])[1]")
	public WebElement threePlusBedroom;

	@FindBy(xpath = "(//button[contains(text(),'4+')])[1]")
	public WebElement fourPlusBedroom;

	@FindBy(id = "homeTypeToggle")
	public WebElement allHometypes;

	@FindBy(xpath = "//input[@type='checkbox']")
	public List<WebElement> allHometypesList;

	public boolean homeTypesAreDisplayed(List<WebElement> HometypesList) {
		for (int i = 0; i < allHometypesList.size(); i++) {
			if (allHometypesList.get(i).isDisplayed())
				return true;
		}
		return false;
	}

	@FindBy(xpath = "//h2")
	public WebElement noMatchText;

	@FindBy(id = "priceToggle")
	public WebElement anyPriceButton;

	@FindBy(id = "minPrice")
	public WebElement minPrice;

	@FindBy(id = "maxPrice")
	public WebElement maxPrice;
}
