package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_DosyaYuklemeTesti extends TestBase {

    @Test
    public void dosyaYuklemeTesti() {

        // Users\DELL\Desktop\reklam.png"

        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // chooesFile butonuna basalım
        /*
            Selenium WebDriver ile çalışır ve WebSayfalarında istenen görevleri yapar
            Ancak kendi bilgisayarımızdaki dosya yapısı içerisinde
            dosya seçmek için click YAPAMAZ

            1- upload yapacağımız dosyanın, dosya yolunu kaydedin
            2- upload yapacağımız sitedeki chooseFile butonunu locate edip kaydedin
            3- chooseFileButonElementi.sendKeys(yuklenecekDosyaninDosyaYolu)

         */

        // Yuklemek istediğiniz dosyayı seçelim


        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu = System.getProperty("user.home") + "Desktop\\reklam.png";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        // Upload butonuna basalım
        ReusableMethods.bekle(2);
        driver.findElement(By.id("file-submit"))
                .click();
        ReusableMethods.bekle(2);

        // "File Uploaded!" textinin görüntülendiğini test edelim.

        WebElement dosyaYuklendiYazisi = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(dosyaYuklendiYazisi.isDisplayed());

        ReusableMethods.bekle(5);

    }
}
