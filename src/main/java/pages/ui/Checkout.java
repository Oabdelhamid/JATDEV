package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Checkout extends POM{
    public Checkout(WebDriver driver) {
        super(driver);
    }

    public Checkout ProcceedToCheckout() {
        By checkoutButton = By.xpath("//button[@data-test=\"proceed-2\"]");
        driver.findElement(checkoutButton).click();
        return this;
    }

    public Checkout FillInCheckoutDetails(String Street, String city, String state , String country, String postalCode) {
        By StreetField = By.id("street");
        By cityField = By.id("city");
        By stateField = By.id("state");
        By countryField = By.id("country");
        By postalCodeField = By.id("postal_code");

        driver.findElement(StreetField).clear();
        driver.findElement(StreetField).sendKeys(Street);

        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);

        driver.findElement(stateField).clear();
        driver.findElement(stateField).sendKeys(state);

        driver.findElement(countryField).clear();
        driver.findElement(countryField).sendKeys(country);

        driver.findElement(postalCodeField).clear();
        driver.findElement(postalCodeField).sendKeys(postalCode);

        By checkoutButton3 = By.xpath("//button[@data-test=\"proceed-3\"]");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton3));
        driver.findElement(checkoutButton3).click();


        return this;
    }

    public Checkout SelectPayment() {
        By PaymentList = By.id("payment-method");
        driver.findElement(PaymentList).click();
        By SelectPayment = By.xpath("//option[@value='cash-on-delivery']");
        driver.findElement(SelectPayment).click();
        By finishButton = By.xpath("//button[@data-test='finish']");
        driver.findElement(finishButton).click();

        return this;
    }
}
