package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CertificatePageObject {

    WebDriver driv;

    By certificateNumberField = By.name("certificate");
    By submitCertificateButton = By.xpath("//button[contains(@class, 'certificate-check_submit')]");

    public CertificatePageObject(WebDriver driv) {
        this.driv = driv;
    }


    public void enterCertificate(String number) {
        driv.findElement(certificateNumberField).sendKeys(number);
        driv.findElement(submitCertificateButton).click();
    }


}