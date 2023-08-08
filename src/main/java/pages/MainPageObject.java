package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject {

    public static WebDriver driv;

    By coursesButton = By.xpath("//button[contains(@data-dropdown-trigger, 'coursesMenu')]");
    By schoolButton = By.xpath("//button[contains(@data-dropdown-trigger, 'aboutSchool')]");
    By CertCheckInSchoolDropdown = By.xpath("//ul[contains(@data-dropdown-menu, \"aboutSchool\")]" +
            "//a[contains(@class, \"-certificate\")]");


    public MainPageObject(WebDriver driv) {
        this.driv = driv;
    }

    public boolean isCoursesButtonPresent() {

        try {
            driv.findElement(coursesButton);
        } catch (Exception ignore) {
            return false;
        }

        return true;
    }


    public boolean isSchoolButtonPresent() {
        try {
            driv.findElement(schoolButton);
        } catch (Exception ignore) {
            return false;
        }

        return true;
    }

    public void clickSchoolButton() {
        driv.findElement(schoolButton).click();
    }

    public void clickCertCheckInSchoolDropdown() {
        driv.findElement(CertCheckInSchoolDropdown).click();
    }
}
