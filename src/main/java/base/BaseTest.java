package base;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.Product;
import utils.ConfigReader;

import java.io.IOException;

@Listeners({AllureTestNg.class})

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver threadDriver;

    public Login login;
    public Product product;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional String browser) throws IOException {

        ConfigReader.loadConfig();

        String url = ConfigReader.get("url");
        String browsers = ConfigReader.get("browser");

        if (browser == null) {
            browser = browsers;
        }

        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        }  else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        }

        threadDriver = driver.get();

        threadDriver.manage().window().maximize();
        threadDriver.get(url);
        login = new Login(threadDriver);
        product = new Product(threadDriver);

        //  login = new Login(threadDriver);
        //  product = login.login("standard_user", "secret_sauce");
    }

    @AfterMethod
    public void quit() {
        driver.get().quit();
    }
}
