package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.trulia.pages.CrimePage;
import com.trulia.pages.HomePage;
import com.trulia.pages.MiamiBeachRecentlySoldHomesPage;
import com.trulia.pages.RecentlySoldHomesPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.TestBase;

public class LoginTest extends TestBase {

	// Test Case 2 - Iliyar
	@Test(priority = 2)
	public void homePageBuyRecentlySold() throws InterruptedException {
		// create object from HomePage class:
		HomePage homePage = new HomePage(driver);
		// verify at page
		assertTrue(homePage.isUrl());
		System.out.println(driver.getCurrentUrl());
		Actions action = new Actions(driver);
		// hover overing the cursor to Buy link text
		action.moveToElement(homePage.buy).build().perform();
		// checking if Recently Sold link Text is available
		assertTrue(homePage.recentlySold.isDisplayed());
		System.out.println(homePage.recentlySold.getText());
		// clicking on Recently Sold link text
		homePage.recentlySold.click();
		RecentlySoldHomesPage recentlySoldHomesPage = new RecentlySoldHomesPage(driver);
		// verifying Recently Sold Homes displayed
		assertTrue(recentlySoldHomesPage.recentlySoldHomes.getText().contains("Recently Sold Homes"));
		System.out.println(recentlySoldHomesPage.recentlySoldHomes.getText());
		// clear the Search box and click on it
		recentlySoldHomesPage.searchBox.clear();
		// entering the Miami Beach, FL and sending Enter keyword
		recentlySoldHomesPage.searchBox.sendKeys("Miami Beach, FL" + Keys.ENTER);
		Thread.sleep(5000);
		// verifying if title contains Miami Beach Recently Sold Properties | Trulia
		assertTrue(new MiamiBeachRecentlySoldHomesPage(driver).isAt());
		System.out.println(driver.getTitle());
	}

	//Test Case 3 - Christos
	@Test(priority = 3)
	public void signInTest() throws InterruptedException {
		// create object from HomePage class:
		HomePage homePage = new HomePage(driver);
		// verify at page
		assertTrue(homePage.isUrl());
		System.out.println(driver.getCurrentUrl());
		// Click sign in button
		homePage.signInButton.click();
		// Verify page contains text "Sign in or register"
		assertTrue(homePage.signInText.getText().contains("Sign in or register"));
		System.out.println(homePage.signInText.getText());
		// Enter the email in the email field and Click on the Submit button
		homePage.email.sendKeys(ConfigurationReader.getProperty("email"));
		homePage.submit.click();
		// Verify page contains text "Enter your password"
		assertTrue(homePage.passwordText.getText().contains("Enter your password"));
		System.out.println(homePage.passwordText.getText());
		// Enter the password of the registered user. Click the Sign in button.
		homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
		homePage.signInButtonFinal.click();
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// Boolean
		// element=wait.until(ExpectedConditions.invisibilityOf(homePage.signInButton));
		// // Verify "Sign in" button is not displayed. LinkText equals to "Fast
		// Furious"
		// assertFalse(homePage.signInButton.isDisplayed());
		assertEquals(homePage.linktextFast.getText(), "Fast Furious");
		System.out.println(homePage.linktextFast.getText());

	}

	// Test Case 4 - Hikmet
	@Test(priority = 4)
	public void homePageBuyNewHomes() {
		// create object from HomePage class:
		HomePage homePage = new HomePage(driver);
		// verify at page
		assertTrue(homePage.isAt());
		System.out.println(driver.getTitle());
		Actions action = new Actions(driver);
		// hover overing the cursor to Buy link text
		action.moveToElement(homePage.buy).build().perform();
		// checking if New Homes link Text is available
		assertTrue(homePage.newHomes.isDisplayed());
		System.out.println(homePage.newHomes.getText());
		// clicking on NewHomes
		homePage.newHomes.click();
		// verifying New Homes For Sale is displayed
		assertTrue(homePage.newHomeForSale.getText().contains("New Homes For Sale"));
		System.out.println(homePage.newHomeForSale.getText());
		// Clicking on the Any Plan link text
		homePage.anyPlan.click();
		// checking the first selected option is No Min
		assertEquals(new Select(homePage.minPrice).getFirstSelectedOption().getText(), "No Min");
		System.out.println(new Select(homePage.minPrice).getFirstSelectedOption().getText());
		// checking the first selected option is No Max is
		assertEquals(new Select(homePage.maxPrice).getFirstSelectedOption().getText(), "No Max");
		System.out.println(new Select(homePage.maxPrice).getFirstSelectedOption().getText());
	}

	// test case 5 - Lais

	/*
	 * dont forget to change the method name from homePageTitle to homePageCrimeTest
	 */
	@Test(priority = 5)
	public void homePageTitle() {

		// create object from HomePage class:
		HomePage homePage = new HomePage(driver);

		// verify at page
		assertTrue(homePage.isAt());
		System.out.println(driver.getTitle());
		Actions action = new Actions(driver);
		// hover overing the cursor to Local Scoop link text
		action.moveToElement(homePage.localScoop).build().perform();
		// checking if Crime link Text is available
		assertTrue(homePage.crime.isDisplayed());
		System.out.println(homePage.crime.getText());
		// clicking on the crime
		homePage.crime.click();
		CrimePage crimePage = new CrimePage(driver);
		// verifying the title contains Crime Data
		assertTrue(crimePage.isAt());
		System.out.println(driver.getTitle());

	}

	@Test(priority = 6)
	public void TC006() {
		// create object from HomePage class:
		HomePage homePage = new HomePage(driver);

		// verify at page
		assertTrue(homePage.isAt());
		System.out.println(driver.getTitle());
		
		//clearing the search box and entering the Schaumburg, IL in the search box
		homePage.searchBar.clear();
		homePage.searchBar.sendKeys("Schaumburg, IL");
		homePage.searchButton.click();
		//Verifying the title is "Schaumburg, IL Open Houses | Trulia"
		BrowserUtils.switchToWindow("Schaumburg, IL Real Estate & Homes For Sale | Trulia");
		BrowserUtils.waitForPageToLoad(20);
		assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
	}
}
