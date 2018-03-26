package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Configuration;

import com.trulia.pages.HomePage;
import com.trulia.pages.HomesForSale;
import com.trulia.pages.OpenHouse;
import com.trulia.pages.RecentlySoldHomesPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.Driver;
import com.trulia.utilities.TestBase;

public class SearchTest extends TestBase {
	
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
	String HomePageTitle = "Trulia: Real Estate Listings, Homes For Sale, Housing Data";

	/*
	 * User Story As a user I should be able to choose Homes for Sale from Buy
	 * module and choose min and max price range from Any Price
	 */
	 @Test(groups = "functional")
	public void TC_1_BuyModuleHomesForSale() throws InterruptedException {
		// open Home page www.trulia.com
		HomePage homePage = new HomePage();
		// check title
		assertEquals(driver.getTitle(), HomePageTitle, "title is not equal to expected for home page");
		Actions action = new Actions(driver);
		// navigate to "Buy" dropDown menu
		action.moveToElement(homePage.buyDropDown).build().perform();
		// check is "Open House" selection option is among them
		assertTrue(homePage.openHouse.isDisplayed() && homePage.openHouse.getText().equals("Open Houses"),
				"BUY dropdown list doesn't have OPEN HOUSE selection or text doesn't conatin Open House");
		// click on "Open House" selection from "Buy" menu
		action.moveToElement(homePage.openHouse).click().build().perform();
		// go to "Open House" page
		OpenHouse openHouse = new OpenHouse();
		// check title of "Open House" page contains expected
		assertTrue(BrowserUtils.titleContains(driver, "Open Houses "),
				"title of Open House page doen't contain \"Open House\"");
		// check if "Any Price" button is displayed
		assertTrue(openHouse.anyPrice.isDisplayed(), "\"Any Price\" button is not displayed");
		// clear search box
		openHouse.searchBox.clear();
		// enter new data
		openHouse.searchBox.sendKeys("Windermere, FL" + Keys.ENTER);
		BrowserUtils.waitFor(2);
		// check title contains expected
		assertTrue(
				BrowserUtils.titleContains(driver, "Windermere, FL Open Houses")
						&& BrowserUtils.titleContains(driver, "| Trulia"),
				"title doen't contain \"Windermere, FL Open Houses\"");
		// click on "Any Price"
		openHouse.anyPrice.click();
		// check is "minPrice" and "maxPrice" buttons are displayed
		assertTrue(openHouse.minPrice.isEnabled() && openHouse.maxPrice.isEnabled(),
				"minPrice and maxPrice are not displayed");
		// select options for "minPrice" and "maxPrice"
		new Select(driver.findElement(By.id("minPrice"))).selectByVisibleText("$10k");
		new Select(driver.findElement(By.id("maxPrice"))).selectByVisibleText("$10k");
		// check text from "Adjustment Filter" contains expected
		assertTrue(BrowserUtils.elementContainsText(openHouse.adjustFilters, "Adjust filters to find more homes:"),
				"adjustment doen't cantain text");
		assertTrue(BrowserUtils.elementContainsText(openHouse.adjustFilters, "Price $10,000"),
				"adjustment doen't cantain text");
		assertTrue(BrowserUtils.elementContainsText(openHouse.adjustFilters, "Remove All Filters"),
				"adjustment doen't cantain text");
		assertTrue(BrowserUtils.elementContainsText(openHouse.adjustFilters, "Open Houses"),
				"adjustment doesn't cantain text");
		// select new options for "minPrice" and "maxPrice"
		new Select(driver.findElement(By.id("minPrice"))).selectByVisibleText("$200k");
		new Select(driver.findElement(By.id("minPrice"))).selectByVisibleText("$200k");
		new Select(driver.findElement(By.id("maxPrice"))).selectByVisibleText("$800k");
		// check title contains expected
		assertTrue(BrowserUtils.titleContains(driver, "Windermere, FL Open Houses")
				&& BrowserUtils.titleContains(driver, "| Trulia"));

	}

	/*
	 * As a User I should be able to login and I should be able to choose 3 options
	 * on the Homes For Sale Drop-Down list
	 */
	 @Test(groups = "functional")
	public void TC_7_Buy_Module_Homes_for_Sale_Sub_Module_Test() throws InterruptedException {
		// open Home page www.trulia.com
		driver.get(ConfigurationReader.getProperty("url"));
		HomePage homePage = new HomePage();
		// check title
		assertEquals(driver.getTitle(), HomePageTitle, "title is not equal to expected for home page");
		Actions action = new Actions(driver);
		// navigate to "Buy" dropDown menu
		action.moveToElement(homePage.buyDropDown).build().perform();
		// click on "Open House" selection from "Buy" menu
		action.moveToElement(homePage.openHouse).click().build().perform();
		OpenHouse openHouse = new OpenHouse();
		// check title of "Open House" page contains expected
		openHouse.searchBox.clear();
		openHouse.searchBox.sendKeys("Schaumburg, IL" + Keys.ENTER);
		BrowserUtils.waitFor(2);
		// check title contains expected

		assertEquals(driver.getTitle(), "Schaumburg, IL Open Houses - "
				+ getIntFromSearchResult(openHouse.searchResultHomes) + " Listings | Trulia",
				"title of Open House page dosn't contain \"Open House\"");
		// move mouse to Buy dropDown tab
		action.moveToElement(openHouse.buyDropDown).build().perform();
		// make sure Homes For Sale option is presented
		assertTrue(openHouse.homesForSale.isDisplayed());
		// click on Homes For Sale option
		action.moveToElement(openHouse.homesForSale).click().build().perform();
		// verify title still contains Schaumburg, IL Real Estate & Homes For Sale |
		// Trulia
		assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
		HomesForSale homesForSale = new HomesForSale();
		// click on All Homes link
		action.moveToElement(homesForSale.allHomeTypes).click().build().perform();
		// check if all options in All Home Types are displayed
		boolean displayedAll = true;
		for (WebElement elem : homesForSale.allHomeTypeList) {
			if (!elem.isDisplayed())
				displayedAll = false;
		}
		assertTrue(displayedAll);
		// check condo townhome and land in All Home Types
		homesForSale.homeTypeCondo.click();
		homesForSale.homeTypeLand.click();
		homesForSale.homeTypeTownhome.click();
		// At least 1 result should be displayed in the
		// listings or you should see "Your search
		// does not match any homes." message on the screen
		boolean searchResult = false;
		if (homesForSale.searchResultHomes.isDisplayed()) {
			if (getIntFromSearchResult(homesForSale.searchResultHomes) > 0)
				searchResult = true;
		} else {
			if (homesForSale.noHomesFoundText.getText().equals("Adjust filters to find more homes:"))
				searchResult = true;
		}
		assertTrue(searchResult);
	}

	/*
	 * User opens the Trulia web-site. User navigates to Buy - Recently Sold. User
	 * sees only "Sold" listings sorted in "Newest" first order.
	 */
	 @Test
	public void TC_14_RecentlySoldPage() {
		// open Home page www.trulia.com
		driver.get(ConfigurationReader.getProperty("url"));
		HomePage homePage = new HomePage();
		// check title
		assertEquals(driver.getTitle(), HomePageTitle, "title is not equal to expected for home page");
		// check url
		assertEquals(driver.getCurrentUrl(), "https://www.trulia.com/");
		Actions action = new Actions(driver);
		// navigate to "Buy" dropDown menu
		action.moveToElement(homePage.buyDropDown).build().perform();
		// check if Recently Sold link contains text "Recently Sold"
		assertEquals(homePage.recentlySold.getText(), "Recently Sold");
		// click on Recenlty Sold link
		action.moveToElement(homePage.recentlySold).click().build().perform();
		// check if url equals to: https://www.trulia. com/sold/
		assertTrue(driver.getCurrentUrl().contains("https://www.trulia.com/sold/"));
		// check if title equals to: Recently Sold Properties | Trulia
		assertTrue(driver.getTitle().contains("Recently Sold Properties | Trulia"));
		// check if all listed homes are sold/have sold text in each listings
		RecentlySoldHomesPage recentlySold = new RecentlySoldHomesPage();
		assertTrue(recentlySold.allHomesAreSold(recentlySold.soldTextFromHomesListings));
		// check if sold homes listing start from newly sold (by date)
		assertTrue(recentlySold.allSoldHomesAreListedByDate(recentlySold.soldDate));
	}

	@Test
	public void TC_17_Validate_Choosing_Schools_Functionality() {
		// open Home page www.trulia.com
		driver.get(ConfigurationReader.getProperty("url"));
		HomePage homePage = new HomePage();
		// check title
		assertEquals(driver.getTitle(), HomePageTitle, "title is not equal to expected for home page");
		// check url
		assertEquals(driver.getCurrentUrl(), "https://www.trulia.com/");
		Actions action = new Actions(driver);
		// navigate to "Local Scoop" dropDown menu
		action.moveToElement(homePage.localScoop).perform();
		//verify "Local Scoop" drop down contains "Schools" link
		action.moveToElement(homePage.schools).click().perform();
		//verify Page Url contains "/schools/".
		assertTrue(driver.getCurrentUrl().contains("/schools/"));
		// Verify that Title contains "Public & Private Schools"
		assertTrue(driver.getTitle().contains("Public & Private Schools"));

	}

	// this methods belong to BrowserUtils class, i put it here for now
	// so there is now a lot of classes to change for now
	public List<String> getStringList(List<WebElement> list) {
		List<String> stringList = new ArrayList<>();
		for (WebElement elem : list) {
			stringList.add(elem.getText());
		}
		return stringList;
	}

	public int getIntFromSearchResult(WebElement element) {
		String[] splited = element.getText().split(" ");
		return Integer.parseInt(splited[0]);
	}
}
