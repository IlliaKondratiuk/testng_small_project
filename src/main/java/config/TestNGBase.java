package config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestNGBase {

    public static WebDriver driver;

    public static void initialize(){
        driver = Config.create(Drivers.CHROME);
    }

    @AfterClass
    public static void base_after(){
        driver.quit();
    }

}