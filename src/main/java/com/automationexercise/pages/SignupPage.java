package com.automationexercise.pages;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    private WebDriver driver;

    // Locators
    private By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
	private By genderMr = By.id("id_gender1");
	private By passwordInput = By.id("password");
	private By dayDropdown = By.id("days");
	private By monthDropdown = By.id("months");
	private By yearDropdown = By.id("years");
	private By firstNameInput = By.id("first_name");
	private By lastNameInput = By.id("last_name");
	private By addressInput = By.id("address1");
	private By countryDropdown = By.id("country");
	private By stateInput = By.id("state");
	private By cityInput = By.id("city");
	private By zipcodeInput = By.id("zipcode");
	private By mobileInput = By.id("mobile_number");
	private By createAccountButton = By.xpath("//button[@data-qa='create-account']");


    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openSignupPage() {
        driver.get("https://automationexercise.com/login");
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

	public void selectGender() {
	    driver.findElement(genderMr).click();
	}
	
	public void enterPassword(String password) {
	    driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void selectDateOfBirth(String day, String month, String year) {
	    new Select(driver.findElement(dayDropdown)).selectByValue(day);
	    new Select(driver.findElement(monthDropdown)).selectByValue(month);
	    new Select(driver.findElement(yearDropdown)).selectByValue(year);
	}
	
	public void enterFirstName(String firstName) {
	    driver.findElement(firstNameInput).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
	    driver.findElement(lastNameInput).sendKeys(lastName);
	}

	public void enterAddress(String address) {
	    driver.findElement(addressInput).sendKeys(address);
	}
	
	public void selectCountry(String country) {
	    new Select(driver.findElement(countryDropdown))
	            .selectByVisibleText(country);
	}
	
	public void enterState(String state) {
	    driver.findElement(stateInput).sendKeys(state);
	}
	
	public void enterCity(String city) {
	    driver.findElement(cityInput).sendKeys(city);
	}
	
	public void enterZipcode(String zipcode) {
	    driver.findElement(zipcodeInput).sendKeys(zipcode);
	}
	
	public void enterMobileNumber(String mobile) {
	    driver.findElement(mobileInput).sendKeys(mobile);
	}
	
	public void clickCreateAccount() {
	    driver.findElement(createAccountButton).click();
	    	    
}

}
