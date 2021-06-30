 Feature: Miro User Registration
	In order to collaborate to global teams
	As a Teamplayer
	I want to be able to register to miro
    
  @Positive_Test
  Scenario: Register to miro successfully with mandatory fields
    Given I access miro signup page
    When I enter valid username,email,password
    And tick terms and privacy policy checkbox
    And click on button to submit the form
    Then check your email screen should display

  @Positive_Test
  Scenario: Register to miro successfully with all the fields filled in
    Given I access miro signup page
    When I enter valid username,email,password
    And tick terms and privacy policy checkbox
    And tick checkbox to receive news and updates
    And click on button to submit the form
    Then check your email screen should display

  @Positive_Test
  Scenario: Register to miro successfully by selecting terms via google sign up
    Given I access miro signup page
    When I click on Sign up with 'Google' button
    And tick terms and privacy policy checkbox from popup
    And click on continue to signup button
    Then Google login screen should display

  @Positive_Test
	Scenario: Register to miro successfully by selecting terms via slack sign up
    Given I access miro signup page
    When I click on Sign up with 'Slack' button
    And tick terms and privacy policy checkbox from popup
    And click on continue to signup button
    Then Slack login screen should display

  @Positive_Test
	Scenario: Register to miro successfully by selecting terms via office365 sign up
    Given I access miro signup page
    When I click on Sign up with 'Office365' button
    And tick terms and privacy policy checkbox from popup
    And click on continue to signup button
    Then Office365 login screen should display
    
  @Positive_Test
	Scenario: Register to miro successfully by selecting terms via apple sign up
    Given I access miro signup page
    When I click on Sign up with 'Apple' button
    And tick terms and privacy policy checkbox from popup
    And click on continue to signup button
    Then Apple login screen should display
    
  @Positive_Test
	Scenario: Register to miro successfully by selecting terms via facebook sign up
    Given I access miro signup page
    When I click on Sign up with 'Facebook' button
    And tick terms and privacy policy checkbox from popup
    And click on continue to signup button
    Then Facebook login screen should display
    
  @Negative_Test
	Scenario: Show validation error on submitting blank signup form
    Given I access miro signup page
    When I click on signup button in blank form
    Then password validation error message should display

  @Negative_Test
    Scenario Outline: Try to register with incorrect mandatory fields via possible combinations
		Given I access miro signup page
    When I enter combination of invalid "<Name>", "<email>", "<password>" and "<terms>"
    Then validation message should display according to <test>

    Examples: 
      |test	| Name		      | email					|	password				|	terms		|
      |	1		|	validUser			| validEmail		|	validPassword		|	untick	|
      |	2		|	validUser			| validEmail		|	emptyPassword		| tick		|
      |	3		|	validUser			| invalidEmail	|	validPassword		|	tick		|
      |	4		| emptyUsername	| validEmail		|	validPassword		|	tick		|
      
  @Negative_Test
	Scenario: Show password hint based on password strength
		Given I access miro signup page
    When I enter low Password Strength
    Then password hint should indicate "So-so password"

  @Negative_Test
	Scenario: Show password hint based on password strength
		Given I access miro signup page
    When I enter password strength from low to medium
    Then password hint should indicate "Good password"

  @Negative_Test
	Scenario: Show password hint based on password strength
		Given I access miro signup page
  	When I enter password strength from medium to high
    Then password hint should indicate "Great password"      

	@Negative_Test1
	Scenario: Show hint for incorrect password length
		Given I access miro signup page
  	When I enter incorrect password length
    Then password hint should indicate length to be used  