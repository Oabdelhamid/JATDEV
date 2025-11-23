package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage extends POM{


    public homepage(WebDriver driver) {
        super(driver);

    }

    public homepage navigateToHomePage() {
        By HomePage = By.xpath("//a[@data-test=\"nav-home\"]");
        driver.findElement(HomePage).click();
        return this;

    }

    public homepage WaitForHomePageToLoad() {
        By Searchbar = By.id("search-query");
        wait.until(driver -> driver.findElement(Searchbar).isDisplayed());
        return this;
    }

        public homepage SelectFirstProduct() {
           By selectedProduct = By.cssSelector("div.col-md-9 > div.container > a:first-child");
            wait.until(driver -> driver.findElement(selectedProduct).isDisplayed());
            driver.findElement(selectedProduct).click();
        return this;
    }
}
