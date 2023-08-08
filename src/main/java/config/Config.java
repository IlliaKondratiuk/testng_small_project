package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config {
    static WebDriver driv;
    static public WebDriver create(Drivers driver) {

        switch (driver) {
            case CHROME -> createchrome();
            case CHROME_INC -> createchromeinc();
            case BONIGARCIA -> createdriverBoni();
        }

        return driv;
    }

    private static void createdriverBoni() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        driv = WebDriverManager.chromedriver().capabilities(options).create();
    }

    private static void createchromeinc() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        driv = new ChromeDriver(options);
    }

    private static void createchrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driv = new ChromeDriver(options);
    }
}
