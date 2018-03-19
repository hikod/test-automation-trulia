package com.trulia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='text']")
	public WebElement searchBar;
	
	@FindBy(xpath="//button[@class='css-ejw4np btn btnPrimary']")
	public WebElement searchButton;
	
}
