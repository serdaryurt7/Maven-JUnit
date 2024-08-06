package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_IFrame extends TestBase {

    @Test
    public void iFrameTesti() {

        // 1 - https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        // 2 - Elektronics Products yazısının görünür olduğunu test edin
        //       kullanacağımız elementin locate'inden %100 emin olmamıza rağmen
        //       NoSuchElementException verdi,
        //       Kontrol ettiğimizde kullanacağımız elementin bir IFrame içerisinde olduğunu gördük
        //       1. adım : Geçiş yapacağımız iframe'i locate etmek
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));
        //       2. adım : locate ettiğimiz iframe'e geçiş yapalım
        driver.switchTo().frame(electronicsIframe);
        //       3. adım : iframe içindeki elementleri kullan
        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assert.assertTrue(electronicsProductsElementi.isDisplayed());

        // 3 - Dell bilgisayar ürün isminin 'DELL Core I3 11th Gen' olduğunu test edin
        WebElement dellIsimElementi = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));

        String expectedIsim = "DELL Core I3 11th Gen";
        String actualIsim = dellIsimElementi.getText();

        Assert.assertEquals(expectedIsim,actualIsim);

        // 4 - Sağdaki bölümde görünen ürünler arasında 'Men Slim Fit' içeren en az 1 ürün olduğunu test edin
        // 5 - Fashion yazısının görünür olduğunu test edin
        // 6 - Sayfayı kapatın

        ReusableMethods.bekle(5);
    }

}
