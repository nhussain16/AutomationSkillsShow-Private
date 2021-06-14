package com.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignupPage {
	private WebDriver driver;
	private WebElement el;
	private Logger log = Logger.getLogger(SignupPage.class);
	private static String emailDomain = "@abc.com";
	private static String rand;
	private static int timeout = 40;

	// 1. By Locators:
	private By userName = By.id("name");
	private By emailId = By.id("email");
	private By password = By.id("password");
	private By signupGoogle = By.id("kmq-google-button");
	private By signupOffice365 = By.id("kmq-office365-button");
	private By signupTerms = By.xpath("//label[@class='mr-checkbox-1__check' and @for='signup-terms']");
	private By signupSubscribe = By.xpath("//label[@class='mr-checkbox-1__check' and @for='signup-subscribe']");
	private By signupButton = By.xpath("//button[@type='submit' and text()='Get started now']");
	private By acceptAllCookies = By.xpath("//button[text()='Accept All Cookies']");
	private By checkEmailScreen = By.xpath("//h1[text()='Check your email']");
	private By thirdPartySignupTerms = By.xpath("//label[@class='mr-checkbox-1__check' and @for='tos-signup-terms']");
	private By signupSlack = By.xpath("//div[@class='signup__btn signup__social__btn signup__btn--slack']//child::div[@class='signup__btn-icon']");
	private By signupApple = By.xpath("//div[@class='signup__btn-icon']//child::img[@alt='Sign up with Apple']");
	private By signupFacebook = By.xpath("//div[@class='signup__btn-icon']//child::img[@alt='Sign up with Facebook']");
	private By continueToSignUp = By.xpath("//div[text()='Continue to sign up']");
	private By blankFormError = By
			.xpath("//div[@class='signup__error-wrap-login js-empty-password signup__error signup__error-item']");
	private By signupTermsError = By
			.xpath("//div[@class='signup__error-item' and text()='Please agree with the Terms to sign up.']");
	private By passwordError = By
			.xpath("//div[@class='signup__error-wrap-login js-empty-password signup__error signup__error-item']");
	private By emailError = By.xpath(
			"//div[@class='signup__error-item' and text()='This doesn’t look like an email address. Please check it for typos and try again.']");
	private By nameError = By.xpath("//div[@class='signup__error-item' and text()='Please enter your name.']");
	private By showSoSoPasswordhint = By.xpath(
			"//div[@class='signup__input-hint-text signup__input-hint-text--color-soso' and text()='So-so password']");
	private By showMediumPasswordhint = By.xpath(
			"//div[@class='signup__input-hint-text signup__input-hint-text--color-good' and text()='Good password']");
	private By showHighPasswordhint = By.xpath(
			"//div[@class='signup__input-hint-text signup__input-hint-text--color-great' and text()='Great password']");
	private By showLengthPasswordHint = By
			.xpath("//div[@class='signup__input-hint-text' and text()='Please use 8+ characters for secure password']");

	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:
	public void acceptAllCookies() {
		try {
			if (driver.findElement(acceptAllCookies).isDisplayed()) 
				driver.findElement(acceptAllCookies).click();
				waitForPageLoad(timeout);
			
			log.info("Access miro signup page");
			log.info("Accept all cookies button from browser popup");
		} catch (NoSuchElementException e) {
			log.error("All cookies popup screen not appeared", e.fillInStackTrace());
		}
	}

	public String getPageTitle() {
		System.out.println("Getting page title from signup screen");
		return driver.getTitle();
	}

	public void fillSignupFormViaClick() {
		enterUserName();
		enterEmailId();
		enterPassword();
	}

	public void enterUserName() {
		try {
			rand = randomNumberGenerator();
			driver.findElement(userName).sendKeys("user_" + rand);
			log.info("User entered username : user_" + rand);
		} catch (NoSuchElementException e) {
			log.error("Enter name field not appeared", e.fillInStackTrace());
		}
	}

	public void enterEmailId() {
		try {
			rand = randomNumberGenerator();
			driver.findElement(emailId).sendKeys("email_" + rand + emailDomain);
			log.info("User entered email : email_" + rand + emailDomain);
		} catch (NoSuchElementException e) {
			log.error("Enter email field not appeared", e.fillInStackTrace());
		}
	}

	public void enterPassword() {
		try {
			driver.findElement(password).sendKeys("Online!1234");
		} catch (NoSuchElementException e) {
			log.error("Enter name field not appeared", e.fillInStackTrace());
		}
	}

	public void acceptSignupTerms() {
		// click on signup terms and privacy policy checkbox
		try {
			driver.findElement(signupTerms).click();
			log.info("Clicked on accept signup terms checkbox");
		} catch (NoSuchElementException e) {
			log.error("Accept terms checkbox not appeared", e.fillInStackTrace());
		}
	}

	public void acceptSubscription() {
		// click on subscribe news and updates checkbox
		try {
			driver.findElement(signupSubscribe).click();
			log.info("Clicked on accept newsletter subscription checkbox");
		} catch (NoSuchElementException e) {
			log.error("Accept subscription checkbox not appeared", e.fillInStackTrace());
		}
	}

	public void clickOnSignupButton() {
		try {
			driver.findElement(signupButton).click();
			log.info("Clicked on Get started now button");
		} catch (NoSuchElementException e) {
			log.error("Get started now button not appeared", e.fillInStackTrace());
		}
	}

	public boolean isSuccessScreenFound() {
		// redirect to check your email screen
		try {
			waitForPageLoad(timeout);
			return driver.findElement(checkEmailScreen).isDisplayed();
		} catch (NoSuchElementException e) {
			log.error("Check email screen not found", e.fillInStackTrace());
			return false;
		}
	}
	public void clickOnSignupWith(String tool) {
		try {
			switch (tool) {
			case "Google":
				
				waitForElementByLocatorAndClick(signupGoogle);
				el.click();
				break;
			case "Slack":
				waitForElementByLocatorAndClick(signupSlack);
				el.click();
				break;
			case "Office365":
				waitForElementByLocatorAndClick(signupOffice365);
				el.click();
				break;
			case "Apple":
				waitForElementByLocatorAndClick(signupApple);
				el.click();
				break;
			case "Facebook":
				waitForElementByLocatorAndClick(signupFacebook);
				el.click();
				break;
			default:
				System.out.println("Sign up with tool : " + tool + " is invalid");
			}
		} catch (Exception e) {
			System.out.println("Exception handled: " + e);
		}
	}

	public void agreeSignupTermsWithThirdParty() {
		waitForElementByLocatorAndClick(thirdPartySignupTerms);
		log.info("Clicked on signup terms with third party account");
	}

	public void continueToSignupWithThirdParty() {
		waitForPageLoad(timeout);
		waitForElementByLocatorAndClick(continueToSignUp);
		log.info("Clicked on continue to signup button with third party account");
	}

	// negative tests started
	public void enterPossibleCombinations(String name, String email, String pwd, String terms) {
		// check for name value pass from outline scenario from feature file
		try {
			switch (name) {
			case "validUser":
				enterUserName();
			case "emptyUsername":
				driver.findElement(userName).sendKeys("");
				break;
			default:
				System.out.println("Name field looks empty : " + name);
			}
			// check for email value pass from outline scenario from feature file
			switch (email) {
			case "validEmail":
				enterEmailId();
				break;
			case "invalidEmail":
				driver.findElement(emailId).sendKeys("@.");
				break;
			default:
				System.out.println("Email field looks empty : " + email);
			}
			// check for password value pass from outline scenario from feature file
			switch (pwd) {
			case "validPassword":
				driver.findElement(password).sendKeys("Online!1234");
				break;
			case "emptyPassword":
				driver.findElement(password).sendKeys("");
				break;
			default:
				System.out.println("Password field have unexpected value : " + pwd);
			}
			// check for signup terms value pass from outline scenario from feature file
			switch (terms) {
			case "tick":
				driver.findElement(signupTerms).click();
				break;
			default:
				System.out.println("Signup field is : " + terms);
			}
			// submit form to hit validation error
			driver.findElement(signupButton).click();
		} catch (Exception e) {
			log.error("Something went wrong on entering data in signup form...", e.fillInStackTrace());
		}
	}

	public void submitBlankForm() {
		// submit blank form
		try {
			driver.findElement(signupButton).click();
		} catch (NoSuchElementException e) {
			log.error("Get started now button on signup form not appeared", e.fillInStackTrace());
		}
	}

	public void enterPasswordStrength(String pwd) {
		// enter password with different strength
		try {
			switch (pwd) {
			case "low":
				driver.findElement(password).sendKeys("12345678");
				break;
			case "medium":
				driver.findElement(password).sendKeys("Online!1234");
				break;
			case "high":
				driver.findElement(password).sendKeys("Online!1234,.");
				break;
			default:
				System.out.println("Password hint not having correct value: " + pwd);
			}
		} catch (Exception e) {
			log.error("Something went wrong on showing password hint in signup form...", e.fillInStackTrace());
		}
	}

	public void enterIncorrectPasswordLength() {
		try {
			driver.findElement(password).sendKeys("Online");
		} catch (NoSuchElementException e) {
			log.error("Validation error on incorrect password not appeared", e.fillInStackTrace());
		}
	}

	public String showValidationError() {
		try {
			System.out.println("Getting validation error on submitting blank signup form");
			return driver.findElement(blankFormError).getText();
		} catch (NoSuchElementException e) {
			log.error("Validation error on blank form not appeared", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showSignupTermsValidationError() {
		try {
			System.out.println("Getting signup error on terms in signup form");
			return driver.findElement(signupTermsError).getText();
		} catch (NoSuchElementException e) {
			log.error("Signup validation error not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showPasswordValidationError() {
		try {
			System.out.println("Getting password error on submitting signup form");
			return driver.findElement(passwordError).getText();
		} catch (NoSuchElementException e) {
			log.error("Password validation error not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showInvalidEmailValidationError() {
		try {
			System.out.println("Getting email error on submitting signup form");
			return driver.findElement(emailError).getText();
		} catch (NoSuchElementException e) {
			log.error("Email validation error not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showNameValidationError() {
		try {
			System.out.println("Getting empty name error on submitting signup form");
			return driver.findElement(nameError).getText();
		} catch (NoSuchElementException e) {
			log.error("Name validation error not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showLowPasswordStrengthHint() {
		try {
			System.out.println("Getting hint on password strength");
			return driver.findElement(showSoSoPasswordhint).getText();
		} catch (NoSuchElementException e) {
			log.error("Low password strength not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showMediumPasswordStrengthHint() {
		try {
			System.out.println("Getting hint on password strength");
			return driver.findElement(showMediumPasswordhint).getText();
		} catch (NoSuchElementException e) {
			log.error("Medium password strength not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showHighPasswordStrengthHint() {
		try {
			System.out.println("Getting hint on password strength");
			return driver.findElement(showHighPasswordhint).getText();
		} catch (NoSuchElementException e) {
			log.error("High password strength not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}

	public String showPasswordLengthHint() {
		try {
			System.out.println("Getting hint on password length");
			return driver.findElement(showLengthPasswordHint).getText();
		} catch (NoSuchElementException e) {
			log.error("Password length validation not appeared on screen", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}
	
	public void scrollDownPageToEnd() {
		// Press End button
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.END).build().perform();
	}

	public void waitForElementByLocatorAndClick(By elementLocator) {
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		el = driver.findElement(elementLocator);
		Actions act = new Actions(driver);
		act.moveToElement(el).click().build().perform();
	}

	public void waitForPageLoad(int seconds) {
		// Initialize and wait till element(link) became clickable - timeout in seconds
		driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}

	public String randomNumberGenerator() {
		try {
			String[] alphanumeric = "01234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
			String randomNumber = "";
			for (int i = 0; i < 10; i++)
				randomNumber += alphanumeric[(int) Math.floor(Math.random() * alphanumeric.length)];
			return randomNumber;
		} catch (Exception e) {
			log.error("Random number generator seems not worked correctly", e.fillInStackTrace());
			return "Something went wrong...";
		}
	}
}