package UI;

import org.openqa.selenium.WebDriver ;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.TestDataReader;

import java.io.IOException;
import java.util.Map;

public class baseClass {
    WebDriver driver ;
    ChromeOptions options;
    protected Map<String, String> data;

    @BeforeClass
    public void setup() throws IOException {

        options = new ChromeOptions();
        options.addArguments("--start-maximized")
                .addArguments("--disable-notifications")
                .addArguments("--disable-popup-blocking")
                .enableBiDi();
        driver = new ChromeDriver(options);
        String jsonFilePath = "src/test/resources/TestData/testDataFile.json" ;
        data = TestDataReader.getTestData(jsonFilePath);



    }


    @AfterClass
    public void teardown(){
      // driver.quit();

    }
}
