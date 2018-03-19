package com.trulia.tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.trulia.pages.HomePage;
import com.trulia.pages.OpenHouse;
import com.trulia.utilities.TestBase;

public class SearchTest extends TestBase{
	String HomePageTitle = "Trulia: Real Estate Listings, Homes For Sale, Housing Data";

	/*
	 * User Story As a user I should be able to choose Homes for Sale from Buy
	 * module and choose min and max price range from Any Price
	 */
	@Test
	public void BuyModuleHomesForSale() throws InterruptedException {
		// open Home page www.trulia.com
		HomePage homePage = new HomePage(driver);
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
		OpenHouse openHouse = new OpenHouse(driver);
		// check title of "Open House" page contains expected
		assertTrue(titleContains(driver, "Open Houses "), "title of Open House page doen't contain \"Open House\"");
		// check if "Any Price" button is displayed
		assertTrue(openHouse.anyPrice.isDisplayed(), "\"Any Price\" button is not displayed");
		// clear search box
		openHouse.searchBox.clear();
		// enter new data
		openHouse.searchBox.sendKeys("Windermere, FL" + Keys.ENTER);
		Thread.sleep(2000);
		// check title contains expected
		assertTrue(titleContains(driver, "Windermere, FL Open Houses") && titleContains(driver, "| Trulia"),
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
		assertTrue(elementContainsText(openHouse.adjustFilters, "Adjust filters to find more homes:"),
				"adjustment doen't cantain text");
		assertTrue(elementContainsText(openHouse.adjustFilters, "Price $10,000"), "adjustment doen't cantain text");
		assertTrue(elementContainsText(openHouse.adjustFilters, "Remove All Filters"),
				"adjustment doen't cantain text");
		assertTrue(elementContainsText(openHouse.adjustFilters, "Open Houses"), "adjustment doesn't cantain text");
		// select new options for "minPrice" and "maxPrice"
		new Select(driver.findElement(By.id("minPrice"))).selectByVisibleText("$200k");
		new Select(driver.findElement(By.id("minPrice"))).selectByVisibleText("$200k");
		new Select(driver.findElement(By.id("maxPrice"))).selectByVisibleText("$800k");
		// check title contains expected
		assertTrue(titleContains(driver, "Windermere, FL Open Houses") && titleContains(driver, "| Trulia"));

	}

	// this methods belong to BrowserUtils class, i put it here for now
	// so there is now a lot of classes to change for now
	public static boolean titleContains(WebDriver driver, String title) {
		return driver.getTitle().contains(title);
	}

	public static boolean elementContainsText(WebElement element, String text) {
		return element.getText().contains(text);
	}
}
