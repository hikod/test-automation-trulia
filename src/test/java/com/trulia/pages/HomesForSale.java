package com.trulia.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class HomesForSale {
	private WebDriver driver;

	public HomesForSale() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@class='typeWeightNormal mbm']")
	public WebElement noHomesFoundText;
	
	@FindBy(xpath = "//*[@class='h6 typeLowlight pbs']")
	public WebElement searchResultHomes;

	@FindBy(xpath = "//div[@class='pbs']//label")
	public List<WebElement> allHomeTypeList;

	@FindBy(id = "homeTypeToggle")
	public WebElement allHomeTypes;

	@FindBy(id = "homeType1")
	public WebElement homeTypeCondo;
	@FindBy(id = "homeType2")
	public WebElement homeTypeTownhome;
	@FindBy(id = "homeType4")
	public WebElement homeTypeLand;
	
}
