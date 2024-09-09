package tests.day14_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_TumSayfaScreenshot extends TestBase {

    @Test
    public void aramaTesti() {

        // testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // doğru sayfaya gittiğinizi test edin,
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // screenshot alın
        ReusableMethods.tumSayfaScreenshot(driver);

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda ürün bulunabildiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(unExpectedSonucYazisi, actualSonucYazisi);

        // screenshot alın
        ReusableMethods.tumSayfaScreenshot(driver, "Arama sonucu screenshot");

        ReusableMethods.bekle(2);

    }
}
