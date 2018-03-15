package com.trulia.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.trulia.pages.HomePage;
import com.trulia.utilities.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void homePageTitle() {
		// create object from Page class:
		HomePage homePage = new HomePage(driver);
		// verify at page
		assertTrue(homePage.isAt());

	}
}
