package tests.day13_ExcelOtomasyon;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshot extends TestBase {

    @Test
    public void aramaTest() throws IOException {

        // Testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // Nutella için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonucunda ürün bulunamadığını test edin

        WebElement aramaSonucuElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucuElementi.getText();

        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);

        ReusableMethods.bekle(1);

        // Testlerimiz sırasında istersek tüm sayfanın, istersek de bir web elementin görüntüsünü kaydedebiliriz

        // Eğer tüm sayfa screenshot almak isterseniz

        // 1- bir TakesScreenShot objesi oluşturun ve değer olarak driver'i atayın

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- screenshot'i kaydedeceğimiz bir dosya oluşturalım

        File tumSayfaScreenshot = new File("target/tumSayfaScreenshot/tss.jpeg");

        // 3- tss objesini kullanarak screenshot alın ve bir File olarak kaydedin

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- geçici dosyayı değer olarak asıl kaydedilecek File'a kopyalayın

        FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);

        ReusableMethods.bekle(3);


    }

}
