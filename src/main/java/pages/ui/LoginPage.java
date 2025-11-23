package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends POM {


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public LoginPage navigateToLoginPage() {
        driver.navigate().to("https://practicesoftwaretesting.com/auth/login");
        return this;
    }

    public LoginPage ValidLogin(String email, String password) {

         By mail = By.id("email");
        driver.findElement(mail).sendKeys(email);
         By pass = By.id("password");
        driver.findElement(pass).sendKeys(password);
         By loginButton = By.className("btnSubmit");
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage WaitForLoginPageToLoad() {
        By Title = By.xpath("//h1[@data-test=\"page-title\"]");
        wait.until(driver -> driver.findElement(Title).isDisplayed());
        return this;
    }
}
