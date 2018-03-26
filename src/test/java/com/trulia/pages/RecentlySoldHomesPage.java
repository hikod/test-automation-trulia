package com.trulia.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trulia.utilities.Driver;

public class RecentlySoldHomesPage {
	private WebDriver driver;

	public RecentlySoldHomesPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='h3']")
	public WebElement recentlySoldHousesText;

	@FindBy(xpath = "//*[@id=\'srpHeaderLeftColumn\']/div/div[1]/div/h1")
	public WebElement recentlySoldHomes;

	@FindBy(xpath = "//*[@id=\'locationInputs\']")
	public WebElement searchBox;
	@FindBy(id = "bedroomsToggle")
	public WebElement allBedsDropDown;

	@FindBy(xpath = "(//button[contains(text(),'3+')])[1]")
	public WebElement threePlusBedroom;

	@FindBy(xpath = "//li[@class='xsCol12Landscape smlCol12 lrgCol8']//li[@data-auto-test='beds']")
	public List<WebElement> threePlusBedroomsList;
	// Aslan's locators

	@FindBy(xpath = "//li[@class='xsCol12Landscape smlCol12 lrgCol8']//b")
	public List<WebElement> soldTextFromHomesListings;

	@FindBy(xpath = "//li[@class='xsCol12Landscape smlCol12 lrgCol8']//div[3]/a")
	public List<WebElement> soldDate;

	public boolean allSoldHomesAreListedByDate(List<WebElement> list) {
		boolean validator = true;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		List<LocalDate> dates = new ArrayList<>();
		List<LocalDate> tempdates = new ArrayList<>();

		for (WebElement elem : list) {

			dates.add(LocalDate.parse(elem.getText().substring(8), formatter));
			tempdates.add(LocalDate.parse(elem.getText().substring(8), formatter));
		}
		Collections.sort(dates, Collections.reverseOrder());
		for (int i = 0; i < dates.size(); i++) {
			System.out.println(dates.get(i) + "\n" + tempdates.get(i) + "\n");

			if (dates.get(i).compareTo(tempdates.get(i)) != 0) {

				validator = false;
			}
		}

		return validator;
	}

	public boolean allHomesAreSold(List<WebElement> list) {
		boolean validator = true;
		for (WebElement elem : list) {

			if (!elem.getText().equals("SOLD")) {
				validator = false;
			}
		}
		return validator;
	}

	public boolean housesSoldThreePlusBedrooms(List<WebElement> list) {
		boolean validator = true;
		for (WebElement webElement : list) {
			System.out.println(webElement.getText().substring(0, 1));
			if (Integer.parseInt(webElement.getText().substring(0, 1)) < 3)
				validator = false;
		}
		return validator;
	}

}
