package stepDefinitions;

import org.junit.Assert;

import com.pages.SignupPage;
import com.qa.util.DriverFactory;

import io.cucumber.java.en.*;

public class SignupTestSteps {

	private SignupPage signupPage = new SignupPage(DriverFactory.getDriver());
	private String emptyFormError = "Please enter your password.";
	private String passwordError = "Please enter your password.";
	private String signupTermsError = "Please agree with the Terms to sign up.";
	private String invalidEmailError = "This doesn’t look like an email address. Please check it for typos and try again.";
	private String emptyNameError = "Please enter your name.";
	private String soSoPwd = "So-so password";
	private String goodPwd = "Good password";
	private String greatPwd = "Great password";
	private String pwdLengthError = "Please use 8+ characters for secure password";
	private int timeout = 30;

	@Given("I access miro signup page")
	public void i_access_miro_signup_page() {
		// access sign up page
		DriverFactory.getDriver().get("https://miro.com/signup/");
		signupPage.acceptAllCookies();
	}

	@When("I enter valid username,email,password")
	public void i_enter_valid_username_email_password() {
		signupPage.fillSignupFormViaClick();
	}

	@When("tick terms and privacy policy checkbox")
	public void tick_terms_and_privacy_policy_checkbox() {
		signupPage.acceptSignupTerms();
	}

	@When("click on button to submit the form")
	public void click_on_button_to_submit_the_form() {
		signupPage.clickOnSignupButton();
	}

	@Then("check your email screen should display")
	public void check_your_email_screen_should_display() {
		Assert.assertTrue("Check email element not found", signupPage.isSuccessScreenFound());
	}

	@When("tick checkbox to receive news and updates")
	public void tick_checkbox_to_receive_news_and_updates() {
		signupPage.acceptSubscription();
	}

	@When("I click on Sign up with {string} button")
	public void SignupWithThirdPartyTool(String tool) {
		signupPage.scrollDownPageToEnd();
		signupPage.clickOnSignupWith(tool);
	}

	@When("tick terms and privacy policy checkbox from popup")
	public void tickSignupTermsSignup() {
		signupPage.agreeSignupTermsWithThirdParty();
	}

	@When("click on continue to signup button")
	public void clickOnContinueToSignup() {
		signupPage.continueToSignupWithThirdParty();
	}

	@Then("Google login screen should display")
	public void displayGoogleLoginScreen() {
		signupPage.waitForPageLoad(timeout);
		Assert.assertEquals("Sign in – Google accounts", signupPage.getPageTitle());
	}

	@Then("Slack login screen should display")
	public void displaySlackLoginScreen() {
		signupPage.waitForPageLoad(timeout);
		Assert.assertEquals("Sign in | Slack", signupPage.getPageTitle());
	}

	@Then("Office365 login screen should display")
	public void displayOffice365LoginScreen() {
		signupPage.waitForPageLoad(timeout);
		Assert.assertEquals("Sign in to your account", signupPage.getPageTitle());
	}

	@Then("Apple login screen should display")
	public void displayAppleLoginScreen() {
		signupPage.waitForPageLoad(timeout);
		Assert.assertEquals("Sign in with Apple ID", signupPage.getPageTitle());
	}

	@Then("Facebook login screen should display")
	public void displayFacebookLoginScreen() {
		signupPage.waitForPageLoad(timeout);
		Assert.assertEquals("Log in to Facebook | Facebook", signupPage.getPageTitle());
	}

	// Negative scenarios started
	@When("I click on signup button in blank form")
	public void i_click_on_signup_button_in_blank_form() {
		signupPage.submitBlankForm();
	}

	@Then("password validation error message should display")
	public void showValidationErrorForEmptyForm() {
		String msg = signupPage.showValidationError();
		Assert.assertEquals(emptyFormError, msg);
	}

	@When("I enter combination of invalid {string}, {string}, {string} and {string}")
	public void i_enter_combination_of_invalid(String name, String email, String password, String terms) {
		signupPage.enterPossibleCombinations(name, email, password, terms);
	}

	@Then("validation message should display according to {int}")
	public void validation_message_should_display(int test) {
		String msg;
		switch (test) {
		case 1:
			msg = signupPage.showSignupTermsValidationError();
			Assert.assertEquals(signupTermsError, msg);
			break;
		case 2:
			msg = signupPage.showPasswordValidationError();
			Assert.assertEquals(passwordError, msg);
			break;
		case 3:
			msg = signupPage.showInvalidEmailValidationError();
			Assert.assertEquals(invalidEmailError, msg);
			break;
		case 4:
			msg = signupPage.showNameValidationError();
			Assert.assertEquals(emptyNameError, msg);
			break;
		default:
			System.out.println("Incorrect test number found : " + test);
		}
	}

	@When("I enter low Password Strength")
	public void enter_low_Password_Strength() {
		signupPage.enterPasswordStrength("low");
	}

	@When("I enter password strength from low to medium")
	public void enter_medium_Password_Strength() {
		signupPage.enterPasswordStrength("medium");
	}

	@When("I enter password strength from medium to high")
	public void enter_high_Password_Strength() {
		signupPage.enterPasswordStrength("high");
	}

	@Then("password hint should indicate {string}")
	public void password_hint_should_indicate_(String pwdStrength) {
		String msg;
		switch (pwdStrength) {
		case "So-so password":
			msg = signupPage.showLowPasswordStrengthHint();
			Assert.assertEquals(soSoPwd, msg);
			break;
		case "Good password":
			msg = signupPage.showMediumPasswordStrengthHint();
			Assert.assertEquals(goodPwd, msg);
			break;
		case "Great password":
			msg = signupPage.showHighPasswordStrengthHint();
			Assert.assertEquals(greatPwd, msg);
			break;
		default:
			System.out.println("Incorrect password strength found : " + pwdStrength);
		}
	}

	@When("I enter incorrect password length")
	public void enter_incorrect_Password_Length() {
		signupPage.enterIncorrectPasswordLength();
	}

	@Then("password hint should indicate length to be used")
	public void password_hint_should_indicate_Length() {
		String msg;
		msg = signupPage.showPasswordLengthHint();
		Assert.assertEquals(pwdLengthError, msg);
	}
}