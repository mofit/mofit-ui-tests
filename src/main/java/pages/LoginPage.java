package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

import static utils.Browser.getDriver;

public class LoginPage {

    private final Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(), 'Sign Up')]")
    private WebElement signupButton;

    @FindBy(className = "alert-danger")
    private WebElement errorMessage;

    @FindBy(id = "passwordEye")
    private WebElement passwordEye;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void enterEmailAndPassword(final String username, final String password) {
        logger.info("Login as " + username);
        Browser.writeText(emailField, username);
        Browser.writeText(passwordField, password);
    }

    public String getPasswordFieldText() {
        final String currentPassword = Browser.getElementText(passwordField);
        logger.info("Currently entered password" + currentPassword);
        return currentPassword;
    }

    public void showPassword() {
        logger.info("Showing current password");
        Browser.clickElement(passwordEye);
    }

    public HomePage login() {
        Browser.clickElement(loginButton);
        return new HomePage();
    }

    public SignupPage clickSignupButton() {
        Browser.clickElement(signupButton);
        return new SignupPage();
    }

    public String getErrorMessage() {
        return Browser.getElementText(errorMessage);
    }
}
