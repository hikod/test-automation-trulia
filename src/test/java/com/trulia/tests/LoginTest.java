package com.trulia.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trulia.pages.CrimePage;
import com.trulia.pages.HomePage;
import com.trulia.pages.OpenHouse;
import com.trulia.pages.RecentlySoldHomesPage;
import com.trulia.utilities.BrowserUtils;
import com.trulia.utilities.ConfigurationReader;
import com.trulia.utilities.Driver;
import com.trulia.utilities.TestBase;

public class LoginTest extends TestBase {
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
	
	 // Test Case 2 - Iliyar
	 @Test(groups = "functional")
	 public void TC002() throws InterruptedException {
	 // create object from HomePage class:
	 HomePage homePage = new HomePage();
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
	 RecentlySoldHomesPage recentlySoldHomesPage = new
	 RecentlySoldHomesPage();
	 // verifying Recently Sold Homes displayed
	 assertTrue(recentlySoldHomesPage.recentlySoldHomes.getText().contains("Recently Sold Homes"));
	 System.out.println(recentlySoldHomesPage.recentlySoldHomes.getText());
	 // clear the Search box and click on it
	 recentlySoldHomesPage.searchBox.clear();
	 // entering the Miami Beach, FL and sending Enter keyword
	 recentlySoldHomesPage.searchBox.sendKeys("Miami Beach, FL" + Keys.ENTER);
	 BrowserUtils.waitFor(5);
	 // verifying if title contains Miami Beach Recently Sold Properties | Trulia
	 BrowserUtils.switchToWindow("Miami Beach Recently Sold Properties | Trulia");
	 BrowserUtils.waitForPageToLoad(20);
	 assertEquals(driver.getTitle(), "Miami Beach Recently Sold Properties | Trulia");
	 System.out.println(driver.getTitle());
	 }
	
	 // Test Case 3 - Christos
	 @Test( groups = "functional")
	 public void TC003() throws InterruptedException {
	 // create object from HomePage class:
	 HomePage homePage = new HomePage();
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
	 // // Verify "Sign in" button is not displayed. LinkText equals to "Fast
	 // Furious"
	 // assertFalse(homePage.signInButton.isDisplayed());
	 assertEquals(homePage.linktextFast.getText(), "Fast Furious");
	 System.out.println(homePage.linktextFast.getText());
	
	 }
	
	 // Test Case 4 - Hikmet
	 @Test(groups = "functional")
	 public void TC004() {
	 // create object from HomePage class:
	 HomePage homePage = new HomePage();
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
	 assertEquals(new
	 Select(homePage.minPrice).getFirstSelectedOption().getText(), "No Min");
	 System.out.println(new
	 Select(homePage.minPrice).getFirstSelectedOption().getText());
	 // checking the first selected option is No Max is
	 assertEquals(new
	 Select(homePage.maxPrice).getFirstSelectedOption().getText(), "No Max");
	 System.out.println(new
	 Select(homePage.maxPrice).getFirstSelectedOption().getText());
	 }
	
	 // test case 5 - Lais
	
	 /*
	 * dont forget to change the method name from homePageTitle to
	 homePageCrimeTest
	 */
	 @Test( groups = "functional")
	 public void TC005() {
	
	 // create object from HomePage class:
	 HomePage homePage = new HomePage();
	
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
	 CrimePage crimePage = new CrimePage();
	 // verifying the title contains Crime Data
	 assertTrue(crimePage.isAt());
	 System.out.println(driver.getTitle());
	
	 }

	@Test( groups = "functional")
	 public void TC006() {
	 // create object from HomePage class:
	 HomePage homePage = new HomePage();
	
	 // verify at page
	 assertTrue(homePage.isAt());
	 System.out.println(driver.getTitle());
	
	 // clearing the search box and entering the Schaumburg, IL in the search box
	 homePage.searchBar.clear();
	 homePage.searchBar.sendKeys("Schaumburg, IL");
	 homePage.searchButton.click();
	 BrowserUtils.waitFor(3);
	 // Verifying the title is "Schaumburg, IL Real Estate & Homes For Sale | Trulia"
	 BrowserUtils.switchToWindow("Schaumburg, IL Real Estate & Homes For Sale | Trulia");
	 assertEquals(driver.getTitle(), "Schaumburg, IL Real Estate & Homes For Sale | Trulia");
	 System.out.println(driver.getTitle());
	 Actions action = new Actions(driver);
	 // hover overing the cursor to Buy link text
	 action.moveToElement(homePage.buy).build().perform();
	 // checking if New Homes link Text is available
	 assertTrue(homePage.homesForSaleLink.isDisplayed());
	 System.out.println(homePage.homesForSaleLink.getText());
	 // clicking on NewHomes
	 homePage.homesForSaleLink.click();
	 homePage.allHomeTypesToggle.click();
	 System.out.println(driver.getTitle());
	 BrowserUtils.waitFor(5);
	 // HOUSE, CONDO,TOWNHOME,MULTI-FAMILY,LAND,MOBILE/MANUFACTURED,OTHER
	 assertEquals(homePage.houseCheckBoxHomeTypes.getText(), "House");
	 assertEquals(homePage.condoCheckBoxHomeTypes.getText(), "Condo");
	 assertEquals(homePage.townhomeCheckBoxHomeTypes.getText(), "Townhome");
	 assertEquals(homePage.multifamilyCheckBoxHomeTypes.getText(),
	 "Multi-Family");
	 assertEquals(homePage.landCheckBoxHomeTypes.getText(), "Land");
	 assertEquals(homePage.mobileManufacturedCheckBoxHomeTypes.getText(),
	 "Mobile/Manufactured");
	 assertEquals(homePage.otherCheckBoxHomeTypes.getText(), "Other");
	 // Click on the Land option
	 homePage.landCheckBoxHomeTypes.click();
	 int result =
	 Integer.parseInt(homePage.searchResultForHomesForSalesLand.getText().substring(0, 1));
	 if (result > 0) {
	 assertTrue(true);
	 } else
	 assertEquals(homePage.searchResultForHomesForSalesLand.getText(), "Your search does not match any homes.");
	
	 }
	@Test ( groups = "functional")
	public void TC009() {
		// create object from HomePage class:
		HomePage homePage = new HomePage();
		// verify at page
		assertTrue(homePage.isUrl());
		System.out.println(driver.getCurrentUrl());
		// verify at page
		assertTrue(homePage.isAt());
		System.out.println(driver.getTitle());
		// clearing the search box and entering
		homePage.searchBar.clear();
		homePage.searchBar.sendKeys("Pittsburgh, PA");
		homePage.searchButton.click();
		BrowserUtils.waitForVisibility(driver.findElement(By.xpath("//*[@id=\'locationInputs\']")), 5);
		//Verify text "Pittsburgh, PA" is displayed
	//	assertTrue(driver.findElement(By.xpath("//*[@id=\'locationInputs\']")).getText()).equals("Pittsburgh, PA"));
		System.out.println(driver.findElement(By.xpath("//*[@id=\'locationInputs\']")).getText());
		
		Actions action = new Actions(driver);
		BrowserUtils.waitFor(10);
		// hover overing the cursor to Buy link text
		action.moveToElement(homePage.buy).build().perform();
		assertTrue(homePage.openHouse.isDisplayed());
		homePage.openHouse.click();
		//Verify the Title contains "Pittsburgh, PA Open Houses" 
		BrowserUtils.switchToWindow("Pittsburgh, PA Real Estate & Homes For Sale | Trulia");
		BrowserUtils.waitForPageToLoad(20);
     	assertTrue(driver.getTitle().contains("Pittsburgh, PA Open Houses"));
     	System.out.println(driver.getTitle());
		OpenHouse openHousePage=new OpenHouse();
		openHousePage.anyPrice.click();
		//Verify "Any Price" text is Displayed.
		assertTrue(openHousePage.anyPrice.isDisplayed());
		//Verify "No Min" and "No Max" are Displayed
		assertEquals(new Select(openHousePage.minPrice).getFirstSelectedOption().getText(), "No Min");
		System.out.println(new Select(openHousePage.minPrice).getFirstSelectedOption().getText());
		// checking the first selected option is No Max is
		assertEquals(new Select(homePage.maxPrice).getFirstSelectedOption().getText(), "No Max");
		// select options for "minPrice" and "maxPrice"
		System.out.println(new Select(openHousePage.maxPrice).getFirstSelectedOption().getText());
		new Select(driver.findElement(By.id("minPrice"))).selectByVisibleText("$50k");
		new Select(driver.findElement(By.id("maxPrice"))).selectByVisibleText("$250k");
		BrowserUtils.waitFor(10);
		assertTrue(openHousePage.comparisonOfPrice());
				
	}

	 @Test ( groups = "functional")
	 public void TC013() {
	 HomePage homePage = new HomePage();
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
	 // verifying the title contains New Homes For Sale
	 assertTrue(driver.getTitle().contains("New Homes For Sale"));
	 System.out.println(homePage.newHomeForSale.getText());
	 //click on the Keywords toggle
	 homePage.keywordsToggle.click();
	 assertTrue(homePage.keywordsToggle.isDisplayed());
	 //entering parking garage in the text box to search and clicking Enter
	 homePage.keywordsInputTextBox.sendKeys("parking garage"+Keys.ENTER);
	 assertTrue(homePage.parkingGarageFilter.isDisplayed());
	 System.out.println(homePage.parkingGarageFilter.getText());
	 if
	 (Integer.parseInt((homePage.searchResultForParkingGarage.getText()).substring(0,
	 1))>0)
	 {
	 Assert.assertEquals(homePage.parkingGarageFilterAfter.getText(),"parking garage");
	 System.out.println(Integer.parseInt((homePage.searchResultForParkingGarage.getText()).substring(0,1)));
	 }
	 else
	 Assert.assertEquals(homePage.searchResultForParkingGarage.getText(),"Your\r\n"
	 +
	 "search does not match any homes.");
	
	 }
	 @Test(groups = "functional")
	 public void TC015() {
	 // create object from HomePage class:
	 HomePage homePage = new HomePage();
	 // verify at page
	 assertTrue(homePage.isUrl());
	 System.out.println(driver.getCurrentUrl());
	 assertTrue(homePage.isAt());
	 BrowserUtils.hover(homePage.buy);
	 // checking if Recently Sold link Text is available
	 assertTrue(homePage.recentlySold.isDisplayed());
	 System.out.println(homePage.recentlySold.getText());
	 // clicking on Recently Sold link text
	 homePage.recentlySold.click();
	 RecentlySoldHomesPage recentlySoldHomesPage = new
	 RecentlySoldHomesPage();
	 assertTrue(driver.getCurrentUrl().contains("https://www.trulia.com/sold/"));
	 assertTrue(BrowserUtils.titleContains(driver, "Recently Sold Properties | Trulia"));
	 assertTrue(recentlySoldHomesPage.allHomesAreSold(recentlySoldHomesPage.soldTextFromHomesListings));
	 // check if sold homes listing start from newly sold (by date)
	 assertTrue(recentlySoldHomesPage.allSoldHomesAreListedByDate(recentlySoldHomesPage.soldDate));
	 recentlySoldHomesPage.allBedsDropDown.click();
	 recentlySoldHomesPage.threePlusBedroom.click();
	 assertTrue(recentlySoldHomesPage.recentlySoldHousesText.getText().contains("Recently Sold 3 Bedroom Homes"));
	 assertTrue(BrowserUtils.titleContains(driver, "Recently Sold Properties | Trulia"));
	 assertTrue(recentlySoldHomesPage.allHomesAreSold(recentlySoldHomesPage.soldTextFromHomesListings));
	 assertTrue(recentlySoldHomesPage.housesSoldThreePlusBedrooms(recentlySoldHomesPage.threePlusBedroomsList));
	
	 }

	 @Test( groups = "functional")
	 public void TC020() {
	 HomePage homePage = new HomePage();
	 assertEquals(driver.getCurrentUrl(), "https://www.trulia.com/");
	 assertTrue(BrowserUtils.titleContains(driver, "Trulia: Real Estate Listings, Homes For Sale, Housing Data"));
	 BrowserUtils.hover(homePage.buy);
	 assertTrue(homePage.buy.isDisplayed());
	 assertTrue(homePage.openHouse.isDisplayed());
	 assertTrue(homePage.homesForSaleLink.isDisplayed());
	 homePage.openHouse.click();
	 OpenHouse openHousePage = new OpenHouse();
	 openHousePage.searchBox.clear();
	 assertTrue(openHousePage.searchBox.isDisplayed());
	 openHousePage.searchBox.sendKeys("Pittsburgh, PA");
	 openHousePage.searchButton.click();
	 //BrowserUtils.waitForVisibility(openHousePage.openHousesText, 10);
	 assertEquals(openHousePage.openHousesText.getText(), "Open Houses in Pittsburgh, PA");
	 openHousePage.allBeds.click();
	 assertTrue(openHousePage.studioPlus.isDisplayed());
	 assertTrue(openHousePage.onePlusBedroom.isDisplayed());
	 assertTrue(openHousePage.twoPlusBedroom.isDisplayed());
	 assertTrue(openHousePage.threePlusBedroom.isDisplayed());
	 assertTrue(openHousePage.fourPlusBedroom.isDisplayed());
	 openHousePage.fourPlusBedroom.click();
	 System.out.println(driver.getTitle());
	 assertEquals(openHousePage.openHousesText.getText(),"Pittsburgh, PA 4 Bedroom Open Homes");
	
	 }
}
