package UI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ui.Checkout;
import pages.ui.LoginPage;
import pages.ui.Productpage;
import pages.ui.homepage;


public class JatDevTest extends baseClass {

    @Test
    public void UserLogin () {
        new LoginPage(driver)
                .navigateToLoginPage().ValidLogin(data.get("email"),data.get("password"))
                .WaitForLoginPageToLoad();

    }

    @Test(dependsOnMethods = {"UserLogin"})
    public void GoToHomepage() {
     new homepage(driver)
             .navigateToHomePage().
             WaitForHomePageToLoad()
             .SelectFirstProduct();
    }

    @Test (dependsOnMethods = {"UserLogin","GoToHomepage"})
    public void gotoProductPage() {
        new Productpage(driver)
                .WaitForProductPageToLoad()
                .IncreaseQuantityTo()
                .AddToCart()
                .GoToCart();
    }

    @Test (dependsOnMethods = {"UserLogin","GoToHomepage","gotoProductPage"})
    public void Checkout() {
        new Checkout(driver)
                .ProcceedToCheckout()
                .FillInCheckoutDetails(data.get("street"),data.get("city"),data.get("state"),data.get("country"),data.get("postalCode"))
                .SelectPayment();




    }




}
