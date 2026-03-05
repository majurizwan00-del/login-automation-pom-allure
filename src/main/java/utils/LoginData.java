package utils;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLogin() {
        return new Object[][]{

                {"testuser", "wrongPass1", "Epic sadface: Username and password do not match any user in this service"},
                {"", "Password123", "Epic sadface: Username is required"},
                {"testuser", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"}
        };
    }
}
