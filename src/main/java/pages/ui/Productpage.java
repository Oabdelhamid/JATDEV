package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Productpage extends POM {

    public Productpage(WebDriver driver) {
        super(driver);
    }

    public Productpage WaitForProductPageToLoad() {
        By productTitle = By.xpath("//h1[@data-test=\"product-name\"]");
        wait.until(driver -> driver.findElement(productTitle).isDisplayed());
        return this;
    }

    public Productpage IncreaseQuantityTo() {
        By quantityField = By.xpath("//button[@data-test='increase-quantity']");
        driver.findElement(quantityField).click();
        return this;
    }

    public Productpage AddToCart() {
        By addToCartButton = By.id("btn-add-to-cart");
        driver.findElement(addToCartButton).click();
        By ToastMessage = By.xpath("//div[contains(@class,\"toast-message\")]");
        wait.until(driver -> driver.findElement(ToastMessage).isDisplayed());
        driver.findElement(ToastMessage).click();
        return this;
    }

    public Productpage GoToCart() {
        By cartButton = By.xpath("//a[@data-test=\"nav-cart\"]");
        driver.findElement(cartButton).click();
        By CheckoutButton = By.xpath("//button[@data-test=\"proceed-1\"]");
        wait.until(driver -> driver.findElement(CheckoutButton).isDisplayed());
        driver.findElement(CheckoutButton).click();

        return this;
    }
}
