package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import utils.ConfigReader;
import utils.LoginData;

public class LoginTest extends BaseTest {

    @Feature("Login")
    @Test(priority = 1)
    @Story("Login with valid credentials")
    @Description("Verify that user can login successfully with valid credentials")
    public void SuccessfulLogin() {

        Login login = new Login(threadDriver);
        login.login(ConfigReader.get("valid.username"), ConfigReader.get("valid.password")
        );

        Assert.assertTrue(threadDriver.getTitle().contains("Swag Labs"),
                "Login failed, Incorrect page title");

    }

    @Test(dataProvider = "invalidLoginData", priority = 2, dataProviderClass = LoginData.class)
    @Story("login with Invalid credentials")
    @Description("Verify that error message is displayed for Invalid")
    public void NegativeLogin(
            String username,
            String password,
            String ErrorMessage) {

        Login login = new Login(threadDriver);

        login.login(username, password);
        Assert.assertEquals(
                login.getMessage(),
                ErrorMessage,
                "Error message mismatch"
        );
    }
}
