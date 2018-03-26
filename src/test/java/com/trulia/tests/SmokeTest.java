package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.trulia.pages.BaltimorePage;
import com.trulia.pages.HomePage;
import com.trulia.pages.LoginPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.TestBase;

public class SmokeTest extends TestBase {

	@Test(priority = 0, groups = "smoke")
	public void logInTest() {
		driver.get("https://www.trulia.com/");
		assertEquals(driver.getCurrentUrl(), "https://www.trulia.com/");
		assertEquals(driver.getTitle(), "Trulia: Real Estate Listings, Homes For Sale, Housing Data");

	}

	@Test(priority = 1, groups = "smoke")
	public void signInTest() {
		HomePage home = new HomePage();
		home.signInButton.click();
		System.out.println(home.signInText.getText());
		assertEquals(home.signInText.getText(), "Sign in or register\n" + "to save your favorite homes");
		home.email.sendKeys(ConfigurationReader.getProperty("email"));
		home.submit.click();
		home.password.sendKeys(ConfigurationReader.getProperty("password"));
		home.signInButtonFinal.click();
		assertEquals(driver.getCurrentUrl(), "https://www.trulia.com/");
		assertEquals(driver.getTitle(), "Trulia: Real Estate Listings, Homes For Sale, Housing Data");
		assertEquals(home.linktextFast.getText(), "Fast Furious");

	}

	@Test(priority = 2, groups = "smoke")
	public void searchFunctionality() {
		LoginPage login = new LoginPage();
		login.searchBar.clear();
		login.searchBar.sendKeys("Baltimore");
		login.searchButton.click();
		BrowserUtils.switchToWindow("Baltimore, MD Homes For Sale & Real Estate");
		BrowserUtils.waitForPageToLoad(20);
		assertEquals(driver.getTitle(), "Baltimore, MD Real Estate & Homes For Sale | Trulia");

	}

	@Test(priority = 3, groups = "smoke")
	public void choosingTest() {

		BaltimorePage baltimore = new BaltimorePage();
		baltimore.allBeds.click();
		baltimore.bedNumber.click();
		baltimore.homeType.click();
		baltimore.house.click();
		baltimore.more.click();
		baltimore.listings.click();
		assertTrue(driver.getCurrentUrl().contains("Baltimore"));
		assertTrue(driver.getTitle().contains("Baltimore"));

	}

	@Test(priority = 4, groups = "smoke")
	public void logOutTest() {
		BaltimorePage baltimore = new BaltimorePage();
		Actions actions = new Actions(driver);
		actions.moveToElement(baltimore.fastFurious).perform();
		baltimore.logOut.click();
		assertTrue(driver.getCurrentUrl().contains("Baltimore"));
		assertTrue(driver.getTitle().contains("Baltimore"));

	}

}
