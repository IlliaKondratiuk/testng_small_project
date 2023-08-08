package tests;

import config.TestNGBase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CertificatePageObject;
import pages.MainPageObject;

import java.util.Objects;


public class Test1 extends TestNGBase {

    private static MainPageObject main;
    private static CertificatePageObject certificate;

    String certificatePageURL = "https://certificate.ithillel.ua/";

    @DataProvider
    public static Object[][] certificateProvider() {
        return new Object[][] {
                {"20669327", true},
                {"11111111", false},
                {"22222222", false}
        };
    }


    @BeforeTest
    public void beforetest () {
        initialize();
        driver.get("https://ithillel.ua/");
        main = new MainPageObject(driver);
    }

    @Test(testName = "Class button presence check")
    public void testClassButton (){
        Assert.assertTrue(main.isCoursesButtonPresent());
    }

    @Test(testName = "School button presence check")
    public void testSchoolButton () {
        Assert.assertTrue(main.isSchoolButtonPresent());
    }

    @Test(testName = "Redirect to certificate page check", dependsOnMethods = "testSchoolButton")
    public void testOpenTheCertCheckPage() {
        main.clickSchoolButton();
        main.clickCertCheckInSchoolDropdown();
        certificate = new CertificatePageObject(driver);
    }

    @Test(dataProvider = "certificateProvider")
    public void checkCertificates(String certificateNumber, boolean isValid) throws InterruptedException {
        Thread.sleep(2000); //just to display the newly opened page

        certificate.enterCertificate(certificateNumber);
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl().contains(certificateNumber), isValid);
            if (!Objects.equals(driver.getCurrentUrl(), certificatePageURL)) {
                driver.get(certificatePageURL);
            }
    }




}