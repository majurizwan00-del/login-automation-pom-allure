package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.Login;
import pages.Product;
import utils.ConfigReader;

public class ProductTest extends BaseTest {

    @Test
    @Story("Product sort dropdown")
    @Description("Verify that user can sort product from dropdown menu")
    public void AddProduct() {
        {
            Login login = new Login(threadDriver);
            login.login(ConfigReader.get("valid.username"), ConfigReader.get("valid.password")
            );

            Product product = new Product(threadDriver);
            product.selectDropdownValue();
        }
    }}
