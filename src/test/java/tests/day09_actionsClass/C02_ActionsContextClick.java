package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;

public class C02_ActionsContextClick extends TestBase {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        // 2- "DGI Drones" üzerinde sağ click yapın
        // 1.adım actions objesi oluşturalım
        Actions actions = new Actions(driver);
        // 2.adım kullanacağımız WebElementi locate edip kaydedelim
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.bekle(1);
        // 3.adım actions objesi ve kaydettiğimiz webElement ile istenen action'i gerçekleştirelim
        actions.contextClick(dgiDronesElementi).perform();
        ReusableMethods.bekle(2);


        // 3- Alert'te çıkan yazının "Tebrikler!... Sağ click yaptınız." olduğunu test edin
        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        // 4- Tamam diyerek alert'i kapatalım

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(3);


    }

}
