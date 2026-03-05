package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import utils.WaitUtils;

public class Login {

    public WebDriver driver;
    WaitUtils wait;

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//input[@id='login-button']");
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 5);
    }

    @Step("Enter Username")
    public void enterUserName(String username) {
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(username);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        wait.waitForVisible(passwordField).sendKeys(password);
    }

    @Step("Click Login")
    public void clickLogin() {
        wait.waitForClick(loginButton).click();
    }

    @Step("Login action with username & password")
    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Error Message")
    public String getMessage() {
        return driver.findElement(errorMessage).getText();
    }

}
