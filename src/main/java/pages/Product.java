package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

import java.util.List;

public class Product {

    WebDriver driver;
    WaitUtils wait;

    private By sortDropdown = By.xpath("//select[@data-test='product-sort-container']");

    public Product(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 5);
    }
    @Step("Select dropdown value")
    public void selectDropdownValue() {

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByIndex(0);

        /* We can use this approach as well.
          List<WebElemees = selectnt> valu.getOptions();
          int allValues = values.size();

        for (int i = 0; i < allValues; i++) {

            WebElement dropdown = wait.waitForClick(sortDropdown);
            select = new Select(dropdown);
            String Text = select.getOptions().get(i).getText();
            System.out.println("Text Values: " + Text);
            select.selectByIndex(i);
        }
        */
    }
}
