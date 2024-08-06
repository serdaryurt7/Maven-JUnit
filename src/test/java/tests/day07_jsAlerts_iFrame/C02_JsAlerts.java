package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_JsAlerts extends TestBase {


    @Test
    public void birinciAlertTesti() {

        // 1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        // - 1. alert'e tıklayın
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        ReusableMethods.bekle(1);
        // - Alert'deki yazının "I am a JS Alert" olduğunu test edin
        String actualAlertYazi = driver.switchTo().alert().getText();
        String expectedAlertYazi = "I am a JS Alert";

        Assert.assertEquals(expectedAlertYazi, actualAlertYazi);

        // OK tuşuna basıp alert'i kapatın
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);
    }

    @Test
    public void ikinciAlertTesti() {
        // 2. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        // - 2.alert'e tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        ReusableMethods.bekle(1);
        // - Cancel'a basıp, çıkan sonuç yazısının "You clicked: Cancel" olduğunu test edin
        driver.switchTo().alert().dismiss();
        ReusableMethods.bekle(1);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);

    }

    @Test
    public void ucuncuAlertTesti() {

        // 3. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        ReusableMethods.bekle(1);
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 3.alert'e tıklayalım
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        ReusableMethods.bekle(1);
        // - Çıkan prompt ekranına "Abdullah" yazdıralım
        driver.switchTo().alert().sendKeys("Serdar");
        ReusableMethods.bekle(10);
        // - OK tuşuna basarak alert'i kapatalım
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);
        // - Çıkan sonuç yazısının Abdullah içerdiğini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));

        String expectedSonucYazisi = "Serdar";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

        // 1:58

    }

}
