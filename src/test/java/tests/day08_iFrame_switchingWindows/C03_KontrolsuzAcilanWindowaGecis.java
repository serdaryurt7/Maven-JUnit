package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_KontrolsuzAcilanWindowaGecis extends TestBase {


    @Test
    public void kontrolsuzWindowTesti() {

        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        // 2- Electronics Products yazısının görünür olduğunu test edin
        // yazi iframe içinde olduğundan, önce o iframe'i locate edip, oraya geçelim

        WebElement iFrameElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameElementi);

        WebElement electronicsYaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assert.assertTrue(electronicsYaziElementi.isDisplayed());

        // 3- Dell bilgisayar ürün isminin 'DELL Core I3 11th Gen' olduğunu test edin

        WebElement dellElementi = driver.findElement(By.id("dell-core"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assert.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        // click yapıldığında, kontrolsüz olarak yeni bir tab açıldığından
        // driver yeni tab'a geçmez, eski window'da kalır.
        // bu durumda ikinci sayfanın window handle değerini bulabilmek için, 3 adıma ihtiyacımız var

        // 1. adim : ilk window'un WHD'ini kaydedelim.
        String ilkWindowWHD = driver.getWindowHandle();

        // 4- Dell bilgisayar'a tiklayip açılan sayfada ürün fiyatının $399.00 olduğunu test edin.
        dellElementi.click();

        // 2. adim : click yapıldıktan sonra WHD'ini kaydettiğimiz ilk window'un yanına, yeni bir tab açıldı.
        //           getWindowHandles() kullanarak açık olan iki window'un, WHD'lerini bir Set olarak kaydedelim.

        Set<String> whDegerleriSeti = driver.getWindowHandles();

        // 3. adim : whDegerleriSeti ve ilkWindowWHD kullanarak ikinci Window'un WHD'ini bulup kaydedin

        String ikinciWindowWHD = "";

        for (String eachWhd : whDegerleriSeti
        ) {

            if (!eachWhd.equals(ilkWindowWHD)) {
                ikinciWindowWHD = eachWhd;
            }
        }

        // artık yeni window'a switch yapabiliriz

        driver.switchTo().window(ikinciWindowWHD);
        // açılan sayfada ürün fiyatının $399.00 olduğunu test edin.

        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        String expectedFiyat = "$399.00";
        String actualFiyat = fiyatElementi.getText();

        Assert.assertEquals(expectedFiyat, actualFiyat);


        // 5- Ilk window'a dönün ve "Here are some products." yazısının görünür olduğunu test edin

        driver.switchTo().window(ilkWindowWHD);

        WebElement hereAreYaziElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreYaziElementi.isDisplayed());

        // 6- Sayfayı kapatın

        ReusableMethods.bekle(2);


    }

}
